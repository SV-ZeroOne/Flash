var squareEyes = angular.module('squareEyes', ['ngMessages', 'swxSessionStorage', 'ngRoute', 'issueStockModule', 'orderIssueModule', 'placeOrderModule', 'issueModule', 'viewOrdersModule', 'supplierModule', 'creatorModule', 'stockModule', 'voucherModule', 'angularModalService', 'creatorRoleModule', 'dashboardModule'])



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
        .when('/orderIssue',
        {
            templateUrl: '/app/modules/orderIssue/templates/orderIssue.html'
        })
        .when('/voucher',
        {
            templateUrl: '/app/modules/voucher/templates/voucher.html'
        })
        .when('/stock',
        {
            templateUrl: '/app/modules/stock/templates/stock.html'
        })
        .when('/role',
        {
            templateUrl: '/app/modules/creatorRole/templates/role.html'
        })
        .when('/issueStock',
        {
            templateUrl: '/app/modules/issueStock/templates/issueStock.html'
        })
         .when('/order',
        {
            templateUrl: '/app/modules/viewOrders/templates/order.html'
        })
        .when('/creator',
        {
            templateUrl: '/app/modules/creator/templates/creator.html'
        })
        .when('/issue',
        {
            templateUrl: '/app/modules/issue/templates/issue.html'
		})
		.when('/placeOrder',
        {
            templateUrl: '/app/modules/placeOrder/templates/placeOrder.html'
        });

    });
