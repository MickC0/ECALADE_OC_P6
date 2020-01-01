<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page climbingArea-page">
    <section class="clean-block clean-product dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">${climbArea.name.toUpperCase()}</h2>
                <c:if test="${sessionScope.memberInSessionRole == 'Administrator' || climbArea.member.id == sessionScope.memberInSessionId}">
                 <span>
                    <a class="btn btn-sm btn-outline-primary" href="<c:url value="/updateClimbingArea/${climbArea.id}"/>"> Modifier le site</a>
                </span>
                </c:if>
            </div>
            <div class="block-content">
                <div class="product-info">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="gallery">
                                <div class="sp-wrap">
                                    <a href="<c:url value="/resources/img/image4.jpg"/>">
                                        <img class="img-fluid d-block mx-auto" src="<c:url value="/resources/img/image4.jpg"/>">
                                    </a>
                                    <a href="<c:url value="/resources/img/image5.jpg"/>">
                                        <img class="img-fluid d-block mx-auto" src="<c:url value="/resources/img/image5.jpg"/>">
                                    </a>
                                    <a href="<c:url value="/resources/img/image6.jpg"/>">
                                        <img class="img-fluid d-block mx-auto" src="<c:url value="/resources/img/image6.jpg"/>">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="info">
                                <h3>Description</h3>
                                <c:if test="${climbArea.approuved == false && (sessionScope.memberInSessionRole == 'Administrator' || climbArea.member.id == sessionScope.memberInSessionId)}">
                                    <div>
                                        <a href="<c:url value="/updateClimbingArea/${climbArea.id}"/>" class="btn btn-outline-primary"> Approuver le site </a>
                                    </div>
                                </c:if>
                                <c:if test="${climbArea.approuved == true}">
                                    <div>
                                        <p>Site officiel : <img src="<c:url value="/resources/img/icon-above-font.png"/>" style="width: 120px; height:auto">
                                        </p>
                                    </div>
                                </c:if>
                                <div class="summary">
                                    <p>${climbArea.description}</p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="product-info">
                    <div>
                        <ul class="nav nav-tabs" id="myTab">
                            <li class="nav-item"><a class="nav-link active" role="tab" data-toggle="tab" id="description-tab" href="#description">Secteurs</a></li>
                            <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="specifications-tabs" href="#specifications">Routes</a></li>
                            <li class="nav-item"><a class="nav-link" role="tab" data-toggle="tab" id="reviews-tab" href="#reviews">Commentaires</a></li>
                        </ul>
                        <div class="tab-content" id="myTabContent">
                            <div class="tab-pane active fade show specifications" role="tabpanel" id="description">
                                <c:if test="${(!empty memberInSessionId && sessionScope.memberInSessionId == climbArea.member.id) || sessionScope.memberInSessionRole == 'Administrator'}">
                                    <p class="my-5">
                                        <a href="<c:url value="/createNewSector/${climbArea.id}"/>" class="btn btn-outline-primary">
                                            <i class="fas fa-plus-square ml-2"> Ajouter un nouveau secteur </i>
                                        </a>
                                    </p>
                                </c:if>
                                <table class="table table-striped table-responsive-lg">
                                    <thead>
                                    <tr>
                                        <th class="align-middle" style="text-align: center">Secteur</th>
                                        <th class="align-middle" style="text-align: center">Description</th>
                                        <c:if test="${(!empty memberInSessionId && sessionScope.memberInSessionId == climbArea.member.id) || sessionScope.memberInSessionRole == 'Administrator'}">
                                            <th class="align-middle" style="text-align: center">Editer</th>
                                            <th class="align-middle" style="text-align: center">Ajouter une voie</th>
                                            <th class="align-middle" style="text-align: center">Supprimer</th>
                                        </c:if>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${sectorList}" var="sector" >
                                        <tr>
                                            <td class="align-middle" style="text-align: center">${sector.name}</td>
                                            <td class="align-middle" style="text-align: center">${sector.description}</td>
                                            <c:if test="${(!empty memberInSessionId && sessionScope.memberInSessionId == sector.climbingArea.member.id) || sessionScope.memberInSessionRole == 'Administrator'}">
                                                <td class="align-middle" style="text-align: center">
                                                    <a href="<c:url value="/updateSector/${sector.id}"/>" class="btn btn-outline-primary">
                                                        <i class="fas fa-edit ml-2"></i>
                                                    </a>
                                                </td>
                                                <td class="align-middle" style="text-align: center">
                                                    <a href="<c:url value="/createNewRoute/${sector.id}"/>" class="btn btn-outline-success">
                                                        <i class="fas fa-plus-square ml-2">
                                                        </i>
                                                    </a>
                                                </td>
                                                <td class="align-middle" style="text-align: center">
                                                    <a href="<c:url value="/deleteSector/${sector.id}"/> " class="btn btn-outline-danger">
                                                        <i class="fas fa-trash ml-2"></i>
                                                    </a>
                                                </td>
                                            </c:if>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="tab-pane fade show specifications" role="tabpanel" id="specifications">
                                <c:forEach items="${sectorList}" var="sector" >
                                    <section class="clean-block clean-services dark">
                                        <div class="container">
                                            <div class="block-heading">
                                                <h2 class="text-info">Voies du secteur ${sector.name.toUpperCase()}</h2>
                                            </div>
                                            <div class="row">
                                                <div class="col">
                                                    <div class="card shadow mb-3">
                                                        <div class="card-header py-3">
                                                        </div>
                                                        <div class="card-body">
                                                            <table class="table text-justify my-0">
                                                                <thead>
                                                                <tr>
                                                                    <th class="align-middle" style="text-align: center">Nom</th>
                                                                    <th class="align-middle" style="text-align: center">Cotation</th>
                                                                    <th class="align-middle" style="text-align: center">Hauteur</th>
                                                                    <th class="align-middle" style="text-align: center">Description</th>
                                                                    <c:if test="${(!empty memberInSessionId && sessionScope.memberInSessionId == sector.climbingArea.member.id) || sessionScope.memberInSessionRole == 'Administrator'}">
                                                                        <th class="align-middle" style="text-align: center">Editer</th>
                                                                        <th class="align-middle" style="text-align: center">Supprimer</th>
                                                                    </c:if>
                                                                </tr>
                                                                </thead>
                                                                <tbody>
                                                                <c:forEach items="${sector.routeList}" var="route">
                                                                    <tr>
                                                                        <td class="align-middle" style="text-align: center">${route.name}</td>
                                                                        <td class="align-middle" style="text-align: center">${route.cotation}</td>
                                                                        <td class="align-middle" style="text-align: center">${route.height}</td>
                                                                        <td class="align-middle" style="text-align: center">${route.description}</td>
                                                                        <c:if test="${(!empty memberInSessionId && sessionScope.memberInSessionId == sector.climbingArea.member.id) || sessionScope.memberInSessionRole == 'Administrator'}">
                                                                            <td class="align-middle" style="text-align: center">
                                                                                <a href="<c:url value="/updateRoute/${r.id}"/> " class="btn btn-outline-primary">
                                                                                    <i class="fas fa-edit ml-2"></i>
                                                                                </a>
                                                                            </td>
                                                                            <td class="align-middle" style="text-align: center">
                                                                                <a href="<c:url value="/deleteRoute/${r.id}"/> " class="btn btn-outline-danger">
                                                                                    <i class="fas fa-trash ml-2"></i>
                                                                                </a>
                                                                            </td>
                                                                        </c:if>
                                                                    </tr>
                                                                </c:forEach>
                                                                </tbody>
                                                            </table>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </section>
                                </c:forEach>
                            </div>
                            <div class="tab-pane fade show" role="tabpanel" id="reviews">
                                <c:if test="${!empty memberInSessionId}">
                                    <p class="my-5">
                                        <a href="<c:url value="/createNewComment/${climbArea.id}"/>" class="btn btn-outline-primary">
                                            <i class="fas fa-plus-square ml-2"> Ajouter un commentaire </i>
                                        </a>
                                    </p>
                                </c:if>
                                <c:if test="${empty memberInSessionId}">
                                    <p class="my-5">
                                        Connectez-vous pour ajouter un commentaire.
                                    </p>
                                </c:if>
                                <c:forEach items="${commentList}" var="comment">
                                    <div class="reviews">
                                        <div class="review-item">
                                            <c:if test="${sessionScope.memberInSessionRole == 'Administrator' || sessionScope.memberInSessionRole == 'Member'}">
                                                <div class="align-items-sm-start">
                                                    <a href="<c:url value="/updateComment/${comment.id}"/> " class="btn btn-sm btn-outline-primary">
                                                        <i class="fas fa-edit ml-2"></i>
                                                    </a>
                                                    <a href="<c:url value="/deleteComment/${comment.id}"/> " class="btn btn-sm btn-outline-danger">
                                                        <i class="fas fa-trash ml-2"></i>
                                                    </a>
                                                </div>
                                            </c:if>
                                            <h4>${comment.member.pseudo}</h4><span class="text-muted"><a href="#">${comment.member.pseudo}</a>, <fmt:formatDate value="${comment.creationDate}" pattern="dd/MM/yyyy HH:mm:ss"/> </span>
                                            <p>${comment.description}</p>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>



<%@include file="_include/footer.jsp"%>
