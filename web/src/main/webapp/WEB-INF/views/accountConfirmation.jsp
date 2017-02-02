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
<div class="container">

<h1>Thank you for creating an account with Square Eyes</h1>
<table>
    <tr>
        <td>Name:</td>
        <td>${firstName}</td>
    </tr>
    <tr>
        <td>Surname:</td>
        <td>${surname}</td>
    </tr>
    <tr>
        <td>Password:</td>
        <td>${password}</td>
    </tr>
    <tr>
        <td>Email:</td>
        <td>${email}</td>
    </tr>
</table>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
