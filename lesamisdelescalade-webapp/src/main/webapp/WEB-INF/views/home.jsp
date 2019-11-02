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

    <!--<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet">-->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/resources/css/styles.css" type="text/css" rel="stylesheet" />

    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>

</head>



<body id="page-top" style="height:1500px">
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


<!--<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" id="mainNav">
    <a class="navbar-brand" href="${context}/home">Les amis de l'escalade</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item active">
                <a class="nav-link" href="${context}/home">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Link</a>
            </li>
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Dropdown
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                    <a class="dropdown-item" href="#">Action</a>
                    <a class="dropdown-item" href="#">Another action</a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#">Something else here</a>
                </div>
            </li>
            <li class="nav-item">
                <a class="nav-link disabled" href="#">Disabled</a>
            </li>
        </ul>
         <form class="form-inline my-2 my-lg-0">
            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>-->


<nav class="navbar navbar-expand-md bg-dark navbar-dark fixed-top">
    <a class="navbar-brand" href="#">LES AMIS DE L'ESCALADE</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navb" class="navbar-collapse collapse hide">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${context}/home">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Page 1</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Page 2</a>
            </li>
        </ul>
        <!-- if user is login -->
        <c:if test="${!empty memberLogged}">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${context}/personalSpace">My Space</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${context}/doLogout">Logout</a>
                </li>
            </ul>

        </c:if>
        <!-- if user not login -->
        <c:if test="${empty memberLogged}">
            <ul class="nav navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="${context}/doRegister"><span class="fas fa-user"></span> Sign Up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${context}/doLogin" data-toggle="modal" data-target="#modalLoginForm"><span class="fas fa-sign-in-alt"></span> Login</a>
                </li>
            </ul>
        </c:if>
    </div>
</nav>


<div class="text-center">
    <a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalLoginForm">Launch
        Modal Login Form</a>
</div>

<div class="modal fade" id="modalLoginForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
     aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header text-center">
                <h4 class="modal-title w-100 font-weight-bold">Login</h4>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body mx-3">
                <div class="md-form mb-5">
                    <i class="fas fa-envelope prefix grey-text"></i>
                    <input type="email" id="defaultForm-email" class="form-control validate">
                    <label data-error="wrong" data-success="right" for="defaultForm-email">Your email</label>
                </div>

                <div class="md-form mb-4">
                    <i class="fas fa-lock prefix grey-text"></i>
                    <input type="password" id="defaultForm-pass" class="form-control validate">
                    <label data-error="wrong" data-success="right" for="defaultForm-pass">Your password</label>
                </div>

            </div>
            <div class="modal-footer d-flex justify-content-center">
                <button class="btn btn-default">Submit</button>
            </div>
        </div>
    </div>
</div>



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
