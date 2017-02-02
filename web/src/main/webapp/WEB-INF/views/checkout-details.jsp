<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/02/02
  Time: 7:24 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/main.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium - Enter Your Details</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <form role="form" action="" method="post">
        <div class="row setup-content" id="step-1">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 1: Personal Details</h3>
                    <div class="form-group">
                        <label class="control-label">First Name</label>
                        <input  maxlength="100" type="text" value="${customerAccount.getFirstName()}" required="required" class="form-control" placeholder="Enter First Name"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Last Name</label>
                        <input maxlength="100" type="text" value="${customerAccount.getSurname()}" required="required" class="form-control" placeholder="Enter Last Name" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Phone Number</label>
                        <input maxlength="12" type="text" value="${phoneNumber.getPhoneNumber()}" required="required" class="form-control" placeholder="Enter Cellphone Number" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Email Address</label>
                        <input maxlength="100" type="text" value="${emailAddress.getEmail()}" required="required" class="form-control" placeholder="Enter Email Address" />
                    </div>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <div class="row setup-content" id="step-2">
            <div class="col-xs-12">
                <div class="col-md-12">
                    <h3> Step 2: Delivery Details</h3>
                    <div class="form-group">
                        <label class="control-label">Street Address</label>
                        <input maxlength="200" type="text" value="${customerAddress.getAddress1()}" required="required" class="form-control" placeholder="Enter Street Address" />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Suburb</label>
                        <input maxlength="100" type="text" value="${customerAddress.getSuburb()}" required="required" class="form-control" placeholder="Enter Suburb"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">City</label>
                        <input maxlength="100" type="text" value="${customerAddress.getCity()}" required="required" class="form-control" placeholder="Enter City"  />
                    </div>
                    <div class="form-group">
                        <label class="control-label">Postal Code</label>
                        <input maxlength="4" type="text" value="${customerAddress.getPostalCode()}" required="required" class="form-control" placeholder="Enter Postal Code"  />
                    </div>
                    <h4> Delivery Options </h4>
                    <div class="radio">
                        <label><input type="radio" name="optradioD" checked="checked">Collection - R0.00</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="optradioD">Express Delivery - R50.00</label>
                    </div>
                    <div class="radio">
                        <label><input type="radio" name="optradioD">Business Express - R100.00</label>
                    </div>
                    <button class="btn btn-primary nextBtn btn-lg pull-right" type="button" >Next</button>
                </div>
            </div>
        </div>
        <%--<div class="row setup-content" id="step-3">--%>
            <%--<div class="col-xs-12">--%>
                <%--<div class="col-md-12">--%>
                    <%--<h3> Step 3: Payment Details</h3>--%>
                    <%--<label class="radio-inline"><input type="radio" name="optradio" checked="checked">Visa</label>--%>
                    <%--<label class="radio-inline"><input type="radio" name="optradio">Mastercard</label>--%>
                    <%--<label class="radio-inline"><input type="radio" name="optradio">Paypall</label>--%>
                    <%--<br>--%>
                    <%--<br>--%>
                    <%--<div class="form-group">--%>
                        <%--<label class="control-label">Card Number</label>--%>
                        <%--<input maxlength="20" type="text" required="required" class="form-control" placeholder="Enter Card Number"  />--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label class="control-label">Card Holder Name</label>--%>
                        <%--<input maxlength="100" type="text" required="required" class="form-control" placeholder="Enter Card Holder Name"  />--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label for="month">Expiry Date</label>--%>
                        <%--<select required="required" class="form-control" id="month">--%>
                            <%--<option>MM</option>--%>
                            <%--<option>01</option>--%>
                            <%--<option>02</option>--%>
                            <%--<option>03</option>--%>
                            <%--<option>04</option>--%>
                            <%--<option>05</option>--%>
                            <%--<option>06</option>--%>
                            <%--<option>07</option>--%>
                            <%--<option>08</option>--%>
                            <%--<option>09</option>--%>
                            <%--<option>10</option>--%>
                            <%--<option>11</option>--%>
                            <%--<option>12</option>--%>
                        <%--</select>--%>
                        <%--<br>--%>
                        <%--<select required="required" class="form-control" id="year">--%>
                            <%--<option>YY</option>--%>
                            <%--<option>17</option>--%>
                            <%--<option>18</option>--%>
                            <%--<option>19</option>--%>
                            <%--<option>20</option>--%>
                            <%--<option>21</option>--%>
                        <%--</select>--%>
                    <%--</div>--%>

                    <%--<div class="form-group">--%>
                        <%--<label class="control-label">Voucher Code</label>--%>
                        <%--<input maxlength="20" type="text" class="form-control" placeholder="Enter Voucher Codes"  />--%>
                    <%--</div>--%>

                    <%--<a href="confirmation.html" class="btn btn-success btn-lg pull-right" type="submit">Submit</a>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    </form>
    <hr>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
