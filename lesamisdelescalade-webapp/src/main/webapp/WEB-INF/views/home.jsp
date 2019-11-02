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
    <title>Les amis de l'escalade</title>
    <meta name="description" content="Association de fans d'escalade">

    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/resources/css/styles.css" type="text/css" rel="stylesheet" />

</head>



<body style="height:1500px">
<header>
    <!-- Navigation
 ================================================== -->
    <nav class="navbar navbar-inverse " role="navigation">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-top" href="${context}/home">Les amis de l'escalade</a>
        </div>
        <!-- All elements on navbar -->
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right" >
                <li class="dropdown">

                    <!-- if user is login -->
                    <c:if test="${!empty memberLogged}">
                        <p style="color:black;">
                            <c:out value="${logMember} "/>
                            <br><a href="${context}/personalSpace">Mon espace personnel</a><br>
                            <a href="${context}/doLogout">Se deconnecter </a>
                        </p>
                    </c:if>

                    <!-- if user not login -->
                    <c:if test="${empty memberLogged}">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">S'identifier <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li class="dropdown-header">Vous n'êtes pas identifié.</li>
                        <li>
                            <form class="navbar-form" method="post" action="${context}/doLogin" modelAttribute="member">
                                <input type="text" class="form-control" name="email" placeholder="email" /><br />
                                <input type="password" class="form-control" name="password" placeholder="Mot de passe"/>
                                <input type="submit" class="btn btn-primary btn-xs btn-block" />
                            </form>
                        </li>
                        <li class="disabled"><a href="#">Mot de passe oublié ?</a></li>
                        <li class="enable"><a href="${context}/doRegister">Créer un compte...</a></li>
                    </ul>
                    </c:if>
                </li>
            </ul>

            <!-- identification -->
            <ul class="nav navbar-nav">
                <li><a href="${context}/searchSite">Recherche</a></li>
                <li><a href="${context}/createClimbingSite">Enregistrer un nouveau site d'escalade</a></li>
                <li><a href="${context}/exchangeTopoPapier">Echange de Topo papier</a></li>
            </ul>

        </div>
    </nav>
</header>

<div class="container-fluid" style="margin-top:80px">
<h1>Texte pour test</h1>
<p>pataat</p><br>

</div>

<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/popper.min.js"></script>
<!-- Javascript de Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
