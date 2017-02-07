<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <li><a href="/shopping-cart"><span class="glyphicon glyphicon-shopping-cart"></span> Shopping Cart</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="catalogue">
                <input type="text" name="filter" class="form-control" placeholder="Search...">
            </form>
            <ul class="nav navbar-nav navbar-right">
                <li><sec:authorize var="loggedIn" access="isAuthenticated()" />
                <c:choose>
                    <c:when test="${loggedIn}">
                        <form action="/logout" method="POST">
                            <button type="submit" value="j_spring_security_logout" class="navBtn btn btn-default" data-toggle="collapse" data-target="#user">
                                <span class="sr-only">Toggle user</span>
                                <i class="fa fa-user"></i>Logout
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </button>
                        </form>
                    </c:when>
                    <c:otherwise>
                        <form action="login">
                            <button type="submit" class="navBtn btn btn-default" data-toggle="collapse" data-target="#user">
                                <span class="sr-only">Toggle user</span>
                                <i class="fa fa-user"></i>Login/Register
                            </button>
                        </form>
                    </c:otherwise>
                </c:choose>
                </li>
            </ul>
        </div>
    </div>
</nav>