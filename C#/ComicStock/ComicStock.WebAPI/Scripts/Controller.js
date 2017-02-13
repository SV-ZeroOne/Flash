squareEyes.config(function ($routeProvider) {
    $routeProvider

        // route for the index page
        .when('/',
        {
            templateUrl: 'index.html',
            controller: 'mainController'
        })

        // route for the voucher page
        .when('/supplier',
        {
            templateUrl: 'supplier.html',
            controller: 'supplierController'
        });

});


squareEyes.controller('mainController', function () {
    var $ctrl = this;
    $ctrl.message = 'Dashboard';
});

squareEyes.controller('supplierController',
    function($http) {

        var $ctrl = this;
        $http
            .get('/api/Supplier?page=1&pageSize=25')
            .then(function(response) {
                $ctrl.suppliers = response.data;
            })
            .catch(function(errorResponse) {
            });
        $ctrl.message = 'Supplier Management';

});


