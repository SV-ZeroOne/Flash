<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <title>Registration</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1>Square Eyes Registration</h1>
<p>Please enter you details below.</p>
<form:form method="POST" modelAttribute="customer" action="/addCustomer">
    <table>
        <tr>
            <td><form:label path="firstName">Name</form:label></td>
            <td><form:input path="firstName" /></td>
        </tr>
        <tr>
            <td><form:label path="surname">Surname</form:label></td>
            <td><form:input path="surname" /></td>
        </tr>
        <tr>
            <td><form:label path="password">Password</form:label></td>
            <td><form:input path="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Register"/>
            </td>
        </tr>
    </table>
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>