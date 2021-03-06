angular.module('voucherModule', [])
    .controller('voucherController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Voucher Management';
            $ctrl.newVoucher = {};
            $ctrl.currentVoucher = {};
            $ctrl.modalTitle = 'Add a Voucher';

            $ctrl.vouchers = {};
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
                    .get('/api/Voucher?page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.vouchers = response.data;
                        console.log($ctrl.vouchers);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                    .get('/api/Voucher/search?search=' + $ctrl.search + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        $ctrl.vouchers = response.data;
                        console.log($ctrl.vouchers);
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });

                $http
                    .get('/api/Voucher/count')
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


            $ctrl.pageTo = function (page) {
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            }

            $ctrl.deactivate = function (id) {

                swal({
                    title: 'Are you sure?',
                    text: "You won't be able to revert this!",
                    type: 'warning',
                    showCancelButton: true,
                    confirmButtonColor: '#d33',
                    cancelButtonColor: '#3085d6',
                    confirmButtonText: 'Yes, deactivate the voucher!'
                }).then(function () {
                    $http

                    .put('/api/Voucher/deactivate?id=' + id)
                        .then(function (response) {
                            swal(
                'Deactivated!',
                'Your voucher was deactivated',
                'success'
              )
                            $ctrl.updateTable();
                        }
                        );

                })

               .catch(function (errorResponse) {
                   swal('Error', 'No such voucher exists', 'error');
               });
            }


            $ctrl.edit = function (id) {
                $sessionStorage.put("ID", id);
                $ctrl.modalTitle = 'Edit Voucher';

                $http
                    .get('/api/Voucher/' + id)
                    .then(function (response) {
                        $ctrl.code = response.data.Code;
                        $ctrl.date = response.data.RedeemDate;
                        $ctrl.value = response.data.Value;

                        ModalService.showModal({
                            templateUrl: "/app/modules/voucher/templates/modalEdit.html",
                            controller: 'modalVoucherController'

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
                    templateUrl: "/app/modules/voucher/templates/modal.html",
                    controller: "modalVoucherAddController"
                }).then(function (modal) {
                    console.log(modal);
                    modal.element.modal();
                    modal.close.then(function (result) {
                        console.log(result);
                    });

                });
            };

        })
    .controller('modalVoucherController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newVoucher = {};

            $ctrl.modalTitle = 'Edit a Voucher';

            $http
                .get('/api/Voucher/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.code = response.data.Code;
                    $ctrl.date = response.data.RedeemDate;
                    $ctrl.value = response.data.Value;
                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such voucher exists', 'error');
                });


            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Voucher fields not valid - please try again', 'error');
                    return;
                }
                $ctrl.newVoucher.Id = $sessionStorage.get('ID');
                $ctrl.newVoucher.Code = generateCode();
                $ctrl.newVoucher.RedeemDate = $ctrl.date;
                $ctrl.newVoucher.Value = $ctrl.value;



                $http
                    .put('/api/Voucher/' + $sessionStorage.get('ID'), $ctrl.newVoucher)
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


        }).controller('modalVoucherAddController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newVoucher = {};

            $ctrl.modalTitle = 'Add a Voucher';

            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Voucher fields not valid - please try again.', 'error');
                    return;
                }
                $ctrl.newVoucher.Code = generateCode();
                $ctrl.newVoucher.RedeemDate = null;
                $ctrl.newVoucher.Value = $ctrl.value;
                $http.post('/api/Voucher', $ctrl.newVoucher)
                    .then(function (response) {
                        swal('Success', 'Voucher created', 'success');
                        console.log("success1");
                        $scope.$emit('updateTheTablePlease');
                        console.log("success2");
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', 'error');
                    });
            }
            function generateCode() {
                var text = "";
                var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

                for (var i = 0; i < 10; i++)
                    text += possible.charAt(Math.floor(Math.random() * possible.length));

                return text;
            }


        }).controller('modalVoucherController',
        function ($http, $scope, $sessionStorage) {
            var $ctrl = this;
            $ctrl.newVoucher = {};

            $ctrl.modalTitle = 'Edit a Voucher';



            $http
                .get('/api/Voucher/' + $sessionStorage.get('ID'))
                .then(function (response) {
                    $ctrl.value = response.data.Value;
                    $ctrl.code = response.data.Code;
                    $ctrl.date = response.data.RedeemDate;

                }
                )
                .catch(function (errorResponse) {
                    swal('Error', 'No such voucher exists', 'error');
                });




            $ctrl.submit = function (isFormValid) {
                if (!isFormValid) {
                    swal('Failed', 'Voucher field not valid - please try again', 'error');
                    return;
                }
                $ctrl.newVoucher.Id = $sessionStorage.get('ID');
                $ctrl.newVoucher.Code = $ctrl.code;
                $ctrl.newVoucher.Value = $ctrl.value;
                $ctrl.newVoucher.RedeemDate = $ctrl.date;


                $http
                    .put('/api/Voucher/' + $sessionStorage.get('ID'), $ctrl.newVoucher)
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


        });














