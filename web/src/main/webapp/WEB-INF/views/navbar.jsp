<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/01/31
  Time: 3:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="pull-left" href="/home"><img src="assets/images/squareeyes-logo.jpg"></a>
            <a class="navbar-brand" href="/home">Square Eyes</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="/home">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Comics <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#featured">Featured</a></li>
                        <li><a href="#specials">Specials</a></li>
                        <li><a href="#top-sellers">Top Sellers</a></li>
                        <li><a href="#new-stock">New Stock</a></li>
                        <li><a href="/catalogue?page=1&filter=All">Catalogue</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Publishers</li>
                        <li><a href="/catalogue?page=1&filter=Publisher Darkhorse">Dark Horse</a></li>
                        <li><a href="/catalogue?page=1&filter=Publisher DC">DC Comics</a></li>
                    </ul>
                </li>
                <li><a href="/about">About</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="shoppingCartAmount"> Shopping Cart </span><span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-cart" role="menu">
                        <div class="shoppingCartDropDown"></div>
                        <li class="divider"></li>
                        <li><a class="text-center" href="#">Checkout</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right">
                <input type="text" class="form-control" placeholder="Search...">
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/login">Login</a></li>
            </ul>
        </div>
    </div>
</nav>