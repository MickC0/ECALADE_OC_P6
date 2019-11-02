<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registration Success</title>
    <META HTTP-EQUIV="Refresh" CONTENT="3;URL=${context}/home">
</head>
<body>
<div class="container">

    <p><b>Vous êtes bien enregistré</b></p>
    <p><b>Vous allez être redirigé vers la page d'accueil.</b></p>

</div>
</body>
</html>
