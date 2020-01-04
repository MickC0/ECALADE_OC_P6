<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page climbingAreaList-page">
    <section class="clean-block clean-services dark">
        <div class="container">
            <div class="block-heading">
                <a href="http://imgbox.com/MCHglFss" target="_blank">
                    <img src="<c:url value="${photo1.url}"/>" alt="image host"/>
                </a>
                <a href="http://imgbox.com/IDSjRLlk" target="_blank">
                    <img src="https://thumbs2.imgbox.com/57/c4/IDSjRLlk_t.jpg" alt="image host"/>
                </a>
                <a href="http://imgbox.com/ZZwJIcXA" target="_blank">
                    <img src="https://thumbs2.imgbox.com/f3/ca/ZZwJIcXA_t.jpg" alt="image host"/>
                </a>
                <a href="http://imgbox.com/6dnbDc9A" target="_blank">
                    <img src="https://thumbs2.imgbox.com/79/94/6dnbDc9A_t.jpg" alt="image host"/>
                </a>



                <h3 class="text-info"><c:out value="photo 1 : ${photo1.url}"/></h3>
                <img style="width: 200px; height: auto" src="<c:url value="${photo1.url}"/> ">
                <img style="width: 200px; height: auto" src="/img/image6.jpg">
            </div>
            <div class="block-heading">
                <h3 class="text-info"><c:out value="photo 2 : ${photo2.url}"/></h3>
                <img style="width: 200px; height: auto" src="<c:url value="${photo2.url}"/> ">
            </div>
            <div class="row">
                <c:forEach items="${climbingAreaList}" var="climbingArea" >
                    <div class="col-md-6 col-lg-4">
                        <div class="card"><img class="card-img-top w-100 d-block" src="<c:url value="/resources/img/image5.jpg"/>">
                            <div class="card-body">
                                <h4 class="card-title">${climbingArea.name}</h4>
                                <p class="card-text">${climbingArea.region}</p>
                            </div>
                            <div class="card-body">
                                <a href="<c:url value="/climbingArea/${climbingArea.id}"/>" class="btn btn-outline-secondary btn-sm">
                                    Voir
                                </a>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
