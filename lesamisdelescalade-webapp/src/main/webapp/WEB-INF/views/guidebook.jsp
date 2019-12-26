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
                                    <a href="/resources/img/image1.jpg">
                                        <img class="img-fluid d-block mx-auto" src="/resources/img/image4.jpg">
                                    </a>
                                    <a href="/resources/img/image5.jpg">
                                        <img class="img-fluid d-block mx-auto" src="/resources/img/image6.jpg">
                                    </a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="info">
                                <h3>Lorem Ipsum</h3>
                                <div class="rating">
                                    <img src="/resources/img/icon1.svg">
                                </div>
                                <div class="summary">
                                    <p>
                                        <c:out value="${guidebook.description}"/>
                                    </p>

                                    <c:if test="${guidebook.loaned == false}">
                                        <td>
                                            <button class="btn btn-outline-info btn-block" type="button">
                                                <a href="<c:url value="/showReservationForm/${guidebook.id}"/>">RESERVER</a>
                                            </button>
                                        </td>
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