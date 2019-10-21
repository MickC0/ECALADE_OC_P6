<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Edit object</h1>
<form:form method="post" action="/editsave">
    <table >
        <!--climbingArea-->

			<tr>
				<td>Id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>Region : </td>
				<td><form:input path="region"  /></td>
			</tr>
			<tr>
				<td>description : </td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>profil : </td>
				<td><form:input path="profil"  /></td>
			</tr>
			<tr>
				<td>rockType : </td>
				<td><form:input path="rockType"  /></td>
			</tr>
			<tr>
				<td>holdType : </td>
				<td><form:input path="holdType"  /></td>
			</tr>
			<tr>
				<td>maximumHeight : </td>
				<td><form:input path="maximumHeight"  /></td>
			</tr>
			<tr>
				<td>Approuved : </td>
				<td><form:checkbox path="approuved"  /></td>
			</tr>



        <!--comment-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>description : </td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>creationDate : </td>
				<td><form:input path="creationDate"  /></td>
			</tr>
			<tr>
				<td>updateDate : </td>
				<td><form:input path="updateDate"  /></td>
			</tr>
			<tr>
				<td>member_id : </td>
				<td><form:input path="member_id"  /></td>
			</tr>
			<tr>
				<td>climbingArea_id : </td>
				<td><form:input path="climbingArea_id"  /></td>
			</tr>
			--%>

        <!--guidebook-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>description : </td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>addedDate : </td>
				<td><form:input path="addedDate"  /></td>
			</tr>
			<tr>
				<td>isLoaned : </td>
				<td><form:input path="isLoaned"  /></td>
			</tr>
			<tr>
				<td>member_id : </td>
				<td><form:input path="member_id"  /></td>
			</tr>
			--%>

        <!--member-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>firstName : </td>
				<td><form:input path="firstName"  /></td>
			</tr>
			<tr>
				<td>lastName : </td>
				<td><form:input path="lastName"  /></td>
			</tr>
			<tr>
				<td>pseudo : </td>
				<td><form:input path="pseudo"  /></td>
			</tr>
			<tr>
				<td>birthdate : </td>
				<td><form:input path="birthdate"  /></td>
			</tr>
			<tr>
				<td>gender : </td>
				<td><form:input path="gender"  /></td>
			</tr>
			<tr>
				<td>email : </td>
				<td><form:input path="email"  /></td>
			</tr>
			<tr>
				<td>password : </td>
				<td><form:input path="password"  /></td>
			</tr>
			<tr>
				<td>isMember : </td>
				<td><form:input path="isMember"  /></td>
			</tr>
			<tr>
				<td>isAdmin : </td>
				<td><form:input path="isAdmin"  /></td>
			</tr>
			--%>

        <!--parking-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>latitude : </td>
				<td><form:input path="latitude"  /></td>
			</tr>
			<tr>
				<td>longitude : </td>
				<td><form:input path="longitude"  /></td>
			</tr>
			<tr>
				<td>climbingArea_id : </td>
				<td><form:input path="climbingArea_id"  /></td>
			</tr>
			--%>

        <!--photo-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>url : </td>
				<td><form:input path="url"  /></td>
			</tr>
			<tr>
				<td>climbingArea_id : </td>
				<td><form:input path="climbingArea_id"  /></td>
			</tr>
			--%>

        <!--reservationRequest-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>guidebook_id : </td>
				<td><form:input path="guidebook_id"  /></td>
			</tr>
			<tr>
				<td>member_id : </td>
				<td><form:input path="member_id"  /></td>
			</tr>
			<tr>
				<td>reservationState : </td>
				<td><form:input path="reservationState"  /></td>
			</tr>
			--%>

        <!--route-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>description : </td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>cotation : </td>
				<td><form:input path="cotation"  /></td>
			</tr>
			<tr>
				<td>height : </td>
				<td><form:input path="height"  /></td>
			</tr>
			<tr>
				<td>pitchNumber : </td>
				<td><form:input path="pitchNumber"  /></td>
			</tr>
			<tr>
				<td>sector_id : </td>
				<td><form:input path="sector_id"  /></td>
			</tr>
			--%>

        <!--sector-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>description : </td>
				<td><form:input path="description"  /></td>
			</tr>
			<tr>
				<td>climbingArea_id : </td>
				<td><form:input path="climbingArea_id"  /></td>
			</tr>
			--%>

        <!--startingPoint-->
        <%--
			<tr>
				<td>id : </td>
				<td><form:input path="id"  /></td>
			</tr>
			<tr>
				<td>Name : </td>
				<td><form:input path="name"  /></td>
			</tr>
			<tr>
				<td>latitude : </td>
				<td><form:input path="latitude"  /></td>
			</tr>
			<tr>
				<td>longitude : </td>
				<td><form:input path="longitude"  /></td>
			</tr>
			<tr>
				<td>climbingArea_id : </td>
				<td><form:input path="climbingArea_id"  /></td>
			</tr>
			--%>

        <tr>
            <td> </td>
            <td><input type="submit" value="Edit Save" /></td>
        </tr>
    </table>
</form:form>
</body>
</html>
