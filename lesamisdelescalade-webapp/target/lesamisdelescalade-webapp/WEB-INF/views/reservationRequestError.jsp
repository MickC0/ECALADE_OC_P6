<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page reservationRequestError-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Erreur de réservation</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form>
                <c:if test="${reservationInBddStatus == 'Acceptée'}">
                    <p>
                        Vous avez déjà fait une demande de réservation pour ce topo.
                        Celle-ci a été acceptée par le propriétaire.
                        Celui-ci prendra rapidement contact avec vous par mail.
                    </p>
                    <p>Pensez à consulter votre boîte mail régulièrement.</p>
                </c:if>
                <c:if test="${reservationInBddStatus == 'En attente'}">
                    <p>
                        Vous avez déjà fait une demande de réservation pour ce topo.
                        Celle-ci n'a pas encore été traitée par le propriétaire.
                    </p>
                    <p>Vous pouvez consulter le statut de votre demande dans votre espace personnel.</p>
                </c:if>
                <div class="form-group">
                    <a href="<c:url value="/personalSpace/${memberInSessionId}"/>">
                        <button type="button" class="btn btn-primary btn-block">Dashboard</button>
                    </a>
                </div>
                <div class="form-group">
                    <a href="<c:out value="javascript:history.go(-1)"/>" class="btn btn-outline-primary btn-block">
                        Retour
                    </a>
                </div>
            </form>

        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
