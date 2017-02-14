angular.module('orderModule', [])
    .controller('orderController',
        function($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Order Management';

            $ctrl.suppliers = [];
            $ctrl.supplierQuotes = [];

            $ctrl.order = {
                Supplier: {
                    Id: 3
                },
                IssueOrders: [
                ]
            }

/*
            {
                QuantityOrdered: 0,
                    Issue: {
                    Id: 2328
                },
                SupplierQuote: {
                    Id: 24004
                }
            }
*/

            $ctrl.updateTable = function () {
                console.log("Update the table");
                if ($ctrl.search == "") $http
                    .get('/api/Supplier?page=1&pageSize=9999')
                    .then(function (response) {
                        $ctrl.suppliers = response.data;
                        console.log($ctrl.suppliers);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
            }

            $ctrl.updateTable()

            $rootScope.$on('updateTheTablePlease', function(event) {
                $ctrl.updateTable();
            });
            

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
    .controller('modalOrder',
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


        }).controller('modalAddOrder',
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





   

           
     





