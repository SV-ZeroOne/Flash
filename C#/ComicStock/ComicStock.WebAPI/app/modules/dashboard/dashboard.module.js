angular.module('dashboardModule',[])
    .controller('mainController', function ($http, $rootScope, ModalService, $sessionStorage) {
        var $ctrl = this;
        $ctrl.message = 'Dashboard';
        $ctrl.issueCount;
        $ctrl.stockCount;
        $ctrl.stocks = {};
        $ctrl.availableStock;
        $ctrl.vouchersUsed = 0;

        $http.get('/api/Issues/count')
        .then(function (response) {
            $ctrl.issueCount = response.data;
        })
        .catch(function (errorResponse)
        {
            console.log(errorResponse);
        });

        $http.get('/api/Stock/count')
        .then(function (response) {
            $ctrl.stockCount = response.data;
        })
        .catch(function (errorResponse)
        {
            console.log(errorResponse);
        });

        $http.get('/api/Creator/count')
        .then(function (response) {
            $ctrl.creatorCount = response.data;
        })
        .catch(function (errorResponse) {
            console.log(errorResponse);
        });

        $http.get('/api/Order/count')
        .then(function (response) {
            $ctrl.orderCount = response.data;
        })
        .catch(function (errorResponse) {
            console.log(errorResponse);
        });

        $http.get('/api/Voucher/count')
        .then(function (response) {
            $ctrl.voucherCount = response.data;
        })
        .catch(function (errorResponse) {
            console.log(errorResponse);
        });
        $ctrl.vouchersUsed;
        //$http
        //.get('/api/Voucher?page=1&pageSize=30')
        //.then(function (response) {
        //    $ctrl.vouchers = response.data;
        //    for (var i = 0; i < $ctrl.vouchers.length() ; i++) {
        //        if ($ctrl.vouchers[i].RedeemDate != null) {
        //            $ctrl.vouchersUsed++;
        //        }
        //    }
        //    console.log($ctrl.vouchers);
        //})
        //.catch(function (errorResponse) {
        //    console.log(errorResponse);
        //});
  


        //$http
        //.get('/api/Stock?page=' + 1 + '&pageSize=' + 1000)
        //.then(function (response) {
        //    $ctrl.stocks = response.data;
        //    for (var i = 0; i <  $ctrl.stocks.length(); i++) {
        //        $ctrl.availableStock += $ctrl.stocks[i].AvailableQuantity;
        //    }

        //    console.log($ctrl.stocks);
        //})
        //.catch(function (errorResponse) {
        //    console.log(errorResponse)
        //});


});