

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
                <div class="form-group">
                    <form:input path="region" type="text" cssClass="form-control item" placeholder="Région" required="true" autofocus=""/>
                    <form:errors  path="region" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="description" type="text" cssClass="form-control item" placeholder="Description du site" required="true" autofocus=""/>
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
                    <form:button class="btn btn-primary btn-block" type="submit">Enregistrer</form:button>
                </div>
            </form:form>
        </div>
    </section>
</main>



<%@include file="_include/footer.jsp"%>
