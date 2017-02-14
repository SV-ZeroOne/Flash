var squareEyes = angular.module('squareEyes', ['swxSessionStorage', 'ngRoute', 'supplierModule', 'angularModalService', 'dashboardModule'])

.config(function ($routeProvider) {
    $routeProvider
        // route for the index page
        .when('/',
        {
            templateUrl: '/app/modules/dashboard/templates/dashboard.html'
            //  controller: 'mainController'
        })

        // route for the voucher page
        .when('/supplier',
        {
            templateUrl: '/app/modules/supplier/templates/supplier.html'
            // controller: 'supplierController'
        });

});