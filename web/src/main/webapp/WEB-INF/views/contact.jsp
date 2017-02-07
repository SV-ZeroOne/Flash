<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <script>
        function myFunction() {
            // Get the snackbar DIV
            var x = document.getElementById("snackbar")

            // Add the "show" class to DIV
            x.className = "show";

            // After 3 seconds, remove the show class from DIV
            setTimeout(function(){ x.className = x.className.replace("show", ""); }, 3000);
        }
    </script>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Contact</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<div id="aboutContent">
    <h1>Contact Us</h1>
    <form:form id="contact_form" action="/about" method="POST" enctype="multipart/form-data">
        <div class="row">
            <label for="name">Your name:</label><br />
            <input id="name" class="input" name="name" type="text" value="" size="30" /><br />
        </div>
        <div class="row">
            <label for="email">Your email:</label><br />
            <input id="email" class="input" name="email" type="text" value="" size="30" /><br />
        </div>
        <div class="row">
            <label for="message">Your message:</label><br />
            <textarea id="message" class="input" name="message" rows="7" cols="30"></textarea><br />
        </div>
        <input type="hidden"  name="${_csrf.parameterName}"   value="${_csrf.token}"/>
        <input onclick="myFunction()" id="submit_button" type="submit" value="Send email" />
        <div id="snackbar"></div>
    </form:form>
</div>
<jsp:include page="footer.jsp"/>

</body>
</html>
