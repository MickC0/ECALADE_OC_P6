<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page updateMemberForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Mise à jour du profil</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form method="post" action="updateMemberProcess/${memberEdit.id}" modelAttribute="memberEdit">
                <div class="form-group">
                    <form:hidden path="id" value="${memberEdit.id}"/>
                    <form:errors path="id" cssClass="errors"/>
                </div>
                <c:choose>
                    <c:when test="${sessionScope.memberInSessionRole == 'Administrator'}">
                        <div class="form-group">
                            <form:label path="enabled" cssClass="form-check-label">Compte actif : </form:label>
                            <form:checkbox path="enabled" cssClass="form-check-inline" value="${memberEdit.enabled}"/>
                            <form:errors path="enabled" cssClass="errors"/>
                        </div>
                        <div class="form-group">
                            <form:label path="role">Role :</form:label>
                            <form:input path="role" cssClass="form-control" value="${memberEdit.role}"/>
                            <form:errors path="role" cssClass="errors"/>
                        </div>
                    </c:when>
                    <c:otherwise>
                        <div class="form-group">
                            <form:hidden path="enabled" value="${memberEdit.enabled}"/>
                            <form:errors path="enabled" cssClass="errors"/>
                        </div>
                    </c:otherwise>
                </c:choose>
                <div class="form-group">
                    <form:select path="gender" type="text" value="${memberEdit.gender}" cssClass="form-control" required="true" autofocus="">
                        <form:option value="" label="Civilité"/>
                        <form:option value="M" label="Monsieur"/>
                        <form:option value="F" label="Madame"/>
                    </form:select>
                </div>
                <div class="form-group">
                    <form:input path="firstName" type="text" value="${memberEdit.firstName}" cssClass="form-control item" placeholder="Prénom" required="true" autofocus=""/>
                    <form:errors  path="firstName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="lastName" type="text" value="${memberEdit.lastName}" cssClass="form-control item" placeholder="Nom" required="true" autofocus=""/>
                    <form:errors  path="lastName" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="pseudo" type="text" value="${memberEdit.pseudo}" cssClass="form-control item" placeholder="Pseudo" required="true" autofocus=""/>
                    <form:errors  path="pseudo" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:input path="email" type="email" value="${memberEdit.email}" cssClass="form-control item" placeholder="Adresse mail" required="true" autofocus=""/>
                    <form:errors  path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:password path="password" cssClass="form-control item" placeholder="Mot de passe" required="true"/>
                    <form:errors  path="password" cssClass="error"/>
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
