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
                <div class="table-responsive">
                    <table class="table">
                        <thead>
                        <tr>
                            <th colspan="2">Comic</th>
                            <th>Quantity</th>
                            <th>Price</th>
                            <th>Discount</th>
                            <th colspan="2">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                        <tr>
                            <td>
                                <a href="#">
                                    <img class="comic-thumb thumbnail" src="assets/images/comic1.jpg" alt="Comic Name">
                                </a>
                            </td>
                            <td class="comic-title"><a href="#">TITLE</a>
                            </td>
                            <td>
                                <input type="number" value="1" class="form-control" style="max-width: 100px;">
                            </td>
                            <td>R XXX.XX</td>
                            <td>R 0.00</td>
                            <td>R XXX.XX</td>
                            <td><a href="#"><i class="glyphicon glyphicon-trash"></i></a>
                            </td>
                        </tr>
                        </tbody>
                        <tfoot>
                        <tr>
                            <th colspan="5">Total</th>
                            <th colspan="2">R XXX.XX</th>
                        </tr>
                        </tfoot>
                    </table>

                </div>

                <div class="box-footer">
                    <div class="pull-left">
                        <button class="btn btn-default"><span class="glyphicon glyphicon-chevron-left"></span> Continue Shopping</button>
                    </div>
                    <div class="pull-right">
                        <button type="submit" class="btn btn-primary">Proceed to checkout <span class="glyphicon glyphicon-chevron-right"></span></button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <!-- /.col-md-9 -->
</div>

<%--<div class="container">--%>
    <%--<div class="row">--%>
        <%--<div class="card col-xs-12 col-sm-12 col-lg-12 col-md-12">--%>
            <%--<div class="row">--%>
                <%--<div class="col-xs-12 col-sm-12 col-lg-12 col-md-12">--%>
                    <%--<h1 class="page-header"><span class="glyphicon glyphicon-shopping-cart"></span> Your Shopping Cart</h1>--%>
                <%--</div>--%>
            <%--</div>--%>
            <%--<div class="row">--%>
                <%--<div class="col-sm-2 col-lg-2 col-md-2">--%>
                    <%--&lt;%&ndash;Thumbnail&ndash;%&gt;--%>
                    <%--<a class="thumbnail pull-left" href="#"> <img class="media-object" src="assets/images/comic1.jpg" style="width: 85px; height: 120px;"> </a>--%>
                <%--</div>--%>
                <%--<div class="col-xs-2 col-sm-9 col-lg-9 col-md-9">--%>
                    <%--<h4>Product Title <small>#1337</small></h4>--%>
                    <%--<h5><small>Condition: Fine</small></h5>--%>
                    <%--<h5>Price</h5>--%>
                    <%--<input type="text" class="form-control input-sm" value="1">--%>
                <%--</div>--%>
                <%--<div class="col-xs-1 col-sm-1 col-lg-1 col-md-1">--%>
                    <%--&lt;%&ndash;Remove&ndash;%&gt;--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>

<jsp:include page="footer.jsp"/>
</body>
</html>
