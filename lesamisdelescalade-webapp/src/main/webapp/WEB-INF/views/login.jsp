<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Login</title>
    <%--<meta name="generator" content="Jekyll v3.8.5">--%>
    <%@include file="_include/head.jsp"%>

</head>
<body>
    <div class="wrapper">
        <div class="col col-sm-3">
            <form:form cssClass="form-group" method="post" action="loginProcess" modelAttribute="loginCommand">
                <div class="block-heading">
                    <h2 class="text-info">Log In</h2>
                    <p>
                        <c:if test="${errorMessage != null}">
                            ${errorMessage}
                        </c:if>
                    </p>
                </div>

                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:input path="email" type="email" cssClass="form-control" placeholder="Email address" required="true" autofocus=""/>
                </div>
                <div class="form-group">
                    <form:label path="password">Password</form:label>
                    <form:password path="password" cssClass="form-control" placeholder="Password" required="true"/>
                </div>
                <div class="form-group">
                    <form:button type="submit" cssClass="btn btn-primary btn-block">Log In</form:button>
                </div>

                <div class="text-center">
                    <p>Nouveau sur le site ? <a href="<c:url value="/doRegister"/>"> Créer un compte.</a></p>
                </div>
            </form:form>
        </div>
    </div>
    <%@include file="_include/footer.jsp"%>
</body>
</html>
