<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Registration</title>
    <%@include file="_include/head.jsp"%>
    <link href="${context}/resources/css/registration.css" type="text/css" rel="stylesheet" />




</head>
<body>
    <form:form id="regForm"  action="${context}/registrationProcess" method="post" modelAttribute="member">
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
                <td><a href="${context}/home">Home</a>
                </td>
            </tr>
        </table>
    </form:form>






    <!-- EXEMPLE -->
    <%--<div class="login-dark">
        <form>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">City</label>
                    <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">State</label>
                    <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Check me out
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form>
    </div>--%>

    <%--<div class="form-box center-box">
        <form:form action="${context}/registrationProcess" cssClass="form-horizontal" method="post" modelAttribute="member">
            <div class="form-row align-items-center">
                <div class="col-auto my-1">
                    <form:select path="gender" cssClass="custom-select mr-sm-2">
                        <form:option value="N/C" label="Civilité"/>
                        <form:option value="1" label="Monsieur"/>
                        <form:option value="2" label="Madame"/>
                    </form:select>
                </div>

                <div class="col-auto my-1">
                    <form:input path="firstName" type="text" placeholder="First name" required="true"/>
                </div>
                <div class="col-auto my-1">
                    <form:input path="lastName" type="text" placeholder="Last name" required="true"/>
                </div>

                <div class="form-group col-md-3">

                    <label for="inputEmail4">Email</label>
                    <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                </div>
                <div class="form-group col-md-6">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                </div>
            </div>
            <div class="form-group">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
            </div>
            <div class="form-group">
                <label for="inputAddress2">Address 2</label>
                <input type="text" class="form-control" id="inputAddress2" placeholder="Apartment, studio, or floor">
            </div>
            <div class="form-row">
                <div class="form-group col-md-6">
                    <label for="inputCity">City</label>
                    <input type="text" class="form-control" id="inputCity">
                </div>
                <div class="form-group col-md-4">
                    <label for="inputState">State</label>
                    <select id="inputState" class="form-control">
                        <option selected>Choose...</option>
                        <option>...</option>
                    </select>
                </div>
                <div class="form-group col-md-2">
                    <label for="inputZip">Zip</label>
                    <input type="text" class="form-control" id="inputZip">
                </div>
            </div>
            <div class="form-group">
                <div class="form-check">
                    <input class="form-check-input" type="checkbox" id="gridCheck">
                    <label class="form-check-label" for="gridCheck">
                        Check me out
                    </label>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">Sign in</button>
        </form:form>
    </div>--%>



</body>
</html>
