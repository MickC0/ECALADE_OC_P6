<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page updateGuidebookForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Mise à jour d'un topo</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="guidebookToUpdate" method="post" action="updatingGuidebookProcess/${guidebookToUpdate.id}">
                <div class="form-group">
                    <form:hidden path="id" value="${guidebookToUpdate.id}"/>
                    <form:errors path="id" cssClass="errors"/>
                </div>
                <div class="form-group">
                    <form:hidden path="member.id" value="${guidebookToUpdate.member.id}"/>
                    <form:errors path="member.id" cssClass="errors"/>
                </div>
                <div class="form-group">
                    <form:hidden path="loaned" value="${guidebookToUpdate.loaned}"/>
                    <form:errors  path="loaned" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:hidden path="addedDate" type="date" value="${guidebookToUpdate.addedDate}"/>
                    <form:errors  path="addedDate" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="name" type="text" value="${guidebookToUpdate.name}" cssClass="form-control item" placeholder="Nom du topo" required="true" autofocus=""/>
                    <form:errors  path="name" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="description" type="text" value="${guidebookToUpdate.description}" cssClass="form-control item" placeholder="Description de la voie" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
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
