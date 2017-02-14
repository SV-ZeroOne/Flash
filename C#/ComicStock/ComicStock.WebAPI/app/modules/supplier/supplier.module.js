angular.module('supplierModule', [])
    .controller('supplierController',
        function ($http, ModalService) {

            var $ctrl = this;
            $ctrl.message = 'Supplier Management';
            $ctrl.newSupplier = {};
            $ctrl.currentSupplier = {};
            $ctrl.modalTitle = "";
            $ctrl.name = "";
            $ctrl.city = "";
            $ctrl.refNum = "";

            $ctrl.pageSizeOptions = [10,25,50,100];
            $ctrl.pageSize = 25;

            $ctrl.pageOptions = [1, 2, 3, 4, 5];
            $ctrl.page = 1;

            $ctrl.count = 18000;


            $ctrl.updateTable = function(){
                $http
                    .get('/api/Supplier?page=' + $ctrl.page + '&pageSize=' + $ctrl.pageSize)
                    .then(function(response) {
                        $ctrl.suppliers = response.data;
                    })
                    .catch(function(errorResponse) {
                    });
            }

            $ctrl.updateTable()

            $ctrl.getPageOptions = function(){

            }

            $ctrl.pageTo = function(page){
                $ctrl.page = page;
                $ctrl.updateTable();
            }


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
           
            
            $ctrl.edit = function(id) {
                $ctrl.modalTitle = 'Edit Supplier';
                $http
                   .get('/api/Supplier/1')
               .then(function (response) {
                   $ctrl.name = response.data.Name;
                   $ctrl.city = response.data.City;
                   $ctrl.refNum = response.data.RefNum;
                   ModalService.showModal({
                       templateUrl: "/app/modules/supplier/templates/modal.html",
                       controller: "supplierController"
                   }).then(function (modal) {

                       modal.element.modal();
                       modal.close.then(function (result) {
                           console.log(result);
                       });
                   });
               })
               .catch(function (errorResponse) {
                   alert('No such supplier exists' + errorResponse.data);
               });

            }

            

            $ctrl.show = function () {
                $ctrl.modalTitle = 'Add a New Supplier';
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

         
   

           
     





