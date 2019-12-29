<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page updateClimbingAreaForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Mise à jour d'un site</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form method="post" action="updateClimbingAreaProcess/${climbingAreaToUpdate.id}" modelAttribute="climbingAreaToUpdate">
                <div class="form-group">
                    <form:hidden path="id" value="${climbingAreaToUpdate.id}"/>
                    <form:errors  path="id" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="name" type="text" value="${climbingAreaToUpdate.name}" cssClass="form-control item" placeholder="Nom du site" required="true" autofocus=""/>
                    <form:errors  path="name" cssClass="error"/>
                </div>
                <div class="form-group select-style">
                    <form:select path="region" cssClass="form-control">
                        <form:option value="">Région</form:option>
                        <form:options items="${regionList}"/>
                    </form:select>
                    <form:errors path="region" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="description" type="text" value="${climbingAreaToUpdate.description}" cssClass="form-control item" placeholder="Description du site" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="profil" type="text" value="${climbingAreaToUpdate.profil}" cssClass="form-control item" placeholder="Profil des voies" required="true" autofocus=""/>
                    <form:errors  path="profil" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="rockType" type="text" value="${climbingAreaToUpdate.rockType}" cssClass="form-control item" placeholder="Type de roche" required="true" autofocus=""/>
                    <form:errors  path="rockType" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="maximumHeight" type="number" value="${climbingAreaToUpdate.maximumHeight}" cssClass="form-control item" placeholder="Hauteur maximum" required="true" autofocus=""/>
                    <form:errors  path="maximumHeight" cssClass="error"/>
                </div>
                <div class="form-group">
                    <c:if test="${sessionScope.memberInSessionRole == 'Administrator' || sessionScope.memberInSessionRole == 'Member'}">
                        <form:label path="approuved">Officiel Les Amis de l'Escalade</form:label>
                        <form:checkbox path="approuved" value="${climbingAreaToUpdate.approuved}" cssClass="form-check-inline"/>
                        <form:errors  path="approuved" cssClass="error"/>
                    </c:if>
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

