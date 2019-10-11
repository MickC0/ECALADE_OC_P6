<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Confirmed registration</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Javascript de Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h1>${message}</h1>
        <hr />
        <table class="table table-striped table-bordered">
            <tr>
                <td><b>Gender </b>: ${member.gender}</td>
            </tr>
            <tr>
                <td><b>First Name </b>: ${member.firstName}</td>
            </tr>
            <tr>
                <td><b>Last Name </b> : ${member.lastName}</td>
            </tr>
            <tr>
                <td><b>UserName </b> : ${member.pseudo}</td>
            </tr>
            <tr>
                <td><b>Email </b>: ${member.email}</td>
            </tr>
            <tr>
                <td><b>Birthdate </b>:<fmt:formatDate value="${member.birthDate}" pattern="dd-MM-yyyy"/> </td>
            </tr>
        </table>
    </div>
</div>
</body>
</html>
