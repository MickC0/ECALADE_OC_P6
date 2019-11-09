<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Login</title>
    <meta name="generator" content="Jekyll v3.8.5">
    <%@include file="_include/head.jsp"%>
    <link href="${context}/resources/css/login.css" type="text/css" rel="stylesheet" />

</head>
<body class="text-center">
    <form:form cssClass="form-signin" method="post" action="${context}/loginProcess" modelAttribute="loginCommand">
        <a href="${context}/home"><img class="mb-4" src="${context}/resources/img/15562870935067_icon-above-font.png" alt="" width="300" height="168"></a>
        <h1 class="h3 mb-3 font-weight-normal">Enter your log in information</h1>
        <form:input path="email" type="email" class="form-control" placeholder="Email address" required="true" autofocus=""/>
        <form:password path="password" class="form-control" placeholder="Password" required="true"/>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Log in</button>
        <p class="mt-5 mb-3 text-muted">© 2017-2019</p>
    </form:form>
</body>
</html>
