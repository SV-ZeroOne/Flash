<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link rel="stylesheet" href="assets/css/main.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Account Confirmation</title>

</head>
<body>
<jsp:include page="navbar.jsp"/>
<div id="confirmationPage" class="container">

<h1>Thank you for creating an account with Square Eyes</h1>
    <p>Thanks you for registering with us: ${firstName} ${surname}</p>
    <p>Please enjoy our wide selection of comic books available for your purchase.</p>
    
    <img id="confirmationImage" src="assets/images/comicbooks.jpg"/>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
