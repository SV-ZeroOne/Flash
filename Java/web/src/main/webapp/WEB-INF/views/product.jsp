<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/02/01
  Time: 9:37 PM
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
    <link type="text/css" rel="stylesheet" href="assets/css/main.css">
    <link type="text/css" rel="stylesheet" href="assets/css/product.css">
    <script type="text/javascript" src="assets/javascript/product.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium - ${comicStock.getIssuesByIssueId().getTitle()}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container full">
    <div class="myrow row">
        <div class="preview col-sm-4 col-lg-4 col-md-4">
            <div class="preview-pic tab-content">
                <div class="tab-pane active" id="pic-1"><img src="${comicStock.getIssuesByIssueId().getImageUrl()}" alt="${comicStock.getIssuesByIssueId().getTitle()}" /></div>
                <div class="tab-pane" id="pic-2"><img src="assets/images/comic2.jpg" /></div>
                <div class="tab-pane" id="pic-3"><img src="assets/images/comic3.jpg" /></div>
                <div class="tab-pane" id="pic-4"><img src="assets/images/comic4.jpg" /></div>
            </div>
            <ul class="preview-thumbnail nav nav-tabs">
                <li class="active"><a data-target="#pic-1" data-toggle="tab"><img src="${comicStock.getIssuesByIssueId().getImageUrl()}" /></a></li>
                <li><a data-target="#pic-2" data-toggle="tab"><img src="assets/images/comic2.jpg" /></a></li>
                <li><a data-target="#pic-3" data-toggle="tab"><img src="assets/images/comic3.jpg" /></a></li>
                <li><a data-target="#pic-4" data-toggle="tab"><img src="assets/images/comic4.jpg" /></a></li>
            </ul>
        </div>
        <div class="card col-sm-8 col-lg-8 col-md-8">
            <div class="row">
                <div class="col-sm-12 col-lg-12 col-md-12">
                    <div class="row">
                        <div class="col-sm-10 col-lg-10 col-md-10">
                            <h2>${comicStock.getIssuesByIssueId().getTitle()}</h2>
                        </div>
                        <div class="dropdown buttons col-sm-2 col-lg-2 col-md-2">
                            <a class="pull-right btn btn-default dropdown-toggle" data-toggle="dropdown" href="#">Condition <span class="caret"></span></a>
                            <ul class="dropdown-menu">
                                <li><a href="/issue?id=${comicStock.getIssuesByIssueId().getID()}&condition=Very Fine">Very Fine</a></li>
                                <li><a href="/issue?id=${comicStock.getIssuesByIssueId().getID()}&condition=Fine">Fine</a></li>
                                <li><a href="/issue?id=${comicStock.getIssuesByIssueId().getID()}&condition=Average">Average</a></li>
                                <li><a href="/issue?id=${comicStock.getIssuesByIssueId().getID()}&condition=Poor">Poor</a></li>
                            </ul>
                        </div>
                    </div>
                    <hr class="header-rule">
                </div>
            </div>
            <div class="row">
                <div class="col-sm-12 col-lg-12 col-md-12">
                    <ul class="nav nav-tabs">
                        <li class="active"><a data-toggle="tab" href="#details">Details</a></li>
                        <li><a data-toggle="tab" href="#desc">Description</a></li>
                        <li><a data-toggle="tab" href="#reviews">Reviews</a></li>
                    </ul>

                    <div class="tab-content">
                        <div id="details" class="tab-pane fade in active">
                            <dl>
                                <dt class="col-sm-3">Series</dt>
                                <dd class="col-sm-9"># ${comicStock.getIssuesByIssueId().getSeriesNumber()}</dd>

                                <dt class="col-sm-3">Condition</dt>
                                <dd class="col-sm-9">${comicStock.getCondition()}</dd>

                                <dt class="col-sm-3">Price</dt>
                                <dd class="col-sm-9">R ${comicStock.getPrice()}</dd>

                                <dt class="col-sm-3">Publisher</dt>
                                <dd class="col-sm-9">${comicStock.getIssuesByIssueId().getPublisher()}</dd>

                                <dt class="col-sm-3">Publication Date</dt>
                                <dd class="col-sm-9">${comicStock.getIssuesByIssueId().getPublicationDate()}</dd>
                            </dl>
                        </div>
                        <div id="desc" class="tab-pane fade">
                            ${comicStock.getIssuesByIssueId().getDescription()}
                        </div>
                        <div id="reviews" class="tab-pane fade">
                            Some reviews go here
                        </div>
                    </div>
                </div>
            </div>
            <hr class="header-rule">
            <div class="row buttons">
                <button id="backBtn" class="btn btn-default">Back</button>
                <form:form method="POST" action="/add-to-cart" cssClass="pull-right">
                    <input id="addBtn" type="submit" value="Add to Cart" class="pull-right btn btn-default">
                </form:form>
            </div>
        </div>
        <div id="snackbar">${comicStock.getIssuesByIssueId().getTitle()} Added to Cart!</div>
    </div>
</div>


<jsp:include page="footer.jsp"/>
</body>
</html>
