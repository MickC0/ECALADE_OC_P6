<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<nav class="navbar navbar-expand-md bg-light navbar-light fixed-top">
    <a class="navbar-brand" href="<c:url value="/home"/>">LES AMIS DE L'ESCALADE</a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navcol-1" aria-expanded="true">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div id="navcol-1" class="navbar-collapse collapse hide">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/climbingAreaList"/>">SITES D'ESCALADE</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="#">TOPOS D'ESCALADE</a>
            </li>
            <c:if test="${!empty memberInSession}">
                <li class="nav-item">
                    <a class="nav-link" href="#">MES RESERVATIONS</a>
                </li>
            </c:if>

        </ul>
        <c:choose>
            <c:when test="${!empty memberInSessionId}">
                <ul class="nav navbar-nav ml-auto">
                    <c:if test="${sessionScope.memberInSessionRole == 'Administrator'}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value="/"/>"> Administration </a>
                        </li>
                    </c:if>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/personalSpace"/>"> ${sessionScope.memberInSessionPseudo} </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/doLogout"/>"> Logout</a>
                    </li>
                </ul>


            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/doRegister"/>"><span class="fas fa-user"></span> Sign Up</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value="/doLogin"/>"><span class="fas fa-sign-in-alt"></span> Login</a>
                    </li>
                </ul>

            </c:otherwise>
        </c:choose>
    </div>
</nav>
