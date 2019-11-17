<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>

<head>
    <title>Les amis de l'escalade</title>
    <%@include file="_include/head.jsp"%>


</head>



<body>
<header>
    <%@include file="_include/navbar.jsp"%>
</header>
<div class="container" style="margin-top:80px">
    <h1>
        Site d'escalade
    </h1>
    <ul>
        <c:forEach items="${climbingAreaList}" var="c" >
            <li>
                <c:out value="${c.name}"/>
                <c:out value="${c.region}"/>
            </li>
        </c:forEach>
    </ul>
    <c:out value="${sessionScope.memberInSessionId}"/>



</div>


</body>
</html>
