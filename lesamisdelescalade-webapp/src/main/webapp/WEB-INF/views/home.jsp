<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>

<head>
    <title>Les amis de l'escalade</title>
    <%@include file="_include/head.jsp"%>
    <link href="${context}/resources/css/styles.css" type="text/css" rel="stylesheet" />


</head>



<body id="page-top" style="height:1500px">
<header>
    <%@include file="_include/navbar.jsp"%>
</header>
<div class="container-fluid" style="margin-top:80px">
    <h1>
        Site d'escalade
    </h1>
    <ul>
        <c:forEach items="${climbingAreaList}" var="c" >
            <c:out value="Nom du site">
                <li>${c.name}</li>
                <li>${c.region}</li>
            </c:out>
        </c:forEach>
    </ul>



</div>




<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<!-- Popper.js -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.15.0/popper.min.js"></script>
<!-- Javascript de Bootstrap -->
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>
</html>
