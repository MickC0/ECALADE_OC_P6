<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page personalPage-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Profil</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-header py-3">
                                <a href="<c:url value="/editMember/${memberInSessionId}"/>" class="btn btn-outline-primary btn-block">Modifier le profil</a>
                                <c:if test="${sessionScope.memberInSessionRole == 'Administrator'}">
                                    <a href="<c:url value="/showMemberList"/>" class="btn btn-outline-secondary btn-block">Administration des utilisateurs</a>
                                </c:if>
                            </div>
                            <div class="card-body">
                                <table class="table text-center my-0">
                                    <thead>
                                    <tr>
                                        <th>Prénom</th>
                                        <th>Nom</th>
                                        <th>Pseudo</th>
                                        <th>Email</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr>
                                        <td>${memberInSession.firstName}</td>
                                        <td>${memberInSession.lastName}</td>
                                        <td>${memberInSession.pseudo}</td>
                                        <td>${memberInSession.email}</td>
                                        <td>
                                            <a href="<c:url value="/editMemberMdp/${memberInSession.id}"/>" class="btn btn-outline-secondary btn-sm">Modifier le mot de passe</a>
                                        </td>
                                    </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mes sites</h2>
                    <a href="<c:url value="/showClimbingAreaForm"/>" class="btn btn-outline-primary btn-block">Ajouter un site</a>
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
                                    <p class="card-text" style="height: 50px">${climbingArea.region}</p>
                                </div>
                                <div class="card-footer">
                                    <a href="<c:url value="/climbingArea/${climbingArea.id}"/>" class="btn btn-outline-primary btn-sm">Voir</a>
                                    <a href="<c:url value="/editClimbingArea/${climbingArea.id}"/>" class="btn btn-outline-primary btn-sm"> Modifier </a>
                                    <a href="<c:url value="/deleteClimbingArea/${climbingArea.id}"/>" class="btn btn-outline-primary btn-sm"> Supprimer </a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mes Topos</h2>
                    <a href="<c:url value="/showGuidebookForm"/>" class="btn btn-outline-primary btn-block">Ajouter un Topo</a>
                </div>
                <div class="row">
                    <c:forEach items="${guidebookList}" var="guidebook" >
                        <div class="col-md-6 col-lg-4">
                            <div class="card">
                                <div class="card-body" style="overflow: hidden">
                                    <h4 class="card-title">${guidebook.name}</h4>
                                    <div style="max-height: 200px; word-wrap: break-word; overflow: auto">
                                        <p class="card-text">${guidebook.description}</p>
                                    </div>
                                </div>
                                <div>
                                    <a href="<c:url value="/guidebook/${guidebook.id}"/>" class="btn btn-outline-primary btn-sm">Voir</a>
                                    <a href="<c:url value="/editGuidebook/${guidebook.id}"/>" class="btn btn-outline-primary btn-sm">Modifier</a>
                                    <a href="<c:url value="/deleteGuidebook/${guidebook.id}"/>" class="btn btn-outline-primary btn-sm">Supprimer</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Mes réservations</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-header py-3">
                            </div>
                            <div class="card-body">
                                <table class="table text-justify my-3">
                                <thead>
                                <tr>
                                    <th>Nom du Topo</th>
                                    <th>Status</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${memberReservationRequestList}" var="resa">
                                    <tr>
                                        <td>${resa.guidebook.name}</td>
                                        <td>${resa.status}</td>
                                        <c:if test="${resa.status == 'En attente'}">
                                            <td>
                                                <a href="<c:url value="/cancelReservationRequest/${resa.id}"/>" class="btn btn-outline-danger btn-sm">ANNULER</a>
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
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Demandes de réservations</h2>
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
                                        <th>Nom du Topo</th>
                                        <th>Pseudo client</th>
                                        <th>Email</th>
                                        <th>Status</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${guideReservationRequestList}" var="request">
                                        <tr>
                                            <td>${request.guidebook.name}</td>
                                            <td>${request.member.pseudo}</td>
                                            <td>${request.member.email}</td>
                                            <td>${request.status}</td>
                                            <c:if test="${request.status == 'En attente'}">
                                                <td>
                                                    <a href="<c:url value="/acceptReservationRequest/${request.id}"/>" class="btn btn-outline-success btn-sm">ACCEPTER</a>
                                                </td>
                                                <td>
                                                    <a href="<c:url value="/refuseReservationRequest/${request.id}"/>" class="btn btn-outline-danger btn-sm">REFUSER</a>
                                                </td>
                                            </c:if>
                                            <c:if test="${request.status == 'Acceptée'}">
                                                <td>
                                                    <a href="<c:url value="/closeReservationRequest/${request.id}"/>" class="btn btn-outline-info btn-sm">RETOUR</a>
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
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
