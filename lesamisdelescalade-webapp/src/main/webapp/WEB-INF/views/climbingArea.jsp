<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Climbing Area</title>
    <%@include file="_include/head.jsp"%>
</head>
<body>
    <%@include file="_include/navbar.jsp"%>




<div class="container-fluid" style="margin-top:100px">
    <div>
        <h1><c:out value="${climbArea.name}"/> </h1>
        <p>gvfhvgeqahuveahinmvanjmavnm</p>
    </div>
    <div>
        <h2>description</h2>
        <p><c:out value="${climbArea.description}"/> </p>
    </div>
    <div>
        <tr>
            <c:forEach items="${sectorArea}" var="sector" >
                <td><a href="<c:url value="sectorArea/${sector.id}"/>"> <c:out value="${sector.name}"/> </a> </td>
            </c:forEach>
        </tr>
    </div>
    <div>
        <tr>
            <c:forEach items="${routeArea}" var="r" >
                <td><a href="<c:url value="routeArea/${r.id}"/>"> <c:out value="${r.name}"/> </a> </td>
            </c:forEach>
        </tr>
    </div>
</div>

<%@include file="_include/footer.jsp"%>
</body>
</html>
