<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
    <title>Registration</title>

    <script>
        function onSubmit() {
            document.getElementById("passwordInput").reset();
        }
    </script>

</head>
<body>
<jsp:include page="navbar.jsp"/>
<div class="registrationForm col-md-12 col-sm-12">
<h1>Square Eyes Registration</h1>
<p>Please enter you details below.</p>

<form:form method="POST" modelAttribute="customer" action="/addCustomer">
    <div class="form-group col-md-12 col-sm-12">
        <table id="registrationTable">
        <tr>
            <td><form:label path="account.firstName">Name</form:label></td>
            <td><form:input type="text" required="true" path="account.firstName" placeholder="Name"/></td>
        </tr>
        <tr>
            <td><form:label path="account.surname">Surname</form:label></td>
            <td><form:input type="text" required="true" path="account.surname" placeholder="Surname" /></td>
        </tr>
        <tr>
            <td><form:label path="account.userName">Username</form:label></td>
            <td><form:input required="true" path="account.userName" placeholder="Username"/></td>
        </tr>
        <tr>
            <td><form:label path="account.password">Password</form:label></td>
            <td><form:input id="passwordInput" title="Please enter in a password with a minimum lenght of 6" required="true" path="account.password" placeholder="Password"/></td>
        </tr>
        <tr>
            <td><form:label path="emailAddress.email">Email Address</form:label></td>
            <td><form:input type="email" required="true" path="emailAddress.email" placeholder="Email Address"/></td>
        </tr>
        <tr>
            <td><form:label path="phoneNumber.phoneNumber">Cellphone No</form:label></td>
            <td><form:input required="true" maxlength="13" path="phoneNumber.phoneNumber" placeholder="Cellphone Number"/></td>
        </tr>
            <tr>
                <td><form:label path="address.address1">Address Line 1</form:label></td>
                <td><form:input required="true" path="address.address1" placeholder="Address Line 1"/></td>
            </tr>
            <tr>
                <td><form:label path="address.address2">Address Line 2</form:label></td>
                <td><form:input path="address.address2" placeholder="Address Line 2"/></td>
            </tr>
            <tr>
                <td><form:label path="address.suburb">Suburb</form:label></td>
                <td><form:input required="true" path="address.suburb" placeholder="Suburb"/></td>
            </tr>
            <tr>
                <td><form:label path="address.city">City</form:label></td>
                <td><form:input required="true" path="address.city" placeholder="City"/></td>

            </tr>
            <tr>
                <td><form:label path="address.postalCode">Postal Code</form:label></td>
                <td><form:input title="Please enter in a 4 digit postal code" type="text" pattern="[0-9]{4}" required="true" maxlength="4" path="address.postalCode" placeholder="Postal Code"/></td>

            </tr>
    </table>
        <div id="errorDiv">
            <p>${errorMessage}</p>
            <form:errors path="account.firstName" cssclass="error"/>
            <form:errors path="account.surname" cssclass="error"/>
            <form:errors path="account.password" cssclass="error"/>
            <form:errors path="account.userName" cssclass="error"/>
            <form:errors path="emailAddress.email" cssclass="error"/>
            <form:errors path="phoneNumber.phoneNumber" cssclass="error"/>
            <form:errors path="address.address1" cssclass="error"/>
            <form:errors path="address.address2" cssclass="error"/>
            <form:errors path="address.suburb" cssclass="error"/>
            <form:errors path="address.city" cssclass="error"/>
            <form:errors path="address.postalCode" cssclass="error"/>
        </div>
    </div>


    <div  class="col-md-12 col-sm-12">
        <input id="reigsterButton" onclick="onSubmit()" type="submit" value="Register"/>
    </div>

</form:form>
</div>
<br/>
<br/>


<jsp:include page="footer.jsp"/>
</body>
</html>