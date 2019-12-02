<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Route Form</title>
    <%--<%@include file="_include/head.jsp"%>--%>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Association de fans d'escalade">
    <!-- CDN resources -->
    <%--
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    --%>

    <!-- Locales resources -->
    <script src="https://kit.fontawesome.com/c822637fde.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
</head>
<body>
<div class="container">

    <!-- Body
    ================================================== -->

    <!-- display for see site to update-->


    <!-- form for update site -->
    <div>
        <h3>Modification du Site d'escalade:</h3>

        <p></p>
        <form:form modelAttribute="route" method="post" action="saveRoute/${sectorId}">
            <table>
                <tr>
                    <td><form:hidden path="sector.id" value="${sectorId}"/></td>
                    <td><form:errors path="sector.id" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "nomSite" -->
                    <td> Nom de la voie:* </td>
                    <td><form:input path="name" type="text" id="name" size="20" placeholder="obligatoire"  cssStyle=""/></td>
                    <td><form:errors path="name" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "descriptionSite" -->
                    <td>Description de la voie:</td>
                    <td><form:input path="description" type="text" id="description" size="40" placeholder=""  cssStyle=""/></td>
                    <td><form:errors path="description" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "descriptionSite" -->
                    <td>Cotation de la voie:</td>
                    <td><form:input path="cotation" type="text" id="cotation" size="40" placeholder=""  cssStyle=""/></td>
                    <td><form:errors path="cotation" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "descriptionSite" -->
                    <td>Hauteur de la voie:</td>
                    <td><form:input path="height" type="number" id="height" size="40" placeholder=""  cssStyle=""/></td>
                    <td><form:errors path="height" cssClass="errors"/></td>
                </tr>


            </table>
            <p></p>
            <p>(*) obligatoire</p>
            <p></p>
            <input type="submit" value="Envoyer">
        </form:form>
    </div>
</div>
<!-- jQuery -->
<script src="<c:url value="/resources/js/jquery-3.4.1.min.js"/>"></script>
<!-- Popper.js -->
<script src="<c:url value="/resources/js/popper.min.js"/>"></script>
<!-- Javascript de Bootstrap -->
<script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>
</body>
</html>
