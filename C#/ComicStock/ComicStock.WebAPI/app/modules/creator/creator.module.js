angular.module('creatorModule', [])
    .controller('creatorController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Creator Management';
            $ctrl.newCreator = {};
            $ctrl.currentCreator = {};
            $ctrl.modalTitle = 'Add a Creator';

            $ctrl.creators = {};
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
                    .get('/api/Creator?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.creators = response.data;
                        console.log($ctrl.creators);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                    .get('/api/Creator/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.creators = response.data;
                        console.log($ctrl.creators);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Creator/count')
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

            $ctrl.role =function(id) {
                $sessionStorage.put('creatorId', id);
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
                    .get('/api/Creator/' + id)
                    .then(function (response) {
                        $ctrl.name = response.data.Name;
                        $ctrl.country = response.data.Country;
                        $ctrl.tax = response.data.TaxRef;
                        $ctrl.email = response.data.Email;

                        ModalService.showModal({
                            templateUrl: "/app/modules/creator/templates/modalEdit.html",
                            controller: 'modalCreatorController'

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
                    templateUrl: "/app/modules/creator/templates/modal.html",
                    controller: "modalCreatorAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalCreatorController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newCreator = {};

            $ctrl.modalTitle = 'Edit a Creator';



            $http
                .get('/api/Creator/' + $sessionStorage.get('ID'))
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














