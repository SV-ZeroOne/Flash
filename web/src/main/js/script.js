/**
 * Created by kevin.gouws on 2017/01/23.
 */
var jsonArray = [];
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
var comics = [];
function createComics(arg){
    comics = arg;
    console.log(comics[1].Title);
    $(".product-title").text(comics[1].Title);
    $(".product-title2").text(comics[20].Title);
    $(".product-title3").text(comics[40].Title);
    $(".product-title4").text(comics[60].Title);
    $(".product-title5").text(comics[80].Title);
    $(".product-title6").text(comics[100].Title);
    $(".product-title7").text(comics[120].Title);
    $(".product-title8").text(comics[140].Title);
    $(".product-title9").text(comics[160].Title);
    $(".product-title10").text(comics[180].Title);
    $(".product-title11").text(comics[200].Title);
    $(".product-title12").text(comics[220].Title);
    $(".product-title13").text(comics[240].Title);
    $(".product-title14").text(comics[260].Title);
    $(".product-title15").text(comics[280].Title);
    $(".product-title16").text(comics[300].Title);
}