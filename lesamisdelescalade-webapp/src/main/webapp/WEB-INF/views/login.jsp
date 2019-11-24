<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login</title>
    <%--<meta name="generator" content="Jekyll v3.8.5">--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Association de fans d'escalade">
    <!-- CDN resources -->
    <%--
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    --%>

    <!-- Locales resources -->
    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">

</head>
<body>
    <div class="wrapper">
        <div class="col col-sm-3">
            <form:form cssClass="form-group" method="post" action="loginProcess" modelAttribute="loginCommand">
                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:input path="email" type="email" cssClass="form-control" placeholder="Email address" required="true" autofocus=""/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password</form:label>
                    <form:password path="password" cssClass="form-control" placeholder="Password" required="true"/>
                </div>
                <div class="form-group">
                    <form:button type="submit" cssClass="btn btn-primary btn-block">Log In</form:button>
                </div>

                <div class="text-center">
                    <p>Nouveau sur le site ? <a href="<c:url value="/doRegister"/>"> Créer un compte.</a></p>
                </div>
            </form:form>
        </div>
    </div>
    <!-- jQuery -->
    <script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
    <!-- Popper.js -->
    <script src="<c:url value="/resources/js/popper.min.js"/>"></script>
    <!-- Javascript de Bootstrap -->
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>

</body>
</html>
