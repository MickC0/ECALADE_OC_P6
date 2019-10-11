<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Les Amis de l'Escalade</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Javascript de Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<h1>Les Amis de l'Escalade</h1>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title"></div>
            </div>
            <div class="panel-body">
                <form:form action="signUp" cssClass="form-horizontal" method="get">
                    <div class="form-group">
                        <input type="submit" value="Sign Up">
                </form:form>
            </div>
        </div>
        </div>
    </div>
</div>


</body>
</html>
