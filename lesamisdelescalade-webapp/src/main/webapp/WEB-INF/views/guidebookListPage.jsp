<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page guidebookList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Topos mis à disposition par les utilisateurs</h2>
            </div>
            <div class="row">
                <c:forEach items="${guidebookList}" var="guidebook" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">${guidebook.name}</h4>

                            </div>
                            <div class="card-body">

                                <a href="<c:url value="/guidebook/${guidebook.id}"/>" class="btn btn-outline-secondary btn-sm">
                                    Voir
                                </a>
                            </div>
                            <div class="card-footer">
                                <c:choose>
                                    <c:when test="${guidebook.loaned == false}">
                                        <p class="bg-success text-white">DISPONIBLE</p>
                                    </c:when>
                                    <c:otherwise>
                                        <p class="bg-danger text-white">INDISPONIBLE</p>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
