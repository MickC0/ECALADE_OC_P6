<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<%--
<%@include file="_include/navbar.jsp"%>
--%>
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

<main class="page service-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Chercher un site</h2>
                <select class="mdb-select md-form colorful-select dropdown-primary" multiple searchable="Search here..">
                    <option value="" disabled selected>Choose your country</option>
                    <option value="1">USA</option>
                    <option value="2">Germany</option>
                    <option value="3">France</option>
                    <option value="3">Poland</option>
                    <option value="3">Japan</option>
                </select>
                <label class="mdb-main-label">Label example</label>

                <select class="mdb-select" multiple searchable="Search here..">
                    <optgroup label="team 1">
                        <option value="1">Option 1</option>
                        <option value="2">Option 2</option>
                    </optgroup>
                    <optgroup label="team 2">
                        <option value="3">Option 3</option>
                        <option value="4">Option 4</option>
                    </optgroup>
                </select>
            </div>
            <div class="row">
                <c:forEach items="${climbingAreaList}" var="climbingArea" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image5.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${climbingArea.name}</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/climbingArea/${climbingArea.id}"/>">Voir</a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>


<footer class="page-footer dark">
    <div class="container">
        <div class="row">
            <div class="col-sm-3">
                <h5>Get started</h5>
                <ul>
                    <li><a href="#">Home</a></li>
                    <li><a href="#">Sign up</a></li>
                    <li><a href="#">Downloads</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>About us</h5>
                <ul>
                    <li><a href="#">Company Information</a></li>
                    <li><a href="#">Contact us</a></li>
                    <li><a href="#">Reviews</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>Support</h5>
                <ul>
                    <li><a href="#">FAQ</a></li>
                    <li><a href="#">Help desk</a></li>
                    <li><a href="#">Forums</a></li>
                </ul>
            </div>
            <div class="col-sm-3">
                <h5>Legal</h5>
                <ul>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Terms of Use</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div class="footer-copyright">
        <p>© 2018 Copyright Text</p>
    </div>
</footer>





<%--<%@include file="_include/footer.jsp"%>--%>

<!-- Locales resources -->

<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<!-- Popper.js -->
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<!-- Javascript de Bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
<script src="<c:url value="https://cdnjs.cloudflare.com/ajax/libs/baguettebox.js/1.10.0/baguetteBox.min.js"/>"></script>
<script src="<c:url value="/resources/js/smoothproducts.min.js"/>"></script>
<script src="<c:url value="/resources/js/theme.js"/>"></script>
</body>

</html>
