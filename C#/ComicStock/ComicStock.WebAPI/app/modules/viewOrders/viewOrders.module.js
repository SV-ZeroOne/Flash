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
                        for (var x = 1; x <= $ctrl.pagination.numPages; x++)
                            $ctrl.pagination.pageOptions.push(x);

                        if ($ctrl.pagination.page == $ctrl.pagination.numPages)
                            $ctrl.pagination.nextDisable = "disable";
                        else
                            $ctrl.pagination.nextDisable = "";

                        if ($ctrl.pagination.page <= 1)
                            $ctrl.pagination.prevDisable = "disable";
                        else
                            $ctrl.pagination.prevDisable = "";
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
                $ctrl.modalTitle = 'Edit Creator';

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
            $ctrl.newCreator = {};

            $ctrl.modalTitle = 'Edit an Order';



            $http
                .get('/api/Order/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.name = response.data.Name;
                    $ctrl.country = response.data.Country;
                    $ctrl.tax = response.data.TaxRef;
                    $ctrl.email = response.data.Email;
                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such creator exists', 'error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Creator fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newCreator.Id = $sessionStorage.get('ID');
                $ctrl.newCreator.Name = $ctrl.name;
                $ctrl.newCreator.Country = $ctrl.country;
                $ctrl.newCreator.TaxRef = $ctrl.tax;
                $ctrl.newCreator.Email = $ctrl.email;


                $http
                    .put('/api/Creator/' + $sessionStorage.get('ID'), $ctrl.newCreator)
                    .then(function (response) {
                        $scope.$emit('updateTheTablePlease');
                        swal(
                            'Good job!',
                            'Creator updated',
                            'success'
                        );
                    })
                    .catch(function (errorResponse) {
                        swal('Error', 'Update failed ', 'error');
                    });

            }


        }).controller('modalViewOrdersAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newCreator = {};

            $ctrl.modalTitle = 'Add a Creator';



            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Creator fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newCreator.Name = $ctrl.name;
                $ctrl.newCreator.Country = $ctrl.country;
                $ctrl.newCreator.TaxRef = $ctrl.tax;
                $ctrl.newCreator.Email = $ctrl.email;
                $http.post('/api/Creator', $ctrl.newCreator)
                    .then(function (response) {
                        swal('Success', 'Creator created', 'success');
                        console.log("success1");
                        $scope.$emit('updateTheTablePlease');
                        console.log("success2");
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }



        });;














