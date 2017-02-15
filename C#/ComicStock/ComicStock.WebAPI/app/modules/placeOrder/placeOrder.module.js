angular.module('placeOrderModule', [])
    .controller('placeOrderController',
        function($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Order Management';
            $ctrl.issueMessage = "";

            $ctrl.suppliers = [];
            $ctrl.supplierQuotes = [];

            $ctrl.order = {
                Total: 0,
                Supplier: {
                    Id: -1,
                    Name: "Choose supplier"
                },
                IssueOrders: [
                ]
            }

            $ctrl.updateTable = function () {
                console.log("Update the suppliers");
                $http
                    .get('/api/Supplier?page=1&pageSize=9999')
                    .then(function (response) {
                        $ctrl.suppliers = response.data;
                        $ctrl.order.Supplier = $ctrl.suppliers[0];
                        $ctrl.updateQuotes();
                        console.log($ctrl.suppliers);
                        console.log($ctrl.order);
                        console.log("success");
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
            }

            $ctrl.updateQuotes = function () {
                console.log("Update the quotes");
                $http
                    .get('/api/Supplier/'+ $ctrl.order.Supplier.Id)
                    .then(function (response) {
                        $ctrl.supplierQuotes = response.data.SupplierQuotes;
                        $ctrl.issueMessage = "Add Issues to your Order:";
                        console.log($ctrl.supplierQuotes);
                        console.log("success");
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
            }

            $ctrl.addToOrder = function (supplierQuote) {
                console.log("Added to order")
                $ctrl.order.IssueOrders.push({
                    QuantityOrdered: 1,
                    SupplierQuote: supplierQuote,
                    Issue: supplierQuote.Issue
                });
                $ctrl.updateOrderTotal();
            }

            $ctrl.updateTable()

            $rootScope.$on('updateTheTablePlease', function(event) {
                $ctrl.updateTable();
            });

            $ctrl.decreaseQty = function (issueOrder) {
                if (issueOrder.QuantityOrdered == 1)
                    return;
                issueOrder.QuantityOrdered = issueOrder.QuantityOrdered - 1;
                $ctrl.updateOrderTotal();
            }

            $ctrl.increaseQty = function (issueOrder) {
                issueOrder.QuantityOrdered = issueOrder.QuantityOrdered + 1;
                $ctrl.updateOrderTotal();
            }

            $ctrl.updateOrderTotal = function(){
                $ctrl.order.Total = 0;
                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++)
                    $ctrl.order.Total += $ctrl.order.IssueOrders[x].SupplierQuote.Price * $ctrl.order.IssueOrders[x].QuantityOrdered;
            }

            $ctrl.placeOrder = function(){
                $http
                    .post('/api/Order', $ctrl.order)
                    .then(function (response) {
                        swal('Success', 'Order placed', 'success');
                        $ctrl.order = {
                            Total: 0,
                            Supplier: {
                                Id: -1,
                                Name: "Choose supplier"
                            },
                            IssueOrders: [
                            ]
                        }
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', errorResponse);
                    });

            }

            $ctrl.removeFromOrder = function(issueOrder) {
                for(var x = 0; x < $ctrl.order.IssueOrders.length; x++){
                    if ($ctrl.order.IssueOrders[x].SupplierQuote.Id == issueOrder.SupplierQuote.Id)
                        $ctrl.order.IssueOrders.splice(x, x + 1)
                }
                $ctrl.updateOrderTotal();
            }

            

            $ctrl.pageTo = function(page){
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            }



            $ctrl.edit = function(id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Supplier';

                $http
                    .get('/api/Supplier/' +id)
                    .then(function(response) {
                        $ctrl.name = response.data.Name;
                        $ctrl.city = response.data.City;
                        $ctrl.refNum = response.data.RefNum;

                        ModalService.showModal({
                            templateUrl: "/app/modules/supplier/templates/modalEdit.html",
                            controller: 'modalOrder'
           
                        }).then(function(modal) {

                            modal.element.modal();
                            modal.close.then(function(result) {
                                console.log(result);
                            });
                        });
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error')
                        
                    });

            }

            $ctrl.show = function() {
                ModalService.showModal({
                    templateUrl: "/app/modules/supplier/templates/modal.html",
                    controller: "modalAddOrder"
                }).then(function(modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function(result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalplaceOrder',
        function($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newSupplier = {};
          
            $ctrl.modalTitle = 'Edit a Order';



            $http
                .get('/api/Supplier/' + $sessionStorage.get('ID'))
                .then(function(response) {
                        $ctrl.name = response.data.Name;
                        $ctrl.city = response.data.City;
                        $ctrl.refNum = response.data.RefNum;
                    }
                )
                .catch(function(errorResponse) {
                    swal('Error','No such supplier exists','error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Order fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newSupplier.Id = $sessionStorage.get('ID');
                $ctrl.newSupplier.Name = $ctrl.name;
                $ctrl.newSupplier.City = $ctrl.city;
                $ctrl.newSupplier.RefNum = $ctrl.refNum;


                $http
                    .put('/api/Supplier/' + $sessionStorage.get('ID'), $ctrl.newSupplier)
                    .then(function (response) {
                        $scope.$emit('updateTheTablePlease');
                        swal(
                            'Good job!',
                            'User updated',
                            'success'
                        );
                    })
                    .catch(function (errorResponse) {
                        swal('Error','Update failed ','error');
                    });

            }


        }).controller('modalAddplaceOrder',
        function($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newSupplier = {};

            $ctrl.modalTitle = 'Add a Order';

            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'User fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newSupplier.Name = $ctrl.name;
                $ctrl.newSupplier.City = $ctrl.city;
                $ctrl.newSupplier.RefNum = $ctrl.refNum;
                $http.post('/api/Supplier', $ctrl.newSupplier)
                    .then(function(response) {
                        swal('Success', 'Order created', 'success');
                        $scope.$emit('updateTheTablePlease');
                    })
                    .catch(function(errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }
        });;