/**
 * Created by steve.velcev on 2017/01/24.
 */

var jsonArray = [];
var comics = [];
var comicId;
var comicConditionPrice = 0;
var numberOfCartItems = 0;

function loadJson() {
    $(document).ready(function()
    {
        $.getJSON('Issues.json', function(jsonArray) {
            console.log(jsonArray);
            for(var i =0; i < jsonArray.length; i++){
                createComics(jsonArray);
            }
        });
    });

}

function createComics(arg){
    comics = arg;
    console.log(comics[comicId].Title);
    $(".product-title").text(comics[comicId].Title);
    $(".product-description").text(comics[comicId].Description);
    $(".seriesNumber").text(comics[comicId].SeriesNumber);
    var publicationDate = comics[comicId].PublicationDate;
        publicationDate = publicationDate.split("T")[0];
    $(".pubdate").text(publicationDate);
}

function changePrice(condition){
    $(".price").text("Current Price: R" + comics[comicId].Stock[condition].Price);
    comicConditionPrice = comics[comicId].Stock[condition].Price;
}

function loadId() {
    var url = document.location.href,
        params = url.split('?')[1].split('&'),
        data = {}, tmp;
    for (var i = 0, l = params.length; i < l; i++) {
        tmp = params[i].split('=');
        data[tmp[0]] = tmp[1];
    }
    comicId = data.id - 2;
}

function addToCart(){
    if(comicConditionPrice <= 0){
        window.alert("Please select a condition.");
    }else{
        numberOfCartItems = numberOfCartItems +1;
        $(".shoppingCartAmount").text(numberOfCartItems + " Items ");
        var html = "";
        html += "<li>";
        html += "<span class='item'>";
        html += "<span class='item-left'>";
        html += "<img src='http://lorempixel.com/50/50' alt='' />";
        html += "<span class='item-info'>";
        html += "<span>" + comics[comicId].Title + "</span>";
        html += "<span>R " + comicConditionPrice + "</span>";
        html += "<div class='price-details col-md-6'>";
        html += "</span>";
        html += "</span>";
        html += "<span class='item-right'>";
        html += "<button class='btn btn-xs btn-danger pull-right'>x</button>";
        html += "</span>";
        html += "</span>";
        html += "</li>";
        $(".shoppingCartDropDown").append(html);
    }
}

function goBack() {
    window.history.back();
}
