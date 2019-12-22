<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page personalPage-page">
    <section class="clean-block clean-testimonials dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Profil</h2>
            </div>
            <div class="row">
                <div class="col">
                    <div class="card shadow mb-3">
                        <div class="card-header py-3">
                            <button class="btn btn-outline-primary btn-block" type="button">
                                <a href="<c:url value="/editMember/${memberInSessionId}"/>">Modifier le profil</a>
                            </button>
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
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Mes sites</h2>
                <button class="btn btn-outline-primary btn-block" type="button">
                    <a href="<c:url value="/showClimbingAreaForm"/>">Ajouter un site</a>
                </button>
            </div>
            <div class="row">
                <c:forEach items="${climbingAreaList}" var="climbingArea" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image5.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${climbingArea.name}</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div>
                                <button class="btn btn-outline-primary btn-sm btn-" type="button">
                                    <a href="<c:url value="/climbingArea/${climbingArea.id}"/>">Voir</a>
                                </button>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/editClimbingArea/${climbingArea.id}"/>"> Modifier </a>
                                </button>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/deleteClimbingArea/${climbingArea.id}"/>"> Supprimer </a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Mes Topos</h2>
                <button class="btn btn-outline-primary btn-block" type="button">
                    <a href="<c:url value="/showGuidebookForm"/>">Ajouter un Topo</a>
                </button>
            </div>
            <div class="row">
                <c:forEach items="${guidebookList}" var="guidebook" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image4.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${guidebook.name}</h4>
                                <p class="card-text">Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc quam urna, dignissim nec auctor in.</p>
                            </div>
                            <div>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/guidebook/${guidebook.id}"/>">Voir</a>
                                </button>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/editGuidebook/${guidebook.id}"/>">Modifier</a>
                                </button>
                                <button class="btn btn-outline-primary btn-sm" type="button">
                                    <a href="<c:url value="/deleteGuidebook/${guidebook.id}"/>">Supprimer</a>
                                </button>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
    <section class="clean-block clean-testimonials dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Réservations</h2>
            </div>
            <div class="row">
                <div class="col">
                    <div class="card shadow mb-3">
                        <div class="card-header py-3">
                        </div>
                        <div class="card-body">
                            <table class="table text-center my-0">
                                <thead>
                                    <tr>
                                        <th>Nom du Topo</th>
                                        <th>Pseudo client</th>
                                        <th>Email</th>
                                        <th>Message</th>
                                        <th>Status</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${memberReservationRequestList}" var="resa">
                                        <<tr>
                                            <td>${resa.guidebook.name}</td>
                                            <td>${resa.member.pseudo}</td>
                                            <td>${resa.member.email}</td>
                                            <td>msg</td>
                                            <td>${resa.status}</td>
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
</main>

<%@include file="_include/footer.jsp"%>
