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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium</title>
</head>

<body>
<jsp:include page="navbar.jsp"/>

<div class="container full">
    <div class="row">
        <div class="col-md-12">
            <div class="row carousel-holder">
                <div class="col-md-12">
                    <div id="home-carousel" class="carousel slide" data-ride="carousel">
                        <ol class="carousel-indicators">
                            <li data-target="#home-carousel" data-slide-to="0" class="active"></li>
                            <li data-target="#home-carousel" data-slide-to="1"></li>
                            <li data-target="#home-carousel" data-slide-to="2"></li>
                        </ol>
                        <div class="carousel-inner">
                            <div class="item active">
                                <a href="/catalogue?page=1&filter=Publisher Marvel">
                                    <img class="slide-image" src="assets/images/marvel-logo.jpg" alt="Marvel Logo">
                                </a>
                            </div>
                            <div class="item">
                                <a href="/catalogue?page=1&filter=Publisher DC">
                                    <img class="slide-image" src="assets/images/dc-logo-v2.jpg" alt="DC Logo">
                                </a>
                            </div>
                            <div class="item">
                                <a href="/catalogue?page=1&filter=Publisher Darkhorse">
                                    <img class="slide-image" src="assets/images/dark-horse-logo.jpg" alt="Darkhorse Logo">
                                </a>
                            </div>
                        </div>
                        <a class="left carousel-control" href="#home-carousel" data-slide="prev">
                            <span class="glyphicon glyphicon-chevron-left"></span>
                        </a>
                        <a class="right carousel-control" href="#home-carousel" data-slide="next">
                            <span class="glyphicon glyphicon-chevron-right"></span>
                        </a>
                    </div>
                </div>
            </div>

            <hr>
            <a class="pull-right btn btn-default" href="/catalogue?page=1&filter=All">View More</a>
            <%--<button class="pull-right btn btn-default" type="button">View More</button>--%>
            <h1>Featured Comics</h1>
            <hr>
            <div id="featured" class="row">
                <c:forEach items="${featuredStock}" var="fStock">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="/issue?id=${fStock.getIssuesByIssueId().getID()}&condition=${fStock.getCondition()}">
                                <img class="comic-thumb" src="${fStock.getIssuesByIssueId().getImageUrl()}" alt="${fStock.getIssuesByIssueId().getTitle()}">
                            </a>
                            <div class="caption">
                                <h4>
                                    <a href="/issue?id=${fStock.getIssuesByIssueId().getID()}&condition=${fStock.getCondition()}">
                                    ${fStock.getIssuesByIssueId().getTitle()}
                                    </a>
                                </h4>
                                <h5 class="series-no">Series #${fStock.getIssuesByIssueId().getSeriesNumber()} (${fStock.getCondition()})</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>R ${fStock.getPrice()}</small></h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">XX reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <hr>
            <button class="pull-right btn btn-default" type="button">View More</button>
            <h1>Specials</h1>
            <hr>
            <div id="specials" class="row">
                <c:forEach items="${specialStock}" var="sStock">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="/issue?id=${sStock.getIssuesByIssueId().getID()}&condition=${sStock.getCondition()}">
                                <img class="comic-thumb" src="${sStock.getIssuesByIssueId().getImageUrl()}" alt="${sStock.getIssuesByIssueId().getTitle()}">
                            </a>
                            <div class="caption">
                                <h4><a href="/issue?id=${sStock.getIssuesByIssueId().getID()}&condition=${sStock.getCondition()}">${sStock.getIssuesByIssueId().getTitle()}</a></h4>
                                <h5 class="series-no">Series #${sStock.getIssuesByIssueId().getSeriesNumber()} (${sStock.getCondition()})</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>R ${sStock.getPrice()}</small></h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">XX reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <hr>
            <button class="pull-right btn btn-default" type="button">View More</button>
            <h1>Top Sellers</h1>
            <hr>
            <div id="top-sellers" class="row">
                <c:forEach items="${topStock}" var="tStock">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="/issue?id=${tStock.getIssuesByIssueId().getID()}&condition=${tStock.getCondition()}">
                                <img class="comic-thumb" src="${tStock.getIssuesByIssueId().getImageUrl()}" alt="${tStock.getIssuesByIssueId().getTitle()}">
                            </a>
                            <div class="caption">
                                <h4><a href="/issue?id=${tStock.getIssuesByIssueId().getID()}&condition=${tStock.getCondition()}">${tStock.getIssuesByIssueId().getTitle()}</a></h4>
                                <h5 class="series-no">Series #${tStock.getIssuesByIssueId().getSeriesNumber()} (${tStock.getCondition()})</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>R ${tStock.getPrice()}</small></h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">XX reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

            <hr>
            <button class="pull-right btn btn-default" type="button">View More</button>
            <h1>New Stock</h1>
            <hr>
            <div id="new-stock" class="row">
                <c:forEach items="${newStock}" var="nStock">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="/issue?id=${nStock.getIssuesByIssueId().getID()}&condition=${nStock.getCondition()}">
                                <img class="comic-thumb" src="${nStock.getIssuesByIssueId().getImageUrl()}" alt="${nStock.getIssuesByIssueId().getTitle()}">
                            </a>
                            <div class="caption">
                                <h4><a href="/issue?id=${nStock.getIssuesByIssueId().getID()}&condition=${nStock.getCondition()}">${nStock.getIssuesByIssueId().getTitle()}</a></h4>
                                <h5 class="series-no">Series #${nStock.getIssuesByIssueId().getSeriesNumber()} (${nStock.getCondition()})</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>R ${nStock.getPrice()}</small></h4>
                            </div>
                            <div class="ratings">
                                <p class="pull-right">XX reviews</p>
                                <p>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                    <span class="glyphicon glyphicon-star-empty"></span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
            <hr>
        </div>
    </div>
    <form:form action="/logout" method="POST">
        <input type="submit" value="Log out" />
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form:form>
    <hr>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
