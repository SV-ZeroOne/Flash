angular.module('supplierModule',[])
.controller('supplierController',
    function ($http) {

        var $ctrl = this;
        $http
            .get('/api/Supplier?page=1&pageSize=25')
            .then(function (response) {
                $ctrl.suppliers = response.data;
            })
            .catch(function (errorResponse) {
            });
        $ctrl.message = 'Supplier Management';

        $ctrl.page = function() {
            $http
                .get('/api/Supplier?page='+$ctrl.size +'&pageSize=' + $ctrl.size)
                .then(function(response) {
                    $ctrl.suppliers = response.data;
                });
        }


    });



