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


            $ctrl.updateTable = function () {
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
                        console.log(errorResponse)
                    });

                $http
                    .get('/api/Supplier/count')
                    .then(function (response) {
                        $ctrl.pagination.count = response.data;

                        $ctrl.pagination.numPages = Math.ceil($ctrl.pagination.count / $ctrl.pagination.pageSize);
                        $ctrl.pagination.pageOptions = [];
                        for (var x = 1; x <= $ctrl.pagination.numPages; x++)
                            $ctrl.pagination.pageOptions.push(x);

                        if ($ctrl.page == $ctrl.numPages)
                            $ctrl.pagination.nextDisable = "disable";
                        else
                            $ctrl.pagination.nextDisable = "";

                        if ($ctrl.page <= 1)
                            $ctrl.pagination.prevDisable = "disable";
                        else
                            $ctrl.pagination.prevDisable = "";
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                console.log($ctrl.pagination)
                
            }

            $ctrl.updateTable()
            

            $ctrl.pageTo = function(page){
                $ctrl.pagination.page = page;
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

         
   

           
     





