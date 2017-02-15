angular.module('issueStockModule', [])
    .controller('issueStockController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = "";
            $ctrl.newStock = {};
            $ctrl.currentCreator = {};
            $ctrl.modalTitle = 'Add an Issue Stock';

            $ctrl.stock = {};
            $ctrl.issue = {};
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

            $ctrl.updateTable = function() {

                $http
                    .get('/api/Issues/' + $sessionStorage.get('issueId'))
                    .then(function(response) {
                        $ctrl.issue = response.data;
                        $ctrl.message = response.data.Name;

                    })
                    .catch(function(errorResponse) {
                        console.log(errorResponse)

                    });
            }

            $ctrl.updateTable();

            $ctrl.edit = function (id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Issue Stock';

                $http
                    .get('/api/Stock/' + id)
                    .then(function (response) {
                        $ctrl.condition = response.data.Condition;
                        $ctrl.availableQty = response.data.AvailableQuantity;
                        $ctrl.price = response.data.Price;

                        ModalService.showModal({
                            templateUrl: "/app/modules/issueStock/templates/modalEdit.html",
                            controller: 'modalIssueStockController'

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
                    templateUrl: "/app/modules/issueStock/templates/modal.html",
                    controller: "modalIssueStockAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalIssueStockController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newIssue = {};

            $ctrl.modalTitle = 'Edit Issue Stock';



            $http
                .get('/api/Stock/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.condition = response.data.Condition;
                    $ctrl.availableQty = response.data.AvailableQuantity;
                    $ctrl.price = response.data.Price;
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
                $ctrl.newStock.AvailableQuantity = $ctrl.avaliableQty;
                $ctrl.newStock.Price = $ctrl.price;


                $http
                    .put('/api/Stock/' + $sessionStorage.get('ID'), $ctrl.newStock)
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


        }).controller('modalIssueAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newStock = {};

            $ctrl.modalTitle = 'Add an Stock to Issue';

            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Issue Stock not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newStock.Id = $sessionStorage.get('ID');
                $ctrl.newStock.Condition = $ctrl.condition;
                $ctrl.newStock.AvailableQuantity = $ctrl.avaliableQty;
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














