angular.module('placeOrderModule', [])
    .controller('placeOrderController',
        function ($http, $rootScope, ModalService, $sessionStorage) {

            var $ctrl = this;
            $ctrl.message = 'Place an Order';
            $ctrl.issueMessage = "";

            $ctrl.suppliers = [];
            $ctrl.supplierQuotes = [];

            $ctrl.search = "";

            $ctrl.order = {
                Total: 0,
                Supplier: null,
                IssueOrders: [
                ]
            }

            $ctrl.pagination = {

                pageSizeOptions: [12, 24, 64, 128],
                pageSize: 24,

                pageOptions: [],
                page: 1,

                count: 0,
                numPages: 0,

                prevDisable: "disable",
                nextDisable: "disable"
            }

            $ctrl.updateSuppliers = function () {
                console.log("Update the suppliers");
                $ctrl.order.IssueOrders = []
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

            $ctrl.showSnackbar = function () {
                var x = document.getElementById("snackbar")
                x.className = "show";
                setTimeout(function () { x.className = x.className.replace("show", ""); }, 1300);
            }

            $ctrl.clearOrderAndUpdateQuote = function () {
                $ctrl.order.IssueOrders = []
                $ctrl.updateQuotes();

            }

            $ctrl.addQty = function () {
                console.log($ctrl.supplierQuotes)
                for (var x = 0; x < $ctrl.supplierQuotes.length; x++)
                {
                    for(var y = 0; y < $ctrl.order.IssueOrders.length; y++)
                    {
                        if ($ctrl.order.IssueOrders[y].SupplierQuote.Id == $ctrl.supplierQuotes[x].Id) {
                            $ctrl.supplierQuotes[x].Qty = $ctrl.order.IssueOrders[y].QuantityOrdered*1
                            $ctrl.order.IssueOrders.QuantityOrdered = $ctrl.supplierQuotes[x].Qty;
                        }
                    }
                }
            }

            $ctrl.updateQuotes = function () {
                console.log("Update the quotes");
                $ctrl.supplierQuotes = []
                if ($ctrl.search == "") $http
                    .get('/api/SupplierQuote?id=' + $ctrl.order.Supplier.Id + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                    .then(function (response) {
                        console.log(response.data)
                        $ctrl.supplierQuotes = response.data
                        $ctrl.addQty();
                        
                        $ctrl.issueMessage = "Add Issues to your Order:";
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse)
                    });
                else $http
                        .get('/api/SupplierQuote/search?search='+$ctrl.search+'&id=' + $ctrl.order.Supplier.Id + '&page=' + $ctrl.pagination.page + '&pageSize=' + $ctrl.pagination.pageSize)
                        .then(function (response) {
                            $ctrl.supplierQuotes = response.data
                            $ctrl.addQty();

                            $ctrl.issueMessage = "Add Issues to your Order:";
                        })
                        .catch(function (errorResponse) {
                            console.log(errorResponse)
                        });

                $http
                    .get('api/SupplierQuote/count?id=' + $ctrl.order.Supplier.Id + (($ctrl.search == "") ? "" : "&search=" + $ctrl.search))
                    .then(function (response) {
                        $ctrl.pagination.count = response.data;

                        $ctrl.pagination.numPages = Math.ceil($ctrl.pagination.count / $ctrl.pagination.pageSize);
                        $ctrl.pagination.pageOptions = [];
                        if ($ctrl.pagination.page - 3 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 3);
                        }
                        if ($ctrl.pagination.page - 2 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 2);
                        }
                        if ($ctrl.pagination.page - 1 >= 1) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page - 1);
                        }
                        $ctrl.pagination.pageOptions.push($ctrl.pagination.page);
                        if ($ctrl.pagination.page + 1 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 1);
                        }
                        if ($ctrl.pagination.page + 2 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 2);
                        }
                        if ($ctrl.pagination.page + 3 <= $ctrl.pagination.numPages) {
                            $ctrl.pagination.pageOptions.push($ctrl.pagination.page + 3);
                        }
                    })
                    .catch(function (errorResponse) {
                        console.log(errorResponse);
                    });
                console.log($ctrl.pagination);
            }

            $ctrl.validateQty = function (issueOrders) {
                if (issueOrders.QuantityOrdered < 1)
                    issueOrders.QuantityOrdered = 1;
                $ctrl.updateOrderTotal();
                $ctrl.addQty();
            }

            $ctrl.validateQuoteQty = function (supplierQuote) {
                console.log("Validate Quote Qty")
                $ctrl.updateOrderTotal();
                $ctrl.addQty();
            }

            $ctrl.addToOrder = function (supplierQuote) {
                console.log("Added to order");

                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++) {
                    if ($ctrl.order.IssueOrders[x].SupplierQuote.Id == supplierQuote.Id)
                    {
                        $ctrl.order.IssueOrders[x].QuantityOrdered += 1;
                        return;
                    }
                }

                $ctrl.order.IssueOrders.push({
                    QuantityOrdered: 1,
                    SupplierQuote: supplierQuote,
                    Issue: supplierQuote.Issue
                });
                $ctrl.addQty();
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
                $ctrl.addQty();
            }

            $ctrl.increaseQty = function (issueOrder) {
                issueOrder.QuantityOrdered = issueOrder.QuantityOrdered + 1;
                $ctrl.updateOrderTotal();
                $ctrl.addQty();
            }

            $ctrl.decreaseQuoteQty = function (supplierQuote) {
                console.log("Added to order");

                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++) {
                    if ($ctrl.order.IssueOrders[x].SupplierQuote.Id == supplierQuote.Id) {
                        $ctrl.order.IssueOrders[x].QuantityOrdered -= 1;
                        $ctrl.addQty();
                        $ctrl.updateOrderTotal();
                        return;
                    }
                }
                $ctrl.addQty();
                $ctrl.updateOrderTotal();
            }

            $ctrl.increaseQuoteQty = function (supplierQuote) {
                console.log("Added to order");

                for (var x = 0; x < $ctrl.order.IssueOrders.length; x++) {
                    if ($ctrl.order.IssueOrders[x].SupplierQuote.Id == supplierQuote.Id) {
                        $ctrl.order.IssueOrders[x].QuantityOrdered += 1;
                        $ctrl.addQty();
                        $ctrl.updateOrderTotal();
                        return;
                    }
                }

                $ctrl.order.IssueOrders.push({
                    QuantityOrdered: 1,
                    SupplierQuote: supplierQuote,
                    Issue: supplierQuote.Issue
                });
                $ctrl.addQty();
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
                        $ctrl.supplierQuotes = [];
                        console.log(response);
                        $ctrl.order = {
                            Total: 0,
                            Supplier: {
                                Id: -1,
                                Name: "Choose supplier"
                            },
                            IssueOrders: [
                            ]
                        }
                        swal({
                            title: 'Order placed',
                            text: "View this order?",
                            type: 'success',
                            showCancelButton: true,
                            confirmButtonColor: '#3085d5',
                            cancelButtonColor: '#2c3136',
                            cancelButtonText: 'Stay on this page',
                            confirmButtonText: 'Yes'
                        }).then(function () {
                            $sessionStorage.put('orderId', response.data.Id)
                            window.location = "#!/orderIssue";
                        })
                    })

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
                $ctrl.updateQuotes();
            }


        });