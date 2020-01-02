<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page login-page">
    <section class="clean-block clean-form dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-login">Ajout photo</h2>
                <p>
                    <c:if test="${!empty errorMessage}">
                        <c:out value="${errorMessage}"/>
                    </c:if>
                </p>
            </div>
            <form method="post" action="upload" enctype="multipart/form-data">
                <input id="file-id" type="file" name="file" />
                <br/>
                <input type="submit" value="Upload"/>
            </form>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
