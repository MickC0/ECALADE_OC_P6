<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Login</title>
    <meta name="description" content="Association de fans d'escalade">

    <!--<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet">-->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="${context}/resources/css/styles.css" type="text/css" rel="stylesheet" />

    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>
</head>
<body>
    <form:form  method="post" action="${context}/loginProcess" modelAttribute="memberInSession">

        <form:label path="email">Enter your user-name</form:label>
        <form:input id="email" name="email" path="email" /><br>
        <form:label path="email">Please enter your password</form:label>
        <form:password id="password" name="password" path="password" /><br>
        <input type="submit" value="Submit" />
    </form:form>
</body>
</html>
