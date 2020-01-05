<%@ page pageEncoding="UTF-8"%>

<%@include file="_include/head.jsp"%>


<main class="page landing-page">
    <section class="clean-block clean-info dark">
        <div class="container">
            <div class="block-heading">
                <h2 class="text-info">Bienvenue sur le site de l'association</h2>
                <h2 class="text-info">Les Amis de l'Escalade</h2>
                <p>
                    Les Amis de l'Escalade est une association de passionnés.
                </p>
                <p>
                    Notre passion pour la grimpe nous a amené à développer
                    cet outil communautaire, qui permet de dynamiser la circulation de l'information dans le monde de l'escalade :
                </p>
                <p>que ce soit pour des grimpeurs, des équipeurs,</p>
                <p>mais aussi pour des salles d'escalade, etc.</p>
            </div>
            <div class="row align-items-center">
                <div class="col-md-6"><img class="img-thumbnail" src="<c:url value="/resources/img/image6.jpg"/>"/></div>
                <div class="col-md-6">
                    <h3 class="text-info">Consulter les sites de France</h3>
                    <div class="getting-started-info">
                        <p>
                            Il est possible de consulter la liste des sites déjà enregistrer par les membres de l'association ou les utilisateurs inscrits.
                        </p>
                    </div>
                </div>
            </div>
            <div class="row align-items-center">
                <div class="col-md-6">
                    <h3 class="text-info">Consulter la liste des topos</h3>
                    <div class="getting-started-info">
                        <p>
                            Il est possible de consulter la liste des topos mis à disposition par les membres de l'association ou les utilisateurs inscrits.
                        </p>
                    </div>
                </div>
                <div class="col-md-6"><img class="img-thumbnail" src="<c:url value="/resources/img/image1.jpg"/>"/></div>
            </div>
        </div>
    </section>
</main>

<%@include file="_include/footer.jsp"%>
