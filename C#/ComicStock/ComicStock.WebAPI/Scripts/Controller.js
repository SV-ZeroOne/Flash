squareEyes.config(function ($routeProvider) {
    $routeProvider

        // route for the index page
        .when('/',
        {
            templateUrl: 'index.html',
            controller: 'mainController'
        })

        // route for the voucher page
        .when('/voucher',
        {
            templateUrl: 'voucher.html',
            controller: 'voucherController'
        });

});

squareEyes.controller('mainController', function ($scope) {
   
    $scope.message = 'Dashboard';
});

squareEyes.controller('voucherController',
    function($http) {

        var $ctrl = this;
        $http
            .get('http://localhost:55076/api/Supplier?page=1&pageSize=2')
            .then(function(response) {
                $ctrl.suppliers = response.data;
            })
            .catch(function(errorResponse) {

            });

        $ctrl.message = 'Supplier Management';


});


