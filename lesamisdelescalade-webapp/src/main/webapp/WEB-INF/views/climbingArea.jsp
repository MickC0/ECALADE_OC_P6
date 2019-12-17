

<%@include file="_include/head.jsp"%>



<div class="container">
    <div>
        <h1><c:out value="${climbArea.name}"/> </h1>
        <p>gvfhvgeqahuveahinmvanjmavnm</p>
        <c:if test="${!empty memberInSessionId}">
            <td><a href="<c:url value="/updateClimbingArea/${climbArea.id}"/>"> Update </a> </td>
        </c:if>
    </div>
    <div>
        <h2>description</h2>
        <p><c:out value="${climbArea.description}"/> </p>
    </div>
    <div>
        <p class="my-5">
            <a href="<c:url value="/createNewSector/${climbArea.id}"/>" class="btn btn-primary">
                <i class="fas fa-plus-square ml-2"> Add a new sector </i>
            </a>
        </p>
        <table class="table table-striped table-responsive-md">
            <thead>
            <tr>
                <th>Secteur</th>
                <th>Edit</th>
                <th>Add Route</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${sectorArea}" var="sector" >
                <tr>
                    <td>${sector.name}</td>
                    <td><a href="<c:url value="/updateSector/${sector.id}"/>" class="btn btn-primary"><i class="fas fa-edit ml-2"></i></a></td>
                    <td><a href="<c:url value="/createNewRoute/${sector.id}"/>" class="btn btn-primary">
                        <i class="fas fa-plus-square ml-2"> Add a new route </i></a></td>
                    <td><a href="<c:url value="/deleteSector/${sector.id}"/> " class="btn btn-primary"><i class="fas fa-trash ml-2"> Delete</i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
    <div>
        <table class="table table-striped table-responsive-md">
            <thead>
            <tr>
                <th>Route</th>
                <th>Secteur</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${routeArea}" var="r" >
                <tr>
                    <td>${r.name}</td>
                    <td>${r.sector.name}</td>
                    <td><a href="<c:url value="/updateRoute/${r.id}"/> " class="btn btn-primary"><i class="fas fa-edit ml-2">Update route</i></a></td>
                    <td><a href="<c:url value="/deleteRoute/${r.id}"/> " class="btn btn-primary"><i class="fas fa-trash ml-2">Delete</i></a></td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
   </div>

<%@include file="_include/footer.jsp"%>
