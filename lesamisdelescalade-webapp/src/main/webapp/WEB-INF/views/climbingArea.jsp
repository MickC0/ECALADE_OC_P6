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

<div>
    <div>
        <h1><c:out value="${climbingArea.name}"/> </h1>
    </div>
    <div>
        <h1><c:out value="${climbingArea.description}"/> </h1>
    </div>
    <div>
        <h1><c:out value="${climbingArea.}"/> </h1>
    </div>
</div>

<%@include file="_include/footer.jsp"%>
</body>
</html>
