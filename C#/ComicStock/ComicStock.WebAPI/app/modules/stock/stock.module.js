angular.module('stockModule', [])
    .controller('stockController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Stock Management';
            $ctrl.newStock = {};
            $ctrl.currentStock = {};
            $ctrl.modalTitle = 'Add Stock';

            $ctrl.stocks = {};
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
                    .get('/api/Stock?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.stocks = response.data;
                        console.log($ctrl.stocks);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                    .get('/api/Stock/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.stocks = response.data;
                        console.log($ctrl.stocks);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Stock/count')
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

            $ctrl.updateTable()

            $rootScope.$on('updateTheTablePlease', function (event) {
                $ctrl.updateTable();
            });


            $ctrl.pageTo = function (page) {
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            }




            $ctrl.edit = function (id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Stock';

                $http
                    .get('/api/Stock/' + id)
                    .then(function (response) {
                        $ctrl.title = response.data.Issue.Title;
                        $ctrl.seriesNumber = response.data.Issue.SeriesNumber;
                        $ctrl.condition = response.data.Condition;
                        $ctrl.availableQty = response.data.AvailableQuantity;
                        $ctrl.price = response.data.Price;
                        $ctrl.conditions = ["Very Fine", "Fine", "Average", "Poor"];

                        ModalService.showModal({
                            templateUrl: "/app/modules/stock/templates/modalEdit.html",
                            controller: 'modalStockController'

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
                    templateUrl: "/app/modules/stock/templates/modal.html",
                    controller: "modalStockAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalStockController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newStock = {};

            $ctrl.modalTitle = 'Edit Stock';



            $http
                .get('/api/Stock/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.title = response.data.Issue.Title;
                    $ctrl.seriesNumber = response.data.Issue.SeriesNumber;
                    $ctrl.condition = response.data.Condition;
                    $ctrl.availableQty = response.data.AvailableQuantity;
                    $ctrl.price = response.data.Price;
                    $ctrl.conditions = ["Very Fine", "Fine", "Average", "Poor"];
                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such stock exists', 'error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Stock fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newStock.Id = $sessionStorage.get('ID');
                $ctrl.newStock.Condition = $ctrl.condition;
                $ctrl.newStock.AvailableQuantity = $ctrl.availableQty;
                $ctrl.newStock.Price = $ctrl.price;


                $http
                    .put('/api/Stock/' + $sessionStorage.get('ID'), $ctrl.newStock)
                    .then(function (response) {
                        $scope.$emit('updateTheTablePlease');
                        swal(
                            'Good job!',
                            'Voucher updated',
                            'success'
                        );
                    })
                    .catch(function (errorResponse) {
                        swal('Error', 'Update failed ', 'error');
                    });

            }


        }).controller('modalStockAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newStock = {};

            $ctrl.modalTitle = 'Add Stock';



            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Stock fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newStock.Condition = $ctrl.condition;
                $ctrl.newStock.AvailableQuantity = $ctrl.availableQty;
                $ctrl.newStock.Price = $ctrl.price;
                $http.post('/api/Stock', $ctrl.newStock)
                    .then(function (response) {
                        swal('Success', 'Stock created', 'success');
                        console.log("success1");
                        $scope.$emit('updateTheTablePlease');
                        console.log("success2");
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }
        });;
