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
                $ctrl.newVoucher.Code = $ctrl.code;
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
                $ctrl.newVoucher.Code = $ctrl.code;
                $ctrl.newVoucher.RedeemDate = $ctrl.date;
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



        });;














