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

            $ctrl.suppliers = {};

            $ctrl.pageSizeOptions = [10,25,50,100];
            $ctrl.pageSize = 25;

            $ctrl.pageOptions = [];
            $ctrl.page = 1;

            $ctrl.count = 0;
            $ctrl.numPages = 0;

            $ctrl.prevDisable = "disable"
            $ctrl.nextDisable = "disable"


            $ctrl.updateTable = function(){
                $http
                    .get('/api/Supplier?page=' + $ctrl.page + '&pageSize=' + $ctrl.pageSize)
                    .then(function(response) {
                        $ctrl.suppliers = response.data;
                    })
                    .catch(function(errorResponse) {
                    });

                $http
                    .get('/api/Supplier/count')
                    .then(function (response) {
                        $ctrl.count = response.data;

                        $ctrl.numPages = Math.ceil($ctrl.count / $ctrl.pageSize);
                        $ctrl.pageOptions = [];
                        for (var x = 1; x <= $ctrl.numPages; x++)
                            $ctrl.pageOptions.push(x);

                        if ($ctrl.page == $ctrl.numPages)
                            $ctrl.nextDisable = "disable";
                        else
                            $ctrl.nextDisable = "";

                        if ($ctrl.page <= 1)
                            $ctrl.prevDisable = "disable";
                        else
                            $ctrl.prevDisable = "";
                    })
                    .catch(function (errorResponse) {
                        Console.log(errorResponse)
                    });

                
            }

            $ctrl.updateTable()
            

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

         
   

           
     





