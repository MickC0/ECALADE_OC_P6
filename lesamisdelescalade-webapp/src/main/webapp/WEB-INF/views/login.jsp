<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Connexion</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form method="post" action="loginProcess" modelAttribute="loginCommand">
                <div class="form-group">
                    <form:label path="email">Email</form:label>
                    <form:input  path="email" cssClass="form-control" type="email" id="email" required="true"/>
                    <form:errors  path="email" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:label path="password">Mot de passe</form:label>
                    <form:input  path="password" cssClass="form-control" type="password" id="password"
                                 minlenght="8" pattern="^(?=.{8,}$)(?=.*?[a-z])(?=.*?[A-Z])(?=.*?[0-9])(?=.*?\W).*$"
                                 title="Le mot de passe doit contenir au moins 8 caractères avec au moins 1 majuscule, 1 nombre et 1 caractère spécial"
                                 required="true"/>
                    <form:errors  path="password" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:button class="btn btn-primary btn-block" type="submit">Se connecter</form:button>
                </div>
                <div class="text-center">
                    <p>
                        Pas encore de compte ?
                        <a  href="<c:url value="/doRegister"/>">
                            <button class="btn btn-link btn-block" type="button">
                                S'enregistrer
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
    </section>
</main>

<%@include file="_include/footer.jsp"%>
