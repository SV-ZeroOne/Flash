/**
 * Created by kevin.gouws on 2017/01/23.
 */
$(function(){
    $("#nav-content").load("navbar.html");
    $("#footer-content").load("footer.html");
});

function viewMoreComics() {
    window.location.href = "catalogue.html";
}