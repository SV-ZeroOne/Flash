angular.module('placeOrderModule', [])
    .controller('placeOrderController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Order Management';
            $ctrl.issueMessage = "";

            $ctrl.suppliers = [];
            $ctrl.supplierQuotes = [];

            $ctrl.order = {
                Total: 0,
                Supplier: null,
                IssueOrders: [
                ]
            }

            $ctrl.updateSuppliers = function () {
                console.log("Update the suppliers");
                $http
                    .get('/api/Supplier?page=1&pageSize=9999')
                    .then(function (response) {
                        $ctrl.suppliers = response.data;
                        $ctrl.order.Supplier = $ctrl.suppliers[0];
                        $ctrl.updateQuotes();
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
            }

            $ctrl.updateQuotes = function () {
                console.log("Update the quotes");
                $ctrl.supplierQuotes = []
                $http
                    .get('/api/Supplier/' + $ctrl.order.Supplier.Id)
                    .then(function (response) {
                        $ctrl.supplierQuotes = response.data.SupplierQuotes;
                        $ctrl.issueMessage = "Add Issues to your Order:";
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
            }

            $ctrl.validateQty = function (issueOrders) {
                if (issueOrders.QuantityOrdered < 1)
                    issueOrders.QuantityOrdered = 1;
                $ctrl.updateOrderTotal();
            }

            $ctrl.addToOrder = function (supplierQuote) {
                console.log("Added to order")
                $ctrl.order.IssueOrders.push({
                    QuantityOrdered: 1,
                    SupplierQuote: supplierQuote,
                    Issue: supplierQuote.Issue
                });
                $ctrl.updateOrderTotal();
            }

            $ctrl.updateSuppliers()

            $rootScope.$on('updateTheTablePlease', function (event) {
                $ctrl.updateTable();
            });

            $ctrl.decreaseQty = function (issueOrder) {
                if (issueOrder.QuantityOrdered == 1)
                    return;
                issueOrder.QuantityOrdered = issueOrder.QuantityOrdered - 1;
                $ctrl.updateOrderTotal();
            }

            $ctrl.increaseQty = function (issueOrder) {
                issueOrder.QuantityOrdered = issueOrder.QuantityOrdered + 1;
                $ctrl.updateOrderTotal();
            }

            $ctrl.updateOrderTotal = function () {
                $ctrl.order.Total = 0;
                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++)
                    $ctrl.order.Total += $ctrl.order.IssueOrders[x].SupplierQuote.Price * $ctrl.order.IssueOrders[x].QuantityOrdered;
            }

            $ctrl.placeOrder = function () {
                $http
                    .post('/api/Order', $ctrl.order)
                    .then(function (response) {
                        swal('Success', 'Order placed', 'success');
                        $ctrl.order = {
                            Total: 0,
                            Supplier: {
                                Id: -1,
                                Name: "Choose supplier"
                            },
                            IssueOrders: [
                            ]
                        }
                    })
                    .catch(function (errorResponse) {
                        swal('Oops...', 'Something went wrong!', errorResponse);
                    });

            }

            $ctrl.removeFromOrder = function (issueOrder) {
                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++) {
                    if ($ctrl.order.IssueOrders[x].SupplierQuote.Id == issueOrder.SupplierQuote.Id)
                        $ctrl.order.IssueOrders.splice(x, 1)
                }
                $ctrl.updateOrderTotal();
            }

            $ctrl.pageTo = function (page) {
                $ctrl.pagination.page = page;
                $ctrl.updateTable();
            }


        });