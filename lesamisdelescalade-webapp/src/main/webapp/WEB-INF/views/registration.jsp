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
                        <form:password path="password" cssClass="form-control item" placeholder="Mot de passe" required="true"/>
                        <form:errors  path="password" cssClass="error"/>
                    </div>
                    <div class="form-group">
                        <form:button type="submit" class="btn btn-primary btn-block">S'enregistrer</form:button>
                    </div>
                    <div class="text-center">
                        <p>Déjà enregistré ?<a class="btn btn-link btn-block" href="<c:url value="/doLogin"/>" role="button">Se connecter</a></p>
                    </div>

                </form:form>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>