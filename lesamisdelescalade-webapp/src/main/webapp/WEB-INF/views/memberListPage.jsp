<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>

<main class="page personalPage-page">
      <section class="clean-block clean-services dark">
        <div class="container">
            <div class="container">
                <div class="block-heading">
                    <h2 class="text-info">Liste des utilisateurs</h2>
                </div>
                <div class="row">
                    <div class="col">
                        <div class="card shadow mb-3">
                            <div class="card-header py-3">
                            </div>
                            <div class="card-body">
                                <table class="table text-justify my-0">
                                    <thead>
                                    <tr>
                                        <th>Status du compte</th>
                                        <th>Nom</th>
                                        <th>Prénom</th>
                                        <th>Pseudo</th>
                                        <th>Email</th>
                                        <th>Role</th>
                                    </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${memberList}" var="member">
                                        <tr>
                                            <c:choose>
                                                <c:when test="${member.enabled == true}">
                                                    <td><p class="bg-success text-white" style="text-align: center">ACTIF</p> </td>
                                                </c:when>
                                                <c:otherwise>
                                                    <td><p class="bg-danger text-white" style="text-align: center">DESACTIVE</p> </td>
                                                </c:otherwise>
                                            </c:choose>
                                            <td>${member.lastName}</td>
                                            <td>${member.firstName}</td>
                                            <td>${member.pseudo}</td>
                                            <td>${member.email}</td>
                                            <td>${member.role}</td>
                                            <td>
                                                <a href="<c:url value="/editMemberAdmin/${member.id}"/>" class="btn btn-outline-secondary btn-sm">
                                                    MODIFIER
                                                </a>
                                            </td>
                                        </tr>
                                    </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
