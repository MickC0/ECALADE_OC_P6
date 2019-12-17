<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="fr">
<head>
    <title>Les amis de l'escalade</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Association de fans d'escalade">

    <!-- Locales resources -->
    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="https://fonts.googleapis.com/css?family=Montserrat:400,400i,700,700i,600,600i"/>">
    <link rel="stylesheet" href="<c:url value="/resources/fonts/simple-line-icons.min.css"/>">
    <link rel="stylesheet" href="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/smoothproducts.css"/>">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">--%>
</head>
<body>

<nav class="navbar navbar-light navbar-expand-lg fixed-top bg-white clean-navbar">
    <div class="container">
        <a class="navbar-brand logo" href="<c:url value="/showHome"/>">
            <img src="<c:url value="/resources/img/icon1.svg"/>" style="width: 50px; height:auto">
            Les amis de l'escalade
        </a>
        <button data-toggle="collapse" class="navbar-toggler navbar-toggler-right" data-target="#navcol-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navcol-1">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item" role="presentation"><a class="nav-link" href="<c:url value="/climbingAreaList"/>">Sites d'escalade</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="<c:url value="/guidebookList"/>">Topos d'escalade</a></li>
                <%--<li class="nav-item" role="presentation"><a class="nav-link" href="product-page.html">Product</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="contact-us.html">Contact Us</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="login.html">Login</a></li>
                <li class="nav-item" role="presentation"><a class="nav-link" href="registration.html">Register</a></li>--%>
            </ul>
            <c:choose>
                <c:when test="${!empty memberInSessionId}">
                    <ul class="nav navbar-nav ml-auto">
                            <%--<c:if test="${sessionScope.memberInSessionRole == 'Administrator'}">
                                <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                                    <a class="nav-link" href="<c:url value="/"/>"> Administration </a>
                                </li>
                            </c:if>--%>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" href="<c:url value="/personalSpace/${memberInSessionId}"/>"> Mon dashboard </a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" href="<c:url value="/doLogout"/>"> Se déconnecter</a>
                        </li>
                    </ul>
                </c:when>
                <c:otherwise>
                    <ul class="nav navbar-nav ml-auto">
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" href="<c:url value="/doRegister"/>"><span class="fas fa-user"></span> S'enregistrer</a>
                        </li>
                        <li class="nav-item" role="presentation">
                            <a class="nav-link" href="<c:url value="/doLogin"/>"><span class="fas fa-sign-in-alt"></span> Connexion</a>
                        </li>
                    </ul>
                </c:otherwise>
            </c:choose>
        </div>
    </div>
</nav>