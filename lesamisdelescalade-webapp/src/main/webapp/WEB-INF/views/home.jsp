<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page climbingAreaList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Chercher un site</h2>

            </div>
            <div class="row">
                <c:forEach items="${climbingAreaList}" var="climbingArea" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image5.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${climbingArea.name}</h4>
                                <p class="card-text">${climbingArea.region}</p>
                            </div>
                            <div class="card-body">
                                <a href="<c:url value="/climbingArea/${climbingArea.id}"/>" class="btn btn-outline-secondary btn-sm">
                                    Voir
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
