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
<nav class="navbar navbar-inverse " role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <a class="navbar-brand page-top" href="${pageContext.request.contextPath}/home">Les amis de l'escalade</a>
    </div>


    <!-- All elements on navbar -->
    <div class="collapse navbar-collapse">

        <!-- identification -->
        <ul class="nav navbar-nav navbar-right" >
            <li class="dropdown">

                <!-- if user is logged -->
                <c:if test="${!empty logged}"><p style="color:white;"><c:out value="${logged} "/>
                    <br><a href="${pageContext.request.contextPath}/personalSpace">Mon espace personnel</a><br>
                    <a href="${pageContext.request.contextPath}/dologout">Se deconnecter </a></p>
                </c:if>

                <!-- if user not logged -->
                <c:if test="${empty logged}">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">S'identifier <b class="caret"></b></a>
                <ul class="dropdown-menu">
                    <li class="dropdown-header">Vous n'êtes pas identifié.</li>
                    <li><form class="navbar-form" method="post" action="${pageContext.request.contextPath}/logInTry" modelAttribute="member">
                        <input type="text" class="form-control" name="email" placeholder="email" /><br />
                        <input type="password" class="form-control" name="password" placeholder="Mot de passe"/>
                        <input type="submit" class="btn btn-primary btn-xs btn-block" /></form></li>
                    <li class="enable"><a href="${pageContext.request.contextPath}/signUp">Créer un compte...</a></li>
                </ul>
                </c:if>
            </li>
        </ul>

    </div>
</nav>
<!--<h1>Les Amis de l'Escalade</h1>
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
</div>-->


</body>
</html>
