<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/02/02
  Time: 7:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/main.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium - Order Payment</title>
</head>
<body>

<jsp:include page="navbar.jsp"/>

<div class="container">
    <div class="row setup-content" id="recipient-details">
        <h3 class="page-header">Order Summary</h3>
        <div class="col-md-6">
            <h4>Recipient</h4>
            <dl>
                <dt class="col-sm-3">Full Name</dt>
                <dd class="col-sm-9">${customerAccount.getFirstName()} ${customerAccount.getSurname()}</dd>

                <dt class="col-sm-3">Phone Number</dt>
                <dd class="col-sm-9">${phoneNumber.getPhoneNumber()}</dd>

                <dt class="col-sm-3">Email</dt>
                <dd class="col-sm-9">${emailAddress.getEmail()}</dd>
            </dl>
        </div>
        <div class="col-md-6">
            <h4>Shipping Address</h4>
            <dl>
                <dt class="col-sm-3">Street Address</dt>
                <dd class="col-sm-9">${customerAddress.getAddress1()}</dd>

                <dt class="col-sm-3">Suburb</dt>
                <dd class="col-sm-9">${customerAddress.getSuburb()}</dd>

                <dt class="col-sm-3">City</dt>
                <dd class="col-sm-9">${customerAddress.getCity()}</dd>

                <dt class="col-sm-3">Postal Code</dt>
                <dd class="col-sm-9">${customerAddress.getPostalCode()}</dd>
            </dl>
        </div>
    </div>

    <div class="row setup-content" id="order-details">
        <h3 class="page-header">Cart Items</h3>
        <div class="col-md-12">
            <div class="table-responsive">
                <table class="table">
                    <thead>
                    <tr>
                        <th colspan="2">Comic</th>
                        <th>Quantity</th>
                        <th>Price</th>
                        <th colspan="3">Comic Total</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${cartItemsStock}" var="cStock" varStatus="status">
                        <tr>
                            <td  class="comic-title">${cStock.getIssuesByIssueId().getTitle()}
                            </td>
                            <td>
                            </td>
                            <td>
                                    ${shoppingCartItems[status.index].getQuantity()}
                            </td>
                            <td>R ${cStock.getPrice()}</td>
                            <td>R ${shoppingCartItems[status.index].getQuantity()*cStock.getPrice()}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                    <tfoot>
                    <tr>
                        <th colspan="4">Sub Total</th>
                        <th colspan="2">R ${subTotal}</th>
                    </tr>
                    <tr>
                        <th colspan="4">Delivery Total (option)</th>
                        <th colspan="2">R ${deliveryTotal}</th>
                    </tr>
                    <tr>
                        <th colspan="4">Order Total</th>
                        <th colspan="2">R ${orderTotal}</th>
                    </tr>
                    </tfoot>
                </table>

            </div>
        </div>
    </div>

    <form role="form" action="/place-order" method="post" class="payment-input">
        <div class="row setup-content" id="payment-details">
            <h3 class="page-header">Payment Details</h3>
            <div class="col-md-12">
                <label class="radio-inline"><input type="radio" name="optradio" checked="checked">Visa</label>
                <label class="radio-inline"><input type="radio" name="optradio">Mastercard</label>
                <label class="radio-inline"><input type="radio" name="optradio">Paypall</label>
                <br>
                <br>
                <div class="form-group">
                    <label class="control-label">Card Number</label>
                    <input maxlength="20" type="text" required="required" class="form-control"
                           placeholder="Enter Card Number"/>
                </div>

                <div class="form-group">
                    <label class="control-label">Card Holder Name</label>
                    <input maxlength="100" type="text" required="required" class="form-control"
                           placeholder="Enter Card Holder Name"/>
                </div>

                <div class="form-group">
                    <label for="month">Expiry Date</label>
                    <select required="required" class="form-control" id="month">
                        <option>MM</option>
                        <option>01</option>
                        <option>02</option>
                        <option>03</option>
                        <option>04</option>
                        <option>05</option>
                        <option>06</option>
                        <option>07</option>
                        <option>08</option>
                        <option>09</option>
                        <option>10</option>
                        <option>11</option>
                        <option>12</option>
                    </select>
                    <br>
                    <select required="required" class="form-control" id="year">
                        <option>YY</option>
                        <option>17</option>
                        <option>18</option>
                        <option>19</option>
                        <option>20</option>
                        <option>21</option>
                    </select>
                </div>

                <div class="form-group">
                    <label class="control-label">Voucher Code</label>
                    <input maxlength="20" type="text" class="form-control" placeholder="Enter Voucher Codes"/>
                </div>
            </div>
        </div>
        <input class="btn btn-success btn-lg pull-right" type="submit" value="Pay & Place Order" />
    </form>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
