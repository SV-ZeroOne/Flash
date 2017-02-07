<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Slab" rel="stylesheet">
    <link type="text/css" rel="stylesheet" href="assets/css/main.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>Login</title>
</head>
<body>
<jsp:include page="navbar.jsp"/>
<h1 id="loginHeading">Login</h1>
<div id="loginDiv" class="col-md-12 col-sm-12">

<form  name='f' action="/login" method='POST'>

    <table id="loginForm">

        <tr>
            <td>User:</td>
        </tr>
        <tr>
            <td><input type='text' name='username' value=''></td>
        </tr>
        <tr>
            <td>Password:</td>
        </tr>
        <tr>
            <td><input type='password' name='password' /></td>
        </tr>
        <tr>
            <td><input class="btn btn-default" id="loginButton" name="submit" type="submit" value="Login"/></td>
        </tr>
        <tr>
            <td>
                <c:if test="${param.error != null}">
                    <p id="loginError">
                        Invalid login details.
                    </p>
                </c:if>
            </td>
        </tr>
        <tr>
            <td>Dont have an account?</td>
        </tr>
        <tr>
            <td><a href="/registration">Register Here</a> </td>
        </tr>
        <input type="hidden" name="${_csrf.parameterName}"   value="${_csrf.token}" />
    </table>

</form>
</div>
<jsp:include page="footer.jsp"/>
</body>
</html>
