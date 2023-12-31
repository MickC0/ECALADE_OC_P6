

<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page routeForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Modification de la voie ${routeToUpdate.name}</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="routeToUpdate" method="post" action="updatingRouteProcess/${routeToUpdate.id}">
                <div class="form-group">
                    <form:hidden path="id" value="${routeToUpdate.id}"/>
                    <form:errors path="id" cssClass="errors"/>
                </div>
                <div class="form-group">
                    <form:hidden path="sector.id" value="${routeToUpdate.sector.id}"/>
                    <form:errors path="sector.id" cssClass="errors"/>
                </div>
                <div class="form-group">
                    <form:input path="name" type="text" value="${routeToUpdate.name}" cssClass="form-control item" placeholder="Nom de la voie" required="true" autofocus=""/>
                    <form:errors  path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:textarea path="description" type="text" rows="5" value="${routeToUpdate.description}" cssClass="form-control item" placeholder="Description de la voie" required="true" autofocus=""/>
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
                    <form:input path="height" type="number"  value="${routeToUpdate.height}" cssClass="form-control item" placeholder="Hauteur de la voie" required="true" autofocus=""/>
                    <form:errors  path="height" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:button class="btn btn-primary btn-block" type="submit">Enregistrer</form:button>
                </div>
                <div class="form-group">
                    <a href="<c:out value="javascript:history.go(-1)"/>" class="btn btn-outline-primary btn-block">
                        Annuler
                    </a>
                </div>
            </form:form>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
