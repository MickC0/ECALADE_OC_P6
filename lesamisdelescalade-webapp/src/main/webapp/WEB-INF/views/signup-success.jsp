<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Sign UP Success</title>
    <meta name="description" content="Association de fans d'escalade">

    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/css/styles.css" type="text/css" rel="stylesheet" />
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h1>${message}</h1>
        <hr />

        <table class="table table-striped table-bordered">
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
        </table>
    </div>
</div>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/popper.min.js"></script>
<!-- Javascript de Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
