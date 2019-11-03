<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Personal Space</title>

    <%@include file="_include/head.jsp"%>

</head>
<body>

<nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
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

        <ul class="nav navbar-nav ml-auto">
            <li class="nav-item">
                <a class="nav-link" href="${context}/doLogout"> Logout</a>
            </li>
        </ul>
    </div>
</nav>

    <section id="personalClimbingAera" class="content-section text-center">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8 mx-auto">
                    <h2>MES SITES</h2>
                    <div id ="carousel-pca" class="carousel slide" data-ride="carousel">
                        <div class="carousel slide" data-ride="carousel" id="carousel-1">
                            <div class="carousel-inner" role="listbox">
                                <div class="carousel-item active">
                                    <img class="w-100 d-block" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" alt="Slide Image" />
                                </div>
                                <div class="carousel-item">
                                    <img class="w-100 d-block" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" alt="Slide Image" />
                                </div>
                                <div class="carousel-item">
                                    <img class="w-100 d-block" src="https://cdn.bootstrapstudio.io/placeholders/1400x800.png" alt="Slide Image" />
                                </div>
                            </div>
                            <div>
                                <a class="carousel-control-prev" href="#carousel-pca" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span></a>
                                <a class="carousel-control-next" href="#carousel-pca" role="button"
                                                                                                                                                                                                                                    data-slide="next"><span class="carousel-control-next-icon" aria-hidden="true"></span><span class="sr-only">Next</span></a></div>
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-pca" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-pca" data-slide-to="1"></li>
                                <li data-target="#carousel-pca" data-slide-to="2"></li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</body>
</html>
