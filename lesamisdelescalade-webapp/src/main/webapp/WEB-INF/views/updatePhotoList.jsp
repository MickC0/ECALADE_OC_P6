<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page updatePhotoList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Modification des photos</h2>
                    <a href="<c:out value="javascript:history.go(-1)"/>" class="btn btn-outline-primary btn-block">
                        Annuler
                    </a>
                </div>
                <div class="row">
                    <c:forEach items="${photoList}" var="photo" >
                        <div class="col-md-6 col-lg-4">
                            <div class="card">
                                <img class="card-img-top w-100 d-block" src="<c:url value="${photo.url}"/>">
                                <div class="card-body" >
                                    <h4 class="card-title" style="height: 50px">${photo.name}</h4>
                                    <a href="<c:url value="/updatePhoto/${photo.id}"/>" class="btn btn-outline-secondary btn-sm"> Modifier </a>
                                    <a href="<c:url value="/deletePhoto/${photo.id}"/>" class="btn btn-outline-secondary btn-sm"> Supprimer </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
