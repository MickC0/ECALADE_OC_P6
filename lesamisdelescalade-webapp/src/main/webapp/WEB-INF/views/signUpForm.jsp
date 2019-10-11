<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Sign Up</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <!-- jQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <!-- Javascript de Bootstrap -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="col-md-offset-2 col-md-7">
        <h2 class="text-center">Test -
            Sign up Form</h2>
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="panel-title">New Member<br></div>
            </div>
            <div class="panel-body">
                <form:form action="signUpTry" cssClass="form-horizontal"
                           method="post" modelAttribute="member">
                    <form:hidden path="id"/>

                    <div class="form-group">
                        </label>
                        <div class="col-md-9">
                            <form:radiobutton path="gender" value="M" label="Male"/>
                            <form:radiobutton path="gender" value="F" label="Female"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="firstName" class="col-md-3 control-label">First
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="firstName" cssClass="form-control" />
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="lastName" class="col-md-3 control-label">Last
                            Name</label>
                        <div class="col-md-9">
                            <form:input path="lastName" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="pseudo" class="col-md-3 control-label">Pseudo
                        </label>
                        <div class="col-md-9">
                            <form:input path="pseudo" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="birthDate" class="col-md-3 control-label">Birthdate</label>
                        <div class="col-md-9">
                            <form:input type="date" path="birthDate" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="col-md-3 control-label">Email</label>
                        <div class="col-md-9">
                            <form:input path="email" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="col-md-3 control-label">Password</label>
                        <div class="col-md-9">
                            <form:password path="password" cssClass="form-control" />
                        </div>
                    </div>

                    <div class="form-group">
                        </label>
                        <div class="col-md-9">
                            <form:radiobutton path="admin" value="true" label="Oui"/>
                            <form:radiobutton path="admin" value="false" label="Non"/>
                        </div>
                    </div>

                    <div class="form-group">
                        </label>
                        <div class="col-md-9">
                            <form:radiobutton path="member" value="true" label="Oui"/>
                            <form:radiobutton path="member" value="false" label="Non"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <!-- Button -->
                        <div class="col-md-offset-3 col-md-9">
                            <form:button cssClass="btn btn-primary">Submit</form:button>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>
</div>

</body>
</html>
