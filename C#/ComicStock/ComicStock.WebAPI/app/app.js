var squareEyes = angular.module('squareEyes', ['ngMessages','swxSessionStorage', 'ngRoute', 'orderModule', 'supplierModule','creatorModule', 'voucherModule','angularModalService', 'dashboardModule'])

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
            })
            .when('/creator',
            {
                templateUrl: '/app/modules/creator/templates/creator.html'
            })
            .when('/order',
            {
                templateUrl: '/app/modules/order/templates/order.html'
            });


    });