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
    <h1>
        Site d'escalade
    </h1>
    <ul>
        <c:forEach items="${climbingAreaList}" var="c" >
            <c:out value="${c.name}"/>
        </c:forEach>
    </ul>
    <h1>
        Guidebook
    </h1>
    <ul>
        <c:forEach var="gb" items="${guidebookList}">
            <c:out value="${gb.name}"/>
        </c:forEach>
    </ul>
</div>

</body>

</html>
