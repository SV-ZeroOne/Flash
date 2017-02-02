<%--
  Created by IntelliJ IDEA.
  User: byron.dinkelmann
  Date: 2017/01/31
  Time: 3:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div id="nav-content">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="pull-left" href="index-old.html"><img src="../../assets/images/squareeyes-logo.jpg"></a>
            <a class="navbar-brand" href="index-old.html">Square Eyes</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="index-old.html">Home</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Comics <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#specials">Specials</a></li>
                        <li><a href="#top-sellers">Top Sellers</a></li>
                        <li><a href="#new-stock">New Stock</a></li>
                        <li><a href="catalogue.html">Catalogue</a></li>
                        <li role="separator" class="divider"></li>
                        <li class="dropdown-header">Publishers</li>
                        <li><a href="#">Marvel</a></li>
                        <li><a href="#">DC Comics</a></li>
                    </ul>
                </li>
                <li><a href="#about">About</a></li>
                <li><a href="#contact">Contact</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><span class="glyphicon glyphicon-shopping-cart"></span> <span class="shoppingCartAmount"> Shopping Cart </span><span class="caret"></span></a>
                    <ul class="dropdown-menu dropdown-cart" role="menu">
                        <div class="shoppingCartDropDown"></div>
                        <li class="divider"></li>
                        <li><a class="text-center" href="checkout.html">Checkout</a></li>
                    </ul>
                </li>
            </ul>
            <form class="navbar-form navbar-right" action="catalogue">
                <input type="text" class="form-control" name="search" placeholder="Search...">
                <input type="submit" value="Search">
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#login">Login</a></li>
            </ul>
        </div>
    </div>
</nav>
</div>
