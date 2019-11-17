<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />

<html>
<head>
    <title>Les amis de l'escalade</title>
    <%@include file="WEB-INF/views/_include/head.jsp"%>
</head>
<body>
<c:redirect url="/home"/>
<%@include file="WEB-INF/views/_include/footer.jsp"%>
</body>
</html>
