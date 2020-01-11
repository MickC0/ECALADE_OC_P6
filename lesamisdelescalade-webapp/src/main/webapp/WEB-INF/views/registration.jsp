<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page registration-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Enregistrement</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <div>
                <form:form cssClass="form-group" method="post" action="registrationProcess" modelAttribute="member">
                    <div class="form-group">
                        <form:select path="gender" type="text" cssClass="form-control" placeholder="Civilité" required="true" autofocus="">
                            <form:option value="" label="Civilité"/>
                            <form:option value="M" label="Monsieur"/>
                            <form:option value="F" label="Madame"/>
                        </form:select>
                    </div>
                    <div class="form-group">
                        <form:input path="firstName" type="text" cssClass="form-control item" placeholder="Prénom" required="true" autofocus=""/>
                        <form:errors  path="firstName" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:input path="lastName" type="text" cssClass="form-control item" placeholder="Nom" required="true" autofocus=""/>
                        <form:errors  path="lastName" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:input path="pseudo" type="text" cssClass="form-control item" placeholder="Pseudo" required="true" autofocus=""/>
                        <form:errors  path="pseudo" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:input path="email" type="email" cssClass="form-control item" placeholder="Adresse mail" required="true" autofocus=""/>
                        <form:errors  path="email" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:password path="password" cssClass="form-control item" placeholder="Mot de passe"
                                       minlenght="8" pattern="^(?=.{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?\W).*$"
                                       title="Le mot de passe doit contenir au moins 8 caractères avec au moins 1 majuscule, 1 nombre et 1 caractère spécial" required="true"/>
                        <form:errors  path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:button type="submit" class="btn btn-primary btn-block">S'enregistrer</form:button>
                    </div>
                    <div class="text-center">
                        <p>Déjà enregistré ?
                            <a href="<c:url value="/doLogin"/>">
                                <button class="btn btn-link btn-block">
                                    Se connecter
                                </button>
                            </a>
                        </p>
                    </div>
                    <div class="form-group">
                        <a href="<c:url value="/showHome"/>" class="btn btn-outline-primary btn-block">
                            Annuler
                        </a>
                    </div>
                </form:form>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>