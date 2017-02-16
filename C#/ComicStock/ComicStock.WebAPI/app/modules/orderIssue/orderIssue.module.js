angular.module('orderIssueModule', [])
    .controller('orderIssueController',
        function($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = "";
            $ctrl.newOrderIssue = {};
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
                        $ctrl.issues = response.data.IssueOrders;
                        $ctrl.message = "Issues in Order";

                    })
                    .catch(function(errorResponse) {
                        console.log(errorResponse);

                    });

              
            }

            $ctrl.updateTable();


        });
    
       














