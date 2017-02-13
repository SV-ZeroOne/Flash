var squareEyes = angular.module('squareEyes', ['ngRoute', 'supplierModule'])

.config(function ($routeProvider) {
    $routeProvider

        // route for the index page
        .when('/',
        {
            templateUrl: '/app/index.html'
            //  controller: 'mainController'
        })

        // route for the voucher page
        .when('/supplier',
        {
            templateUrl: '/app/modules/supplier/templates/supplier.html'
            // controller: 'supplierController'
        });

});