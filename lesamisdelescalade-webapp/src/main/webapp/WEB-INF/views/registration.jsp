<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Registration</title>
    <%@include file="_include/head.jsp"%>
</head>
<body>
    <form:form id="regForm"  action="registrationProcess" method="post" modelAttribute="member">
        <table align="center">
            <tr>
                <td>
                    <form:label path="gender">Gender</form:label>
                </td>
                <td>
                    <form:select path="gender" name="gender" id="gender">
                        <form:option value="" label="Civilité"/>
                        <form:option value="M" label="Monsieur"/>
                        <form:option value="F" label="Madame"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="firstName">First Name</form:label>
                </td>
                <td>
                    <form:input path="firstName" name="firstName" id="firstName" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="lastName">Last Name</form:label>
                </td>
                <td>
                    <form:input path="lastName" name="lastName" id="lastName" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="birthdate">Birthdate</form:label>
                </td>
                <td>
                    <form:input type="date" path="birthdate" name="birthdate" id="birthdate" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="pseudo">Username</form:label>
                </td>
                <td>
                    <form:input path="pseudo" name="pseudo" id="pseudo" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email</form:label>
                </td>
                <td>
                    <form:input path="email" name="email" id="email" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password</form:label>
                </td>
                <td>
                    <form:password path="password" name="password" id="password" />
                </td>
            </tr>

            <tr>
                <td></td>
                <td>
                    <form:button id="register" name="register">Register</form:button>
                </td>
            </tr>
            <tr></tr>
            <tr>
                <td></td>
                <td><a href="<c:url value="/home"/>">Home</a>
                </td>
            </tr>
        </table>
    </form:form>
    <%@include file="_include/footer.jsp"%>
</body>
</html>
