<%--
  Created by IntelliJ IDEA.
  User: byron.dinkelmann
  Date: 2017/02/02
  Time: 2:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/main.css">
    <link type="text/css" rel="stylesheet" href="assets/css/catalogue.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <meta charset="UTF-8">
    <title>Error 404</title>
    <%@ include file="navbar.jsp" %>

</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-4"></div>
        <div class="col-md-4">
            <h1>404 Page Not Found.</h1>
            <br/>
            <p><b>Error code:</b> 500</p>
            <p><b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}</p>
            <br/>
            <button onclick="history.back()">Back to Previous Page</button>
        </div>
        <div class="col-md-4"></div>
    </div>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>


