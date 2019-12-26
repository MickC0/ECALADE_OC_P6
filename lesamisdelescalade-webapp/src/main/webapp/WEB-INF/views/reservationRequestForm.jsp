<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page reservationRequestForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Demande de réservation</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="reservationRequest" method="post" action="saveReservationProcess/${guidebookId}">
                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:input path="member.email" type="text" cssClass="form-control item" required="true" autofocus=""/>
                    <form:errors  path="member.email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="description" type="text" cssClass="form-control item" placeholder="Description de la voie" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
                </div>
                <div class="form-group select-style">
                    <form:select path="cotation" cssClass="form-control">
                        <form:option value="">Cotation de la voie</form:option>
                        <form:options items="${listCotation}"/>
                    </form:select>
                    <form:errors path="cotation" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="height" type="number" cssClass="form-control item" placeholder="Hauteur de la voie" required="true" autofocus=""/>
                    <form:errors  path="height" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:button class="btn btn-primary btn-block" type="submit">Enregistrer</form:button>
                </div>
                <div class="form-group">
                    <a href="<c:out value="javascript:history.go(-1)"/>">
                        <button type="button" class="btn btn-outline-primary btn-block">Annuler</button>
                    </a>
                        <%--<a href="<c:out value="/user/user-area"/>">
                            <button type="button" class="btn btn-primary btn-block">Annuler</button>
                        </a>--%>

                        <%--<a class="btn btn-link btn-block" href="<c:url value="/doLogin"/>" role="button">Annuler</a>--%>
                </div>
            </form:form>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
