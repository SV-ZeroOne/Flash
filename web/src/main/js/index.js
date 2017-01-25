/**
 * Created by kevin.gouws on 2017/01/23.
 */
var jsonArray = [];
var featuredComicsElement = "";
var specialComicsElement = "";
var newComicsElement = "";
var topSellingComicsElement = "";

$(document).ready(function () {
    $.getJSON('Issues.json', function (json) {
        jsonArray = json;
        prepareHomePageFeatures();
    });
});

function prepareHomePageFeatures() {
    featuredComicsElement = document.getElementById("featured-content");
    specialComicsElement = document.getElementById("special-content");
    newComicsElement = document.getElementById("new-stock-content");
    topSellingComicsElement = document.getElementById("top-sellers-content");
    loadInComics(featuredComicsElement);
    loadInComics(specialComicsElement);
    loadInComics(newComicsElement);
    loadInComics(topSellingComicsElement);
}

function getRandomInt(min, max) {
    return Math.floor(Math.random() * (max - min + 1)) + min;
}

Array.min = function(array){
    return Math.min.apply(Math, array);
};

function loadInComics(element) {
    var randomComicSelection = [];
    for (var x = 0; x < 4; x++) {
        var randomComicIndex = getRandomInt(0, 633);
        randomComicSelection[x] = jsonArray[randomComicIndex];
    }

    for (var i = 0; i < randomComicSelection.length; i++) {
        //purely cosmetic
        var randomImg = getRandomInt(1,12);
        var randomStarCount = getRandomInt(2, 5);
        var randomReviewCount = getRandomInt(5, 21);

        //lowest price procurement
        var comicBookSellingPrices = [];
        for (var a = 0; a < randomComicSelection[i].Stock.length; a++) {
            comicBookSellingPrices[a] = randomComicSelection[i].Stock[a].Price;
        }
        var lowestSellingPrice = Array.min(comicBookSellingPrices);


        //HTML generation
        var innerHTML = "";
        innerHTML += "<div class='col-sm-4 col-lg-4 col-md-4'>";
        innerHTML += "<div class='thumbnail'>";
        innerHTML += "<a href=" + "product.html?id=" + randomComicSelection[i].Id + "><img class='comic-thumb' src='resources/comic" + randomImg + ".jpg' alt='" + randomComicSelection[i].Title + "'></a>";
        innerHTML += "<div class='caption'>";
        innerHTML += "<h4 class='pull-right'><small>Starting at: R" + lowestSellingPrice + "</small></h4>";
        innerHTML += "<h4><a href=" + "product.html?id=" + randomComicSelection[i].Id + ">" + randomComicSelection[i].Title + "</a>";
        innerHTML += "</h4>";
        innerHTML += "<p>[" + randomComicSelection[i].Description + "] Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam consectetur purus id est euismod, sed tempus tortor vehicula.</p>";
        innerHTML += "</div>";
        innerHTML += "<div class='ratings'>";
        innerHTML += "<p class='pull-right'>" + randomReviewCount + " reviews</p>";
        innerHTML += "<p>";
        for (var y = 0; y < randomStarCount; y++) {
            innerHTML += "<span class='glyphicon glyphicon-star'></span>";
        }
        if (randomStarCount != 5) {
            for (var z = 0; z < (5-randomStarCount); z++) {
                innerHTML += "<span class='glyphicon glyphicon-star-empty'></span>";
            }
        }
        innerHTML += "</p>";
        innerHTML += "</div>";
        innerHTML += "</div>";
        innerHTML += "</div>";
        $(element).append(innerHTML);
    }
}