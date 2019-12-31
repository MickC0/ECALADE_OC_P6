<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page climbingAreaForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Création d'un site</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="climbingArea" method="post" action="saveClimbingAreaProcess">

                <div class="form-group">
                    <form:input path="name" type="text" cssClass="form-control item" placeholder="Nom du site" required="true" autofocus=""/>
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
                    <form:textarea path="description" type="text" cssClass="form-control item" rows="5" placeholder="Description du site" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="profil" type="text" cssClass="form-control item" placeholder="Profil des voies" required="true" autofocus=""/>
                    <form:errors  path="profil" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="rockType" type="text" cssClass="form-control item" placeholder="Type de roche" required="true" autofocus=""/>
                    <form:errors  path="rockType" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="maximumHeight" type="number" cssClass="form-control item" placeholder="Hauteur maximum" required="true" autofocus=""/>
                    <form:errors  path="maximumHeight" cssClass="error"/>
                </div>
                <div class="form-group">
                    <c:if test="${sessionScope.memberInSessionRole == 'Administrator' || sessionScope.memberInSessionRole == 'Member'}">
                        <form:label path="approuved">Officiel Les Amis de l'Escalade</form:label>
                        <form:checkbox path="approuved" cssClass="form-check-inline"/>
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
                </div>
            </form:form>
        </div>
    </section>
</main>



<%@include file="_include/footer.jsp"%>
