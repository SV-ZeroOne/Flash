angular.module('viewOrdersModule', [])
    .controller('viewOrdersController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Order Management';
            $ctrl.newviewOrder = {};
            $ctrl.currentviewOrder = {};
            $ctrl.modalTitle = 'Place an Order';

            $ctrl.orders = {};
            $ctrl.search = "";

            $ctrl.pagination = {

                pageSizeOptions: [10, 25, 50, 100],
                pageSize: 25,

                pageOptions: [],
                page: 1,

                count: 0,
                numPages: 0,

                prevDisable: "disable",
                nextDisable: "disable"
            }


            $ctrl.updateTable = function () {
                console.log("Update the table");
                if ($ctrl.search == "") $http
                    .get('/api/Order?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.orders = response.data;
                        console.log($ctrl.orders);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });
                else $http
                    .get('/api/Order/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.orders = response.data;
                        console.log($ctrl.orders);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Order/count')
                    .then(function (response) {
                        $ctrl.pagination.count = response.data;

                        $ctrl.pagination.numPages = Math.ceil($ctrl.pagination.count / $ctrl.pagination.pageSize);
                        $ctrl.pagination.pageOptions = [];
                        if ($ctrl.pagination.page - 3 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 3);
                        }
                        if ($ctrl.pagination.page - 2 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 2);
                        }
                        if ($ctrl.pagination.page - 1 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 1);
                        }
                        $ctrl.pagination.pageOptions.push($ctrl.pagination.page);
                        if ($ctrl.pagination.page + 1 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 1);
                        }
                        if ($ctrl.pagination.page + 2 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 2);
                        }
                        if ($ctrl.pagination.page + 3 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 3);
                        }
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });
                console.log($ctrl.pagination);

            }

            $ctrl.updateTable();

            $rootScope.$on('updateTheTablePlease', function (event) {
                $ctrl.updateTable();
            });

            $ctrl.role = function (id) {
                $sessionStorage.put('orderId', id);
                window.location = "#!/role";
            }

            $ctrl.pageTo = function (page) {
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            }




            $ctrl.edit = function (id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Order';

                $http
                    .get('/api/Order/' + id)
                    .then(function (response) {
                        $ctrl.total = response.data.Total;
                        $ctrl.shipref = response.data.ShipmentRef;
                        $ctrl.shipdate = response.data.ShipmentDate;
                        $ctrl.status = response.data.DeliveryStatus;
                        $ctrl.date = response.data.OrderDate;

                        ModalService.showModal({
                            templateUrl: "/app/modules/viewOrders/templates/modalEdit.html",
                            controller: 'modalViewOrdersController'

                        }).then(function (modal) {

                            modal.element.modal();
                            modal.close.then(function (result) {
                                console.log(result);
                            });
                        });
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error')

                    });

            }

            $ctrl.show = function () {
                ModalService.showModal({
                    templateUrl: "/app/modules/viewOrders/templates/modal.html",
                    controller: "modalViewOrdersAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalViewOrdersController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newOrder = {};

            $ctrl.modalTitle = 'Edit an Order';



            $http
                .get('/api/Order/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.total = response.data.Total;
                    $ctrl.date = response.data.OrderDate;
                    $ctrl.shipref = response.data.ShipmentRef;
                    $ctrl.shipdate = response.data.ShipmentDate;
                    $ctrl.status = response.data.DeliveryStatus;
                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such order exists', 'error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Order fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newOrder.Id = $sessionStorage.get('ID');
                $ctrl.newOrder.Total = $ctrl.total;
                $ctrl.newOrder.ShipmentRef = $ctrl.shipref;
                $ctrl.newOrder.ShipmentDate = $ctrl.shipdate;
                $ctrl.newOrder.DeliveryStatus = $ctrl.status;
                $ctrl.newOrder.OrderDate = $ctrl.date;

                $http
                    .put('/api/Order/' + $sessionStorage.get('ID'), $ctrl.newOrder)
                    .then(function (response) {
                        $scope.$emit('updateTheTablePlease');
                        swal(
                            'Good job!',
                            'Order updated',
                            'success'
                        );
                    })
                    .catch(function (errorResponse) {
                        swal('Error', 'Update failed ', 'error');
                    });

            }


        });














