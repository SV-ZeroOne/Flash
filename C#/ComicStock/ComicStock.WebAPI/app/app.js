var squareEyes = angular.module('squareEyes', ['ngMessages','swxSessionStorage', 'ngRoute', 'supplierModule', 'voucherModule','angularModalService', 'dashboardModule'])

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
            })
            .when('/voucher',
            {
                templateUrl: '/app/modules/voucher/templates/voucher.html'
            });

    });