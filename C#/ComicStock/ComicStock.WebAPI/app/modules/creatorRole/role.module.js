angular.module('creatorRoleModule', [])
    .controller('creatorRoleController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = "";
            $ctrl.newCreator = {};
            $ctrl.currentCreator = {};
            $ctrl.modalTitle = 'Add an Issue/Role';

            $ctrl.issues = {};
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
                    .get('/api/Creator/' + $sessionStorage.get('creatorId'))
                    .then(function(response) {
                        $ctrl.issues = response.data;
                        $ctrl.message = response.data.Name;

                    })
                    .catch(function(errorResponse) {
                        console.log(errorResponse)

                    });
            }

            $ctrl.updateTable();

            $ctrl.edit = function (id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Issue/Role';

                $http
                    .get('/api/Creator/' + id)
                    .then(function (response) {
                        $ctrl.name = response.data.Name;
                        $ctrl.country = response.data.Country;
                        $ctrl.tax = response.data.TaxRef;
                        $ctrl.email = response.data.Email;

                        ModalService.showModal({
                            templateUrl: "/app/modules/creatorRole/templates/modalEdit.html",
                            controller: 'modalCreatorRoleController'

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
                    templateUrl: "/app/modules/creatorRole/templates/modal.html",
                    controller: "modalCreatorRoleAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalCreatorRoleController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newIssue = {};

            $ctrl.modalTitle = 'Edit Issue/Role';



            $http
                .get('/api/Creator/' + $sessionStorage.get(''))
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


        }).controller('modalCreatorAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newCreator = {};

            $ctrl.modalTitle = 'Add a Creator';


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Issue Role not valid - please try again.', 'error');
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














