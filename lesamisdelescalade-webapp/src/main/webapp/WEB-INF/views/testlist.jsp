<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Object List</h1>
<table border="2" width="70%" cellpadding="2">
    <tr>

        <!--climbingArea-->

        <th>id</th>
        <th>name</th>
        <th>region</th>
        <th>description</th>
        <th>profil</th>
        <th>rockType</th>
        <th>holdType</th>
        <th>maximumHeight</th>
        <th>isApprouved</th>
        <th>member_id</th>


        <!--comment-->
        <!--
        <th>id</th>
        <th>description</th>
        <th>creationDate</th>
        <th>updateDate</th>
        <th>member_id</th>
        <th>climbingArea_id</th>
        -->

        <!--guidebook-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>addedDate</th>
        <th>isLoaned</th>
        <th>member_id</th>
        -->

        <!--member-->
        <!--
        <th>id</th>
        <th>firstName</th>
        <th>lastName</th>
        <th>pseudo</th>
        <th>birthdate</th>
        <th>gender</th>
        <th>email</th>
        <th>password</th>
        <th>isMember</th>
        <th>isAdmin</th>
        -->

        <!--parking-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>latitude</th>
        <th>longitude</th>
        <th>climbingArea_id</th>
        -->

        <!--photo-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>url</th>
        <th>climbingArea_id</th>
        -->

        <!--reservationRequest-->
        <!--
        <th>id</th>
        <th>guidebook_id</th>
        <th>member_id</th>
        <th>reservationState</th>
        -->

        <!--route-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>cotation</th>
        <th>height</th>
        <th>pitchNumber</th>
        <th>sector_id</th>
        -->

        <!--sector-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>description</th>
        <th>climbingArea_id</th>
        -->

        <!--startingPoint-->
        <!--
        <th>id</th>
        <th>name</th>
        <th>latitude</th>
        <th>longitude</th>
        <th>climbingArea_id</th>
        -->



        <th>Edit</th>
        <th>Delete</th>
    </tr>
    <c:forEach var="emp" items="${list}">
        <tr>
            <!--climbingArea-->

				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.region}</td>
				<td>${emp.description}</td>
				<td>${emp.profil}</td>
				<td>${emp.rockType}</td>
				<td>${emp.holdType}</td>
				<td>${emp.maximumHeight}</td>
				<td>${emp.approuved}</td>
				<td>${emp.member.id}</td>


            <!--comment-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.description}</td>
				<td>${emp.creationDate}</td>
				<td>${emp.updateDate}</td>
				<td>${emp.member_id}</td>
				<td>${emp.climbingArea_id}</td>
				--%>

            <!--guidebook-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.description}</td>
				<td>${emp.addedDate}</td>
				<td>${emp.isLoaned}</td>
				<td>${emp.member_id}</td>
				--%>

            <!--member-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.firstName}</td>
				<td>${emp.lastName}</td>
				<td>${emp.pseudo}</td>
				<td>${emp.birtddate}</td>
				<td>${emp.gender}</td>
				<td>${emp.email}</td>
				<td>${emp.password}</td>
				<td>${emp.isMember}</td>
				<td>${emp.isAdmin}</td>
				--%>

            <!--parking-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.latitude}</td>
				<td>${emp.longitude}</td>
				<td>${emp.climbingArea_id}</td>
				--%>

            <!--photo-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.url}</td>
				<td>${emp.climbingArea_id}</td>
				--%>

            <!--reservationRequest-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.guidebook_id}</td>
				<td>${emp.member_id}</td>
				<td>${emp.reservationState}</td>
				--%>

            <!--route-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.description}</td>
				<td>${emp.cotation}</td>
				<td>${emp.height}</td>
				<td>${emp.pitchNumber}</td>
				<td>${emp.sector_id}</td>
				--%>

            <!--sector-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.description}</td>
				<td>${emp.climbingArea_id}</td>
				--%>

            <!--startingPoint-->
            <%--
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.latitude}</td>
				<td>${emp.longitude}</td>
				<td>${emp.climbingArea_id}</td>
				--%>
            <td><a href="testedit/${emp.id}">Edit</a></td>
            <td><a href="testdelete/${emp.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="testaddform">Add New Object</a>
</body>
</html>
