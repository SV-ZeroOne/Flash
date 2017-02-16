angular.module('orderIssueModule', [])
    .controller('orderIssueController',
        function($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = "";
            $ctrl.newOrderIssue = {};
            $ctrl.order = {};
            $ctrl.totalStockPrice = null;
            $ctrl.currentOrderIssue = {};

            $ctrl.issues = {};
            $ctrl.search = "";

            $ctrl.pagination = {
                pageSizeOptions: [10, 25, 50, 100],
                pageSize: 25,

                pageOptions: [],
                page: 1,

                count: 0,
                numPages: 0,

                prevDisable: "disable",
                nextDisable: "disable"
            }

            $ctrl.updateTable = function(id) {

                $http
                    .get('/api/Order/' + $sessionStorage.get('orderId'))
                    .then(function(response) {
                        $ctrl.order = response.data;
                        $ctrl.issues = response.data.IssueOrders;
                        $ctrl.message = "Issues in Order";
                        calculate(response.data.IssueOrders);

                    })
                    .catch(function(errorResponse) {
                        console.log(errorResponse);

                    });

              
            }
            calculate = function (issues) {
                
              for (var i = 0; i < issues.length; i++) {
  
                    var Quantity = issues[i].QuantityOrdered;
                   var StockPrice = issues[i].Issue.Stock[0].Price;
                    $ctrl.totalStockPrice += Quantity * StockPrice;
                }
                $ctrl.profit = $ctrl.totalStockPrice - $ctrl.order.Total;
            }
         
            $ctrl.updateTable();


        });
    
       














