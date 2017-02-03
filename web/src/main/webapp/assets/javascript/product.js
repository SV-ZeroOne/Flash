/**
 * Created by steve.velcev on 2017/01/24.
 */



window.onload = function () {
    document.getElementById("backBtn").addEventListener("click", goBack, false);
    document.getElementById("addBtn").addEventListener("click", showSnackbar, false);
}

function showSnackbar() {
    var x = document.getElementById("snackbar");
    x.className = "show";
    setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
}

function goBack() {
    window.history.back();
}
