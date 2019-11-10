<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
    <a class="navbar-brand" href="${context}/home">LES AMIS DE L'ESCALADE</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navb" aria-expanded="true">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navb" class="navbar-collapse collapse hide">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${context}/climbingAreaListPage">SITES D'ESCALADE</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">TOPOS D'ESCALADE</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">Page 2</a>
            </li>
        </ul>
        <c:choose>
            <c:when test="${!empty memberInSession}">
                <c:out value="${memberInSession}"/>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${context}/personalSpace"> ${sessionScope.memberPseudo} </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${context}/log/doLogout"> Logout</a>
                    </li>
                </ul>


            </c:when>
            <c:otherwise>
                <c:out value="${memberInSession}"/>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${context}/log/doRegister"><span class="fas fa-user"></span> Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${context}/log/doLogin"><span class="fas fa-sign-in-alt"></span> Login</a>
                    </li>
                </ul>

            </c:otherwise>
        </c:choose>
    </div>
</nav>
