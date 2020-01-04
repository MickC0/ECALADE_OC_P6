<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page guidebook-page">
    <section class="clean-block clean-product dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">${guidebook.name.toUpperCase()}</h2>
            </div>
            <div class="block-content">
                <div class="product-info">
                    <div class="row">
                        <div class="col-md-6">
                            <div class="gallery">
                                <div class="sp-wrap">

                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="info">
                                <h3>${guidebook.name.toUpperCase()}</h3>
                                <div class="summary">
                                    <table class="table table-striped table-responsive-sm">
                                        <tr>
                                            <th>Région : </th>
                                            <td>${guidebook.region}</td>
                                        </tr>
                                        <tr>
                                            <th>Date de parution : </th>
                                            <td>${guidebook.addedDate}</td>
                                        </tr>
                                    </table>
                                </div>
                                <div class="summary">
                                    <p>
                                        <c:out value="${guidebook.description}"/>
                                    </p>
                                    <c:if test="${!empty memberInSessionId}">
                                        <c:if test="${guidebook.loaned == false}">
                                            <div>
                                                <a href="<c:url value="/showReservationForm/${guidebook.id}"/>" class="btn btn-outline-info btn-block">
                                                    RESERVER
                                                </a>
                                            </div>
                                        </c:if>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>