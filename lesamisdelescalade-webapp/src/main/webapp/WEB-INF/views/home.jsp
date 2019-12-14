<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="fr">
<head>
    <title>Les amis de l'escalade</title>
    <%--<%@include file="_include/head.jsp"%>--%>
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
<%--
<%@include file="_include/navbar.jsp"%>
--%>
<nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="<c:url value="/showHome"/>">
        <img src="<c:url value="/resources/img/icon1.svg"/>" style="width: 50px; height:auto">
        Les amis de l'escalade
    </a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar" >
        <ul class="navbar-nav">
            <li class="nav-item" data-toggle="collapse" data-target=".navbar-collapse.show">
                <a class="nav-link" href="<c:url value="/climbingAreaList"/>">Sites d'escalade</a>
            </li>
            <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                <a class="nav-link" href="#">Topos</a>
            </li>
            <c:if test="${!empty memberInSessionId}">
                <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                    <a class="nav-link" href="#">Mes réservations</a>
                </li>
            </c:if>
        </ul>
        <c:choose>
            <c:when test="${!empty memberInSessionId}">
                <ul class="nav navbar-nav ml-auto">
                    <c:if test="${sessionScope.memberInSessionRole == 'Administrator'}">
                        <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                            <a class="nav-link" href="<c:url value="/"/>"> Administration </a>
                        </li>
                    </c:if>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/personalSpace"/>"> ${sessionScope.memberInSessionPseudo} </a>
                    </li>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doLogout"/>"> Logout</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doRegister"/>"><span class="fas fa-user"></span> Sign Up</a>
                    </li>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doLogin"/>"><span class="fas fa-sign-in-alt"></span> Login</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
<section class="plop">
    <div class="container">
        <div class="row">
            <div class="col col-md-4">
                <h2 class="text-info">SITES</h2>
                <table>
                    <c:forEach items="${climbingAreaList}" var="c" >
                        <tr>
                            <td><img src="" alt="pas de photo" style="width:100px;height:100px;border:0;"></td>>
                            <td>${c.name}</td>
                            <td>${c.region}</td>
                            <c:if test="${!empty memberInSessionId}">
                                <td><a href="<c:url value="/editClimbingArea/${c.id}"/>"> Update </a> </td>
                                <td><a href="<c:url value="/showClimbingAreaForm"/>"> create </a> </td>
                                <td><a href="<c:url value="/deleteClimbingArea/${c.id}"/>"> delete </a> </td>
                            </c:if>
                            <td><a href="<c:url value="/climbingArea/${c.id}"/>"> show </a> </td>
                        </tr>
                    </c:forEach>
                </table>

            </div>
        </div>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col-sm-2">
            2 colonnes
        </div>
        <div class="col-sm-3">
            3 colonnes
        </div>
        <div class="col-sm-7">
            7 colonnes
        </div>
    </div>
</div>


<%--<%@include file="_include/footer.jsp"%>--%>

<!-- Locales resources -->

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<!-- Popper.js -->
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<!-- Javascript de Bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>

</html>
