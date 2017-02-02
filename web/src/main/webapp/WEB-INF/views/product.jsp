<%--
  Created by IntelliJ IDEA.
  User: kevin.gouws
  Date: 2017/02/01
  Time: 9:37 PM
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
    <link type="text/css" rel="stylesheet" href="assets/css/main.css" />
    <link type="text/css" rel="stylesheet" href="assets/css/product.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Square Eyes Comic Emporium - ${comicStock.getIssuesByIssueId().getTitle()}</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>

<div class="container full">
    <div class="row">
        <div class="col-sm-3 col-lg-3 col-md-3">
            <img src="${comicStock.getIssuesByIssueId().getImageUrl()}" alt="${comicStock.getIssuesByIssueId().getTitle()}" />
        </div>
        <div class="card col-sm-9 col-lg-9 col-md-9">
            <h2 >${comicStock.getIssuesByIssueId().getTitle()}</h2>
            <h1>[TO BE COMPLETED]</h1>
        </div>
    </div>
    <hr>
</div>

<div class="container">
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-sm-4 col-md-4 col-lg-4">
                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"></div>
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
                <div class="details col-sm-8 col-md-8 col-lg-8">
                    <h2 class="page-header pull-left product-title">${comicStock.getIssuesByIssueId().getTitle()}</h2>
                    <hr>
                    <dl class="row">
                        <dt class="col-sm-3">Series</dt>
                        <dd class="col-sm-9"># ${comicStock.getIssuesByIssueId().getSeriesNumber()}</dd>

                        <dt class="col-sm-3">Price</dt>
                        <dd class="col-sm-9">R ${comicStock.getPrice()}</dd>

                        <dt class="col-sm-3">Publisher</dt>
                        <dd class="col-sm-9">${comicStock.getIssuesByIssueId().getPublisher()}</dd>

                        <dt class="col-sm-3">Publication Date</dt>
                        <dd class="col-sm-9">${comicStock.getIssuesByIssueId().getPublicationDate()}</dd>

                        <dt class="col-sm-3">Description</dt>
                        <dd class="col-sm-9">${comicStock.getIssuesByIssueId().getDescription()}</dd>
                    </dl>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 col-md-4 col-lg-4"></div>
                <div class="col-sm-8 col-md-8 col-lg-8">
                    <div class="dropdown">
                        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Condition
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a id="conditionPoor" href="#">Poor</a></li>
                            <li><a id="conditionAvg" href="#">Average</a></li>
                            <li><a id="conditionFine" href="#">Fine</a></li>
                            <li><a id="conditionVeryFine" href="#">Very Fine</a></li>
                        </ul>
                        <button class="add-to-cart btn btn-default" type="button">Add to Cart</button>
                        <button class="back btn btn-default" type="button">Back</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <hr>
</div>
<div id="snackbar">Item Added to Cart!</div>

<jsp:include page="footer.jsp"/>
</body>
</html>
