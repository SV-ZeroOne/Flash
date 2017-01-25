/**
 * Created by kevin.gouws on 2017/01/23.
 */
var jsonArray = [];
var featuredElement = "";
var specialsElement = "";
var newComicsElement = "";
var topSellerElement = "";

$(document).ready(function () {
    $.getJSON('Issues.json', function (json) {
        jsonArray = json;
        prepareHomePageFeatures();
    });
});

function prepareHomePageFeatures() {
    featuredElement = document.getElementById("featured-content");
    specialsElement = document.getElementById("specials-content");
    newComicsElement = document.getElementById("new-content");
    topSellerElement = document.getElementById("top-sellers-content");
    loadInComics(featuredElement);
    loadInComics(specialsElement);
    loadInComics(newComicsElement);
    loadInComics(topSellerElement);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function loadInComics(element) {
    var randomComicSelection = [];
    for (var x = 0; x < 4; x++) {
        var randomNumber = getRandomInt(0, 633);
        randomComicSelection[x] = jsonArray[randomNumber];
    }

    for (var i = 0; i < 4; i++) {
        var randomImg = getRandomInt(1,12);
        var innerHTML = "";
        innerHTML += "<div class='col-sm-3'>";
        innerHTML += "<article class='col-item'>";
        innerHTML += "<div class='photo'>";
        innerHTML += "<a href=" + "product.html?id=" + randomComicSelection[i].Id + "> <img src='resources/Comic" + randomImg + ".jpg' class='img-thumbnail' alt='Product Image'/></a>";
        innerHTML += "</div>";
        innerHTML += "<div class='info'>";
        innerHTML += "<div class='row'>";
        innerHTML += "<div class='product-title-display col-md-12'>";
        innerHTML += "<h4 class='product-title'>" + randomComicSelection[i].Title + "</h4>";
        innerHTML += "</div>";
        innerHTML += "</div>";
        innerHTML += "<div class='separator clear-left'>";
        innerHTML += "<p class='btn-add'>";
        innerHTML += "<i class='glyphicon glyphicon-eye-open'></i><a  href=" + "product.html?id=" + randomComicSelection[i].Id  + "> View Comic</a>";
        innerHTML += "</p>";
        innerHTML += "<p class='btn-details'>";
        innerHTML += "<a href='#' class='hidden-sm' data-toggle='tooltip' data-placement='top' title='Add to wish list'><i class='glyphicon glyphicon-heart'></i></a>";
        innerHTML += "<a href='#' class='hidden-sm' data-toggle='tooltip' data-placement='top' title='Compare'><i class='glyphicon glyphicon-retweet'></i></a>";
        innerHTML += "</p>";
        innerHTML += "</div>";
        innerHTML += "<div class='clearfix'></div>";
        innerHTML += "</div>";
        innerHTML += "</article>";
        innerHTML += "</div>";
        $(element).append(innerHTML);
    }
}