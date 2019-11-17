<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="fr">
<head>
    <title>Les amis de l'escalade</title>
    <%@include file="_include/head.jsp"%>
</head>
<body>
<%--
<%@include file="_include/navbar.jsp"%>
--%>
<section class="plop">
    <div class="container">
        <div class="row">
            <div class="col col-md-4">
                <h2 class="text-info">SITES</h2>
                <ul>
                    <c:forEach items="${climbingAreaList}" var="c" >
                        <li>
                            <c:out value="${c.name}"/>
                            <c:out value="${c.region}"/>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
    </div>
</section>

<div class="container">
    <div class="row">
        <div class="col-sm-2">
            2 colonnes
        </div>
        <div class="col-sm-3">
            3 colonnes
        </div>
        <div class="col-sm-7">
            7 colonnes
        </div>
    </div>
</div>


<%@include file="_include/footer.jsp"%>
</body>

</html>
