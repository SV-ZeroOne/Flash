angular.module('issueModule', [])
    .controller('issueController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Issue Management';
            $ctrl.newIssue = {};
            $ctrl.currentIssue = {};
            $ctrl.modalTitle = 'Add Issue';

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


            $ctrl.updateTable = function () {
                console.log("Update the table");
                if ($ctrl.search == "") $http
                    .get('/api/Issues?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.issues = response.data;
                        console.log($ctrl.issues);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                    .get('/api/Issues/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.issues = response.data;
                        console.log($ctrl.issues);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Issues/count')
                    .then(function (response) {
                        $ctrl.pagination.count = response.data;

                        $ctrl.pagination.numPages = Math.ceil($ctrl.pagination.count / $ctrl.pagination.pageSize);
                        $ctrl.pagination.pageOptions = [];

                        if($ctrl.pagination.page -3 >=1)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 3);
                        }
                        if( $ctrl.pagination.page -2 >=1)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 2); 
                        }
                        if ($ctrl.pagination.page - 1 >= 1)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 1);
                        }
                        $ctrl.pagination.pageOptions.push($ctrl.pagination.page);
                        if( $ctrl.pagination.page + 1 <= $ctrl.pagination.numPages)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page+1);
                        }
                        if ($ctrl.pagination.page + 2 <= $ctrl.pagination.numPages)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 2);
                        }
                        if ($ctrl.pagination.page + 3 <= $ctrl.pagination.numPages)
                        {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 3);
                        }
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
                $ctrl.modalTitle = 'Edit Issue';

                $http
                    .get('/api/Issues/' + id)
                    .then(function (response) {
                        $ctrl.title = response.data.Title;
                        $ctrl.publicationDate = response.PublicationDate;
                        $ctrl.publisher = response.Publisher;
                        $ctrl.seriesNumber = response.data.SeriesNumber;
                        $ctrl.description = response.data.Description;

                        ModalService.showModal({
                            templateUrl: "/app/modules/issue/templates/modalEdit.html",
                            controller: 'modalIssueController'

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
                    templateUrl: "/app/modules/issue/templates/modal.html",
                    controller: "modalIssueAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalIssueController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newIssue = {};

            $ctrl.modalTitle = 'Edit Stock';



            $http
                .get('/api/Issues/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.title = response.data.Title;
                    $ctrl.publicationDate = response.PublicationDate;
                    $ctrl.publisher = response.Publisher;
                    $ctrl.seriesNumber = response.data.SeriesNumber;
                    $ctrl.description = response.data.Description;
                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such issue exists', 'error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Issue fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newIssue.Id = $sessionStorage.get('ID');
                $ctrl.newIssue.Title = $ctrl.title;
                $ctrl.newIssue.PublicationDate = $ctrl.publicationDate;
                $ctrl.newIssue.Publisher = $ctrl.publisher;
                $ctrl.newIssue.SeriesNumber = $ctrl.seriesNumber;
                $ctrl.newIssue.Description = $ctrl.description;

                $http
                    .put('/api/Issues/' + $sessionStorage.get('ID'), $ctrl.newIssue)
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


        }).controller('modalIssueAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newIssue = {};

            $ctrl.modalTitle = 'Add Issue';



            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Stock fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newIssue.Id = $sessionStorage.get('ID');
                $ctrl.newIssue.Title = $ctrl.title;
                $ctrl.newIssue.PublicationDate = $ctrl.publicationDate;
                $ctrl.newIssue.Publisher = $ctrl.publisher;
                $ctrl.newIssue.SeriesNumber = $ctrl.seriesNumber;
                $ctrl.newIssue.Description = $ctrl.description;

                $http.post('/api/Issues', $ctrl.newIssue)
                    .then(function (response) {
                        swal('Success', 'Issue created', 'success');
                        console.log("success1");
                        $scope.$emit('updateTheTablePlease');
                        console.log("success2");
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }
        });;
