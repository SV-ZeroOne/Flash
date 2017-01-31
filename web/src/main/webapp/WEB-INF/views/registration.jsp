<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Registration</title>
</head>
<body>
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
</body>
</html>