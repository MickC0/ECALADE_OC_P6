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
<header>
    <%@include file="_include/navbar.jsp"%>
</header>

<div class="container-fluid" style="margin-top:80px">
    <table>
        <tr>
            <th>SITE</th>
            <th>Modifier</th>
            <th>Supprimer</th>
            <th>Ajouter</th>
        </tr>
        <tr>
            <c:forEach items="${climbingAreaList}" var="c" >
                <td><c:out value="${c.name}"/></td>
                <td><a href="<c:url value="climbingArea/${c.id}"/>"> </a> </td>
            </c:forEach>
        </tr>
    </table>
    <h2>
        Site d'escalade
    </h2>
    <ul>

    </ul>
</div>
<div class="container-fluid">
    <h2>
        Guidebook
    </h2>
    <ul>
        <c:forEach var="gb" items="${guidebookList}">
            <c:out value="${gb.name}"/>
        </c:forEach>
    </ul>
</div>
<div class="container-fluid">
    <h2>
        MES RESERVATIONS
    </h2>
    <ul>
        <c:forEach var="res" items="${reservationRequestList}">
            <c:out value="${res.guidebook.name}"/>
            <c:out value="${res.reservationState}"/>
        </c:forEach>
    </ul>
</div>

</body>

</html>
