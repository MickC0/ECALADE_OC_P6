<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page climbingAreaList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Chercher un site</h2>
                <form:form cssClass="form-inline" modelAttribute="climbingAreaList" method="get">
                    <div class="form-group select-style">
                        <form:select path="region" cssClass="form-control">
                            <form:option value="">Région</form:option>
                            <form:options items="${regionList}"/>
                        </form:select>
                        <form:errors path="region" cssClass="error"/>
                    </div>
                </form:form>

            </div>
            <div class="row">
                <c:forEach items="${climbingAreaList}" var="climbingArea" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <c:if test="${empty climbingArea.photoList}">
                                <img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/no-picture.jpg"/>" >
                            </c:if>
                            <c:if test="${!empty climbingArea.photoList}">
                                <img class="card-img-top w-100 d-block" src="<c:url value="${climbingArea.photoList.get(0).url}"/>">
                            </c:if>
                            <div class="card-body">
                                <h4 class="card-title">${climbingArea.name}</h4>
                                <p class="card-text">${climbingArea.region}</p>
                            </div>
                            <div class="card-body">
                                <a class="btn btn-outline-secondary btn-sm" href="<c:url value="/climbingArea/${climbingArea.id}"/>">Voir</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
