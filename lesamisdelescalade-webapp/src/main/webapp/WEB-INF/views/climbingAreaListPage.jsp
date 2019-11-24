<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
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
    <title>Climbing Aera List</title>

</head>
<body>
<%@include file="_include/navbar.jsp"%>
<div class="container my-2">
    <div class="card">
        <div class="card-body">
            <div  class="container my-5">

                <p class="my-5">
                    <a href="<c:url value="/showClimbingAreaForm"/>" class="btn btn-primary"><i
                            class="fas fa-user-plus ml-2"> Add </i></a>
                </p>
                <div class="col-md-10">
                    <c:if test="${empty climbingAreaList}">
                        <h2> No climbing area yet!</h2>
                    </c:if>

                    <div>
                        <table class="table table-striped table-responsive-md">
                            <thead>
                            <tr>
                                <th>Name</th>
                                <th>region</th>
                                <th>description</th>
                                <th>Edit</th>
                                <th>Delete</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${climbingAreaList}" var="c">
                                <tr>
                                    <td>${c.name}</td>
                                    <td>${c.region}</td>
                                    <td>${c.description}</td>
                                    <td><a href="<c:url value="/editClimbingArea/${c.id}"/>" class="btn btn-primary"><i class="fas fa-user-edit ml-2"></i></a></td>
                                    <td><a href="<c:url value="/deleteClimbingArea/${c.id}"/>" class="btn btn-primary"><i class="fas fa-user-times ml-2"></i></a></td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>

                </div>
            </div>
        </div>
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
