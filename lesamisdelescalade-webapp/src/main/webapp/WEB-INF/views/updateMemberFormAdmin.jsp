<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page updateMemberFormAdmin-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">ADMINISTRATEUR : Mise à jour des droits utilisateur</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form method="post" action="updateMemberAdminProcess/${memberToUpdate.id}" modelAttribute="memberToUpdate">
                <div class="form-inline">
                    <form:label path="enabled" cssClass="form-check-label mb-2 mr-sm-2">Compte actif : </form:label>
                    <form:checkbox path="enabled" cssClass="form-check-inline mb-2 mr-sm-2" value="${memberToUpdate.enabled}"/>
                    <form:errors path="enabled" cssClass="errors"/>
                </div>
                <div class="form-inline select-style">
                    <form:select path="role" cssClass="form-control mb-2 mr-sm-2">
                        <form:option value="${memberToUpdate.role}">Role</form:option>
                        <form:options items="${roleList}"/>
                    </form:select>
                    <form:errors path="role" cssClass="error"/>
                </div>
                <div class="form-inline mb-2 mr-sm-2">
                    <form:button class="btn btn-primary btn-block" type="submit">Enregistrer</form:button>
                </div>
                <div class="form-inline mb-2 mr-sm-2">
                    <a href="<c:out value="javascript:history.go(-1)"/>" class="btn btn-outline-primary btn-block">
                        Annuler
                    </a>
                </div>
            </form:form>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
