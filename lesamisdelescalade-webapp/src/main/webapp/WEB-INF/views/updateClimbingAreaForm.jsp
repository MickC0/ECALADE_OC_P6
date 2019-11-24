<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Update ClimbingArea Form</title>
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

    <!-- form for update site -->
    <div>
        <h3>Modification du Site d'escalade:</h3>
        <c:if test="${!empty errorMessage}">
            <c:out value="${errorMessage}"/>
        </c:if>
        <p></p>
        <form:form method="post" action="updateClimbingArea/${climbingAreaToUpdate.id}" modelAttribute="climbingAreaToUpdate" >
            <table>
                <tr>
                    <td><form:hidden path="id" value="${climbingAreaToUpdate.id}"/></td>
                    <td><form:errors path="id" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "nomSite" -->
                    <td> Nom du site:* </td>
                    <td><form:input path="name" type="text" value="${climbingAreaToUpdate.name}" id="name" size="20" placeholder="obligatoire"  cssStyle=""/></td>
                    <td><form:errors path="name" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "localisationDepartement" -->
                    <td>Region:*</td>
                    <td><form:input path="region" type="text" value="${climbingAreaToUpdate.region}" id="region" placeholder="obligatoire" size="20"  cssStyle="" /></td>
                    <td><form:errors path="region" cssClass="errors" /></td>
                </tr>
                <tr>
                    <!-- display for "descriptionSite" -->
                    <td>Description:</td>
                    <td><form:input path="description" type="text"  value="${climbingAreaToUpdate.description}" id="description" size="40" placeholder=""  cssStyle=""/></td>
                    <td><form:errors path="description" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "localisationPays" -->
                    <td>Profil :* </td>
                    <td><form:input path="profil" type="text" value="${climbingAreaToUpdate.profil}" id="profil" size="20" placeholder="obligatoire" cssStyle=""/></td>
                    <td><form:errors path="profil" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "urlPhotoSite" -->
                    <td>Type de roche: </td>
                    <td><form:input path="rockType" type="text" value="${climbingAreaToUpdate.rockType}" id="rockType" placeholder="" cssStyle=""/></td>
                    <td><form:errors path="rockType" cssClass="errors"/></td>
                </tr>
                <tr>
                    <!-- display for "nombre de secteur" -->
                    <td> Hauteur max:* </td>
                    <td><form:input path="maximumHeight" type="number" value="${climbingAreaToUpdate.maximumHeight}" id="maximumHeight" size="15" placeholder="" cssStyle=""/></td>
                    <td><form:errors path="maximumHeight" cssClass="errors"/></td>
                </tr>
                <tr>
                    <td> Approuved:* </td>
                    <td><form:checkbox path="approuved" value="${climbingAreaToUpdate.approuved}"/></td>
                    <td><form:errors path="approuved" cssClass="errors"/></td>
                </tr>

            </table>
            <p></p>
            <p>(*) obligatoire</p>
            <p></p>
            <form:button type="submit" cssClass="btn btn-primary btn-block">Envoyer</form:button>
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
