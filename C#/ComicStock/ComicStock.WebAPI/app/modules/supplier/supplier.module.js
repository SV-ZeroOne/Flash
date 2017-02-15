angular.module('supplierModule', [])
    .controller('supplierController',
        function($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Supplier Management';
            $ctrl.newSupplier = {};
            $ctrl.currentSupplier = {};
            $ctrl.modalTitle = 'Add a Supplier';

            $ctrl.suppliers = {};
            $ctrl.search = "";

            $ctrl.pagination = {

                pageSizeOptions : [10,25,50,100],
                pageSize : 25,

                pageOptions : [],
                page : 1,

                count : 0,
                numPages : 0,

                prevDisable : "disable",
                nextDisable : "disable"
            }

            $ctrl.deactivate = function (id) {

                swal({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#d33',
                    cancelButtonColor: '#3085d6',
                    confirmButtonText: 'Yes, deactivate the supplier!'
                }).then(function () {
                    $http

                    .put('/api/Supplier/deactivate?id=' + id)
                        .then(function (response) {
                            swal(
                'Deactivated!',
                'The supplier was deactivated',
                'success'
              )
                            $ctrl.updateTable();
                        }
                        );

                })

               .catch(function (errorResponse) {
                   swal('Error', 'No such supplier exists', 'error');
               });
            }

            $ctrl.updateTable = function () {
                console.log("Update the table");
                if ($ctrl.search == "") $http
                    .get('/api/Supplier?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.suppliers = response.data;
                        console.log($ctrl.suppliers);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                    .get('/api/Supplier/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function(response) {
                        $ctrl.suppliers = response.data;
                        console.log($ctrl.suppliers);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Supplier/count')
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

            $rootScope.$on('updateTheTablePlease', function(event) {
                $ctrl.updateTable();
            });


            $ctrl.pageTo = function(page) {
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            };

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
                            controller: 'modalController'
           
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
                    controller: "modalAddController"
                }).then(function(modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function(result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalController',
        function($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newSupplier = {};
          
            $ctrl.modalTitle = 'Edit a Supplier';



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
                    swal('Failed', 'Supplier fields not valid - please try again', 'error');
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


        }).controller('modalAddController',
        function($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newSupplier = {};

            $ctrl.modalTitle = 'Add a Supplier';



            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Supplier fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newSupplier.Name = $ctrl.name;
                $ctrl.newSupplier.City = $ctrl.city;
                $ctrl.newSupplier.RefNum = $ctrl.refNum;
                $http.post('/api/Supplier', $ctrl.newSupplier)
                    .then(function(response) {
                        swal('Success','Supplier created','success');
                        console.log("success1");
                        $scope.$emit('updateTheTablePlease');
                        console.log("success2");
                    })
                    .catch(function(errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }



        });;





   

           
     





