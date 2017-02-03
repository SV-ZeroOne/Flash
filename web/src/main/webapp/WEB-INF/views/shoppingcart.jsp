<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/02/02
  Time: 1:09 PM
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
    <title>Square Eyes Comic Emporium - Your Shopping Cart</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container">
    <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12" id="basket">
        <div class="box">
            <form class="cart-form" method="" action="">
                <h1 class="page-header"><span class="glyphicon glyphicon-shopping-cart"></span> Your Shopping Cart</h1>
                <c:choose>
                    <c:when test="${cartItemsStock.size()==0}">
                        <div class="row">
                            <div class="cart-notif col-md-12">
                                <h3>Your cart is empty :(</h3>
                                <p class="cart-msg">Start your shopping experience by
                                    <a class="cart-link" href="/home">browsing our homepage</a> or
                                    <a class="cart-link" href="/catalogue?page=1&filter=All">viewing our comic catalogue</a>
                                </p>
                            </div>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="table-responsive">
                            <table class="table">
                                <thead>
                                <tr>
                                    <th colspan="2">Comic</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th colspan="2">Total</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${cartItemsStock}" var="cStock" varStatus="status">
                                    <tr>
                                        <td>
                                            <a href="#">
                                                <img class="comic-thumb thumbnail" src="${cStock.getIssuesByIssueId().getImageUrl()}" alt="${cStock.getIssuesByIssueId().getTitle()}">
                                            </a>
                                        </td>
                                        <td class="comic-title"><a href="#">${cStock.getIssuesByIssueId().getTitle()}</a>
                                        </td>
                                        <td>
                                            ${shoppingCartItems[status.index].getQuantity()}
                                        </td>
                                        <td>R ${cStock.getPrice()}</td>
                                        <td>R ${shoppingCartItems[status.index].getQuantity()*cStock.getPrice()}</td>
                                        <td><a href="#"><i class="glyphicon glyphicon-trash"></i></a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                                <tfoot>
                                <tr>
                                    <th colspan="4">Sub Total</th>
                                    <th colspan="2">R ${subTotal}</th>
                                </tr>
                                </tfoot>
                            </table>

                        </div>

                        <div class="box-footer">
                            <div class="pull-left">
                                <a class="btn btn-default" href="/catalogue?page=1&filter=All"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</a>
                            </div>
                            <div class="pull-right">
                                <a type="submit" class="btn btn-success" href="/checkout">Proceed to checkout <span class="glyphicon glyphicon-chevron-right"></span></a>
                            </div>
                        </div>
                    </c:otherwise>
                </c:choose>
            </form>
        </div>
    </div>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
