angular.module('supplierModule', [])
    .controller('supplierController',
        function ($http, ModalService) {

            var $ctrl = this;
            $http
                .get('/api/Supplier?page=1&pageSize=25')
                .then(function(response) {
                    $ctrl.suppliers = response.data;
                })
                .catch(function(errorResponse) {
                });
            $ctrl.message = 'Supplier Management';
            $ctrl.modalTitle = 'Add a New Supplier';

            $ctrl.page = function() {
                $http
                    .get('/api/Supplier?page=' + $ctrl.size + '&pageSize=' + $ctrl.size)
                    .then(function(response) {
                        $ctrl.suppliers = response.data;
                    });
            }
            $ctrl.newSupplier = {};

            $ctrl.submit = function () {
                $ctrl.newSupplier.Name = $ctrl.name;
                $ctrl.newSupplier.City = $ctrl.city;
                $ctrl.newSupplier.RefNum = $ctrl.refNum;
                $http.post('/api/Supplier', $ctrl.newSupplier)
                    .then(function(response) {
                        alert("User created " +response);
                    })
                    .catch(function(errorResponse) {
                        alert('Creation failed ' + errorResponse);
                    });
            }
         
           
            $ctrl.show = function() {
                ModalService.showModal({
                    templateUrl: "/app/modules/supplier/templates/modal.html",
                    controller: "supplierController"
                }).then(function(modal) {

                    modal.element.modal();
                    modal.close.then(function(result) {
                        console.log(result);
                    });

                });
            }
          
        });

         
   

           
     





