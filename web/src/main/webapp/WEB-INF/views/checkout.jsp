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
    <title>Square Eyes Comic Emporium - Personal Detail Elicitation</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <form role="form" action="" method="post">
        <div class="row setup-content" id="recipient-details">
            <div class="col-md-12">
                <h3 class="page-header">Personal Details</h3>
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
            </div>
        </div>
        <div class="row setup-content" id="shipping-details">
            <div class="col-md-12">
                <h3 class="page-header">Delivery Details</h3>
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

                <div class="payment-opt dropdown pull-right"><h4 class="btn-header pull-left">Delivery Option - </h4>
                    <a class="pull-right btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">Continue to Payment <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/payment-details?deliveryOpt=Collect">Collection - R0.00</a></li>
                        <li><a href="/payment-details?deliveryOpt=Express">Express Delivery - R50.00</a></li>
                        <li><a href="/payment-details?deliveryOpt=Business">Business Express - R100.00</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </form>
    <hr>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
