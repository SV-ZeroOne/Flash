<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/01/31
  Time: 1:53 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/main.css" />
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
                                <a href="#">
                                    <img class="slide-image" src="assets/images/marvel-logo.jpg" alt="Marvel Logo">
                                </a>
                            </div>
                            <div class="item">
                                <a href="#">
                                    <img class="slide-image" src="assets/images/dc-logo-v2.jpg" alt="DC Logo">
                                </a>
                            </div>
                            <div class="item">
                                <a href="#">
                                    <img class="slide-image" src="assets/images/dark-horse-logo.jpg" alt="Marvel vs DC">
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
            <button class="pull-right btn btn-default" type="button">View More</button>
            <h1>Featured Comics</h1>
            <hr>
            <div id="featured" class="row">
                <c:forEach items="${featuredIssues}" var="fIssue">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="#">
                                <img class="comic-thumb" src="${fIssue.imageURL}" alt="${fIssue.title}">
                            </a>
                            <div class="caption">
                                <h4><a href="#">${fIssue.title}</a></h4>
                                <h5 class="series-no">Series #${fIssue.seriesNumber}</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>Starting at: R XX</small></h4>
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
                <c:forEach items="${specialIssues}" var="sIssue">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="#">
                                <img class="comic-thumb" src="${sIssue.imageURL}" alt="${sIssue.title}">
                            </a>
                            <div class="caption">
                                <h4><a href="#">${sIssue.title}</a></h4>
                                <h5 class="series-no">Series #${sIssue.seriesNumber}</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>Starting at: R XX</small></h4>
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
                <c:forEach items="${topSellerIssues}" var="tIssue">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="#">
                                <img class="comic-thumb" src="${tIssue.imageURL}" alt="${tIssue.title}">
                            </a>
                            <div class="caption">
                                <h4><a href="#">${tIssue.title}</a></h4>
                                <h5 class="series-no">Series #${tIssue.seriesNumber}</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>Starting at: R XX</small></h4>
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
                <c:forEach items="${newStockIssues}" var="nIssue">
                    <div class="col-sm-3 col-lg-3 col-md-3">
                        <div class="thumbnail">
                            <a href="#">
                                <img class="comic-thumb" src="${nIssue.imageURL}" alt="${nIssue.title}">
                            </a>
                            <div class="caption">
                                <h4><a href="#">${nIssue.title}</a></h4>
                                <h5 class="series-no">Series #${nIssue.seriesNumber}</h5>
                            </div>
                            <div class="price">
                                <h4 class="pull-right"><small>Starting at: R XX</small></h4>
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
    <hr>
</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
