/**
 * Created by byron.dinkelmann on 2017/01/26.
 */

var jsonArray = [];
var displaySize = 16;

function GetURLParameter(sParam) {
    var sPageURL = window.location.search.substring(1);
    var sURLVariables = sPageURL.split('&');
    for (var i = 0; i < sURLVariables.length; i++) {
        var sParameterName = sURLVariables[i].split('=');
        if (sParameterName[0] == sParam) {
            return decodeURIComponent(sParameterName[1]);
        }
    }
}

var direction = GetURLParameter('direction');
var size = null;

if (direction == undefined) {
    localStorage.setItem("size", 0);
    size = 0;
}

if (direction != undefined) {
    size = parseInt(localStorage.getItem("size"));
    if (direction == "next" && performance.navigation.type != 1) {
        if (size + displaySize < parseInt(localStorage.getItem("arraySize"))) {
            size += displaySize;
        }

    }
    else if(direction == "previous" && performance.navigation.type != 1) {
        if (size != 0) {
            size -= displaySize;
        }
    }
}

localStorage.setItem("size", size);

$(function () {
    $('#searchTxt').keyup(function (event) {
        var keyCode = event.which; // check which key was pressed
        var term = $(this).val();
        $('#products').children().hide(); // hide all
        $('#products').children(':Contains("' + term + '")').show(); // toggle based on term
    });
});

$.expr[':'].Contains = function (a, i, m) {
    return jQuery(a).text().toUpperCase().indexOf(m[3].toUpperCase()) >= 0;
};


function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

function loadJson() {

    $(document).ready(function () {
        $.getJSON('Issues.json', function (json) {
            jsonArray = json;
            localStorage.setItem("arraySize", jsonArray.length);
        });
    });
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

Array.min = function (array) {
    return Math.min.apply(Math, array);
};

function loadProducts() {
    if (localStorage.getItem("size") == null) {
        size = 0;
        localStorage.setItem("size", size);
    }
    else {
        size = parseInt(localStorage.getItem("size"));
        //size = localStorage.getItem("size");
    }

    var randomImg = getRandomInt(1, 12);
    var randomStarCount = getRandomInt(2, 5);
    var randomReviewCount = getRandomInt(5, 21);

    for (var i = size; i < size + displaySize; i++) {

        var innerHTML = "";
        innerHTML += "<div class='col-sm-3 col-lg-3 col-md-3'>";
        innerHTML += "<div class='thumbnail'>";
        innerHTML += "<a href=" + "product.html?id=" + jsonArray[i].Id + "><img class='comic-thumb' src='resources/comic" +getRandomInt(1, 12) + ".jpg' alt='" + jsonArray[i].Title + "'></a>";
        innerHTML += "<div class='caption'>";
        innerHTML += "<h4><a href=" + "product.html?id=" + jsonArray[i].Id + ">" + jsonArray[i].Title + "</a>";
        innerHTML += "</h4>";
        innerHTML += "<h5 class='series-no'>Series #" + jsonArray[i].SeriesNumber + "</h5>";
        innerHTML += "</div>";
        innerHTML += "<div class='price'>";
        innerHTML += "<h4 class='pull-right'><small>Starting at: R" + 999 + "</small></h4>";
        innerHTML += "</div>";
        innerHTML += "<div class='ratings'>";
        innerHTML += "<p class='pull-right'>" + randomReviewCount + " reviews</p>";
        innerHTML += "<p>";
        for (var y = 0; y < randomStarCount; y++) {
            innerHTML += "<span class='glyphicon glyphicon-star'></span>";
        }
        if (randomStarCount != 5) {
            for (var z = 0; z < (5 - randomStarCount); z++) {
                innerHTML += "<span class='glyphicon glyphicon-star-empty'></span>";
            }
        }
        innerHTML += "</p>";
        innerHTML += "</div>";
        innerHTML += "</div>";
        innerHTML += "</div>";
        $("#products").append(innerHTML);
    }
}
