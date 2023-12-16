<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page commentForm-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Mise à jour du commentaire</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form:form modelAttribute="commentToUpdate" method="post" action="updatingCommentProcess/${id}">
                <div class="form-group">
                    <form:hidden path="climbingArea.id" value="${commentToUpdate.climbingArea.id}"/>
                    <form:errors  path="climbingArea.id" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:hidden path="member.id" value="${commentToUpdate.member.id}"/>
                    <form:errors  path="member.id" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:hidden path="creationDate" value="${commentToUpdate.creationDate}"/>
                    <form:errors  path="creationDate" cssClass="error"/>
                </div>
                <div class="form-group">
                    <form:textarea path="description" value="${commentToUpdate.description}" type="text" rows="5" cssClass="form-control item" placeholder="Commentaire" required="true" autofocus=""/>
                    <form:errors  path="description" cssClass="error"/>
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
