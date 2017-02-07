<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/01/31
  Time: 1:53 PM
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
    <link type="text/css" rel="stylesheet" href="assets/css/checkout.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium - Order Success!</title>
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <h1 id="orderConfirmation">Your order has been successfully completed!</h1>
    <h3 id="orderNumber">Order Reference Number: ${orderReference}</h3>
    <p id="orderDetails">
        A copy of the your order invoice along with the order number will be emailed to you shortly.
        <br>
        Thanks you for shopping with us :)
    </p>
    <div class="row">
        <div class="col-sm-12">
            <div class="text-center">
                <a id="homePageBtn" href="/home" class="btn btn-default" type="button">Home Page</a>
            </div>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
