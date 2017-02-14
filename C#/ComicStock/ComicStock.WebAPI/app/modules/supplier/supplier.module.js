angular.module('supplierModule', [])
    .controller('supplierController',
        function($http, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Supplier Management';
            $ctrl.newSupplier = {};
            $ctrl.currentSupplier = {};
            $ctrl.modalTitle = 'Add a Supplier';


            $http
                .get('/api/Supplier?page=1&pageSize=10')
                .then(function(response) {
                    $ctrl.suppliers = response.data;
                })
                .catch(function(errorResponse) {
                });


            $ctrl.page = function() {
                $http
                    .get('/api/Supplier?page=' + $ctrl.size + '&pageSize=' + $ctrl.size)
                    .then(function(response) {
                        $ctrl.suppliers = response.data;
                    });
            }


            $ctrl.submit = function() {
                $ctrl.newSupplier.Name = $ctrl.name;
                $ctrl.newSupplier.City = $ctrl.city;
                $ctrl.newSupplier.RefNum = $ctrl.refNum;
                $http.post('/api/Supplier', $ctrl.newSupplier)
                    .then(function(response) {
                        alert("User created " + response);
                    })
                    .catch(function(errorResponse) {
                        alert('Creation failed ' + errorResponse);
                    });
            }


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
                    .catch(function(errorResponse) {
                        alert('No such supplier exists' + errorResponse.data);
                    });

            }

            $ctrl.update = function() {
                this.modalTitle = 'Edit Supplier';
            }

            $ctrl.put = function() {

            }

            $ctrl.show = function() {
                ModalService.showModal({
                    templateUrl: "/app/modules/supplier/templates/modal.html",
                    controller: "supplierController"
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
        function($http, $sessionStorage) {
            var $ctrl = this;
          
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
                    alert('No such supplier exists' + errorResponse.data);
                });

        });





   

           
     





