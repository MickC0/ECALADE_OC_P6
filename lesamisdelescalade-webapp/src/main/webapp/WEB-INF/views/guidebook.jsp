<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Guidebook</title>
    <%@include file="_include/head.jsp"%>
</head>
<body>
<%@include file="_include/navbar.jsp"%>




<div class="container">
    <div>
        <h1><c:out value="${guidebook.name}"/> </h1>
        <p>gvfhvgeqahuveahinmvanjmavnm</p>
    </div>
    <div>
        <h2>description</h2>
        <p><c:out value="${guidebook.description}"/> </p>
        <c:if test="${guidebook.loaned == false}">
            <td><a href="<c:url value="/showReservationRequestForm/${guidebook.id}"/> " class="btn btn-primary"><i class="fas fa-edit ml-2">Faire une demande de réservation</i></a></td>
        </c:if>
    </div>

</div>

<%@include file="_include/footer.jsp"%>
</body>
</html>
