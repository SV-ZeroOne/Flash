<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
  Created by IntelliJ IDEA.
  User: byron.dinkelmann
  Date: 2017/01/31
  Time: 3:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="assets/css/main.css">
<link type="text/css" rel="stylesheet" href="assets/css/catalogue.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<title>Square Eyes Comic Emporium</title>

</head>
<body>
<%@ include file="navbar.jsp" %>
<div class="container">

    <div class="dropdown pull-right">
        <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Product Filter
            <span class="caret"></span></button>
        <ul class="dropdown-menu">
            <li><a href="?page=1&filter=All">All</a></li>
            <li><a href="?page=1&filter=Title AZ">Title AZ</a></li>
            <li><a href="?page=1&filter=Title ZA">Title ZA</a></li>
            <li><a href="?page=1&filter=Publisher DC">Publisher DC</a></li>
            <li><a href="?page=1&filter=Publisher Darkhorse">Publisher DarkHorse</a></li>
            <li><a href="?page=1&filter=Price High">Price High</a></li>
            <li><a href="?page=1&filter=Price Low">Price Low</a></li>
            <li><a href="?page=1&filter=Condition Very Fine">Condition Very Fine</a></li>
            <li><a href="?page=1&filter=Condition Fine">Condition Fine</a></li>
            <li><a href="?page=1&filter=Condition Average">Condition Average</a></li>
            <li><a href="?page=1&filter=Condition Poor">Condition Poor</a></li>
        </ul>
        <p>Filtered By ${filter}</p>
    </div>


    <div class="row">

        <h1>Products Catalogue</h1>


        <div id="products" class="container">

            <c:forEach items="${stockList}" var="item">
                <div class="col-sm-3 col-lg-3 col-md-3">
                    <div class="thumbnail">
                        <a href="/issue?id=${item.getIssuesByIssueId().getID()}&condition=${item.getCondition()}">
                            <img class="comic-thumb" src="${item.issuesByIssueId.imageUrl}" alt="${item.issuesByIssueId.title}">
                        </a>
                        <div class="caption">
                            <h4><a href="/issue?id=${item.getIssuesByIssueId().getID()}&condition=${item.getCondition()}">${item.issuesByIssueId.title}</a></h4>
                            <h5 class="series-no">Series : ${item.issuesByIssueId.seriesNumber}</h5>
                            <h5 class="series-no">Condition : ${item.condition}</h5>

                        </div>
                        <div class="price">
                            <h4 class="pull-right"><small>Price : R${item.price}</small></h4>
                        </div>
                        <div class="ratings">
                            <p class="pull-right">20 reviews</p>
                            <p>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star"></span>
                                <span class="glyphicon glyphicon-star-empty"></span>
                            </p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
        <ul class="pagination">
            <li class="previous"><a href="?page=${page-1}&filter=${filter}">Previous</a></li>
            <c:if test="${(page-3) > 0}">
            <li class="page-item"><a class="?page=${page-3}&filter=${filter}"><c:out value="${page-3}"/></c:if></a></li>
            <c:if test="${(page-2) > 0}">
            <li class="page-item"><a class="?page=${page-2}&filter=${filter}"><c:out value="${page-2}"/></c:if></a></li>
            <c:if test="${(page-1) > 0}">
            <li class="page-item"><a class="?page=${page-1}&filter=${filter}"><c:out value="${page-1}"/></c:if></a></li>
            <li class="page-item active">
                <a class="page-link" href="#">${page}<span class="sr-only">${page}</span></a>
            </li>
            <c:if test="${(page+1) < displaySize}">
            <li class="page-item"><a class="?page=${page+1}&filter=${filter}"><c:out value="${page+1}"/></c:if></a></li>
            <c:if test="${(page+2) < displaySize}">
            <li class="page-item"><a class="?page=${page+2}&filter=${filter}"><c:out value="${page+2}"/></c:if></a></li>
            <c:if test="${(page+3) < displaySize}">
            <li class="page-item"><a class="?page=${page+3}&filter=${filter}"><c:out value="${page+3}"/></c:if></a></li>
            <li class="page-item">
            <li class="next"><a href="?page=${page+1}&filter=${filter}">Next</a></li>
        </ul>
</div>
</body>
<%@ include file="footer.jsp" %>
</html>
