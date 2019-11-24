

<nav class="navbar navbar-expand-md navbar-light bg-light fixed-top">
    <a class="navbar-brand" href="<c:url value="/home"/>">
        <img src="<c:url value="/resources/img/icon1.svg"/>" style="width: 50px; height:auto">
        Les amis de l'escalade
    </a>
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbar" aria-controls="navbar" aria-expanded="false">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbar" >
        <ul class="navbar-nav">
            <li class="nav-item" data-toggle="collapse" data-target=".navbar-collapse.show">
                <a class="nav-link" href="<c:url value="/climbingAreaList"/>">Sites d'escalade</a>
            </li>
            <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                <a class="nav-link" href="#">Topos</a>
            </li>
            <c:if test="${!empty memberInSessionId}">
                <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                    <a class="nav-link" href="#">Mes réservations</a>
                </li>
            </c:if>
        </ul>
        <c:choose>
            <c:when test="${!empty memberInSessionId}">
                <ul class="nav navbar-nav ml-auto">
                    <c:if test="${sessionScope.memberInSessionRole == 'Administrator'}">
                        <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                            <a class="nav-link" href="<c:url value="/"/>"> Administration </a>
                        </li>
                    </c:if>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/personalSpace"/>"> ${sessionScope.memberInSessionPseudo} </a>
                    </li>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doLogout"/>"> Logout</a>
                    </li>
                </ul>
            </c:when>
            <c:otherwise>
                <ul class="nav navbar-nav ml-auto">
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doRegister"/>"><span class="fas fa-user"></span> Sign Up</a>
                    </li>
                    <li class="nav-item"data-toggle="collapse" data-target=".navbar-collapse.show">
                        <a class="nav-link" href="<c:url value="/doLogin"/>"><span class="fas fa-sign-in-alt"></span> Login</a>
                    </li>
                </ul>
            </c:otherwise>
        </c:choose>
    </div>
</nav>
