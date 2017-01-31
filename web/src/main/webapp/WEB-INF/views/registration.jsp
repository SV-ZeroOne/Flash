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
<div class="registrationForm col-md-12 col-sm-12">
<h1>Square Eyes Registration</h1>
<p>Please enter you details below.</p>

<form:form method="POST" modelAttribute="customer" action="/addCustomer">
    <div class="form-group col-md-6 col-sm-6">
        <tr>
            <td><form:label path="account.firstName">Name</form:label></td>
            <td><form:input path="account.firstName" placeholder="Name"/></td>
        </tr>
        <tr>
            <td><form:label path="account.surname">Surname</form:label></td>
            <td><form:input path="account.surname" placeholder="Surname"/></td>
        </tr>
        <tr>
            <td><form:label path="account.password">Password</form:label></td>
            <td><form:input path="account.password" placeholder="Password"/></td>
        </tr>
        <tr>
            <td><form:label path="emailAddress.email">Email Address</form:label></td>
            <td><form:input path="emailAddress.email" placeholder="Email Address"/></td>
        </tr>


    </table>
    </div>
    <div class="form-group col-md-6 col-sm-6">
        <table>
            <tr>
                <td><form:label path="Address1">Address Line 1</form:label></td>
                <td><form:input path="Address1" placeholder="Address Line 1"/></td>
            </tr>
            <tr>
                <td><form:label path="Address2">Address Line 2</form:label></td>
                <td><form:input path="Address2" placeholder="Address Line 2"/></td>
            </tr>
            <tr>
                <td><form:label path="Suburb">Suburb</form:label></td>
                <td><form:input path="Suburb" placeholder="Suburb"/></td>
            </tr>
            <tr>
                <td><form:label path="City">City</form:label></td>
                <td><form:input path="City" placeholder="City"/></td>
            </tr>
            <tr>
                <td><form:label path="PostalCode">Postal Code</form:label></td>
                <td><form:input path="PostalCode" placeholder="Postal Code"/></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="Register"/>
                </td>
            </tr>

        </table>
    </div>


</form:form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>