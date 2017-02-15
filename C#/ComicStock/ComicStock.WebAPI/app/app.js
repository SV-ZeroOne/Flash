var squareEyes = angular.module('squareEyes', ['ngMessages', 'swxSessionStorage', 'ngRoute', 'placeOrderModule', 'supplierModule', 'creatorModule', 'voucherModule', 'angularModalService', 'dashboardModule'])

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
            .when('/placeOrder',
            {
                templateUrl: '/app/modules/placeOrder/templates/placeOrder.html'
            });


    });