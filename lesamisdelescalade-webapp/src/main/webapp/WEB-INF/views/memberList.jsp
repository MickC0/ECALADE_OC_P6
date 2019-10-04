<%--
  Created by IntelliJ IDEA.
  User: kyo_i
  Date: 04/10/2019
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<html>
<head>
    <title>Hello :: Spring Application</title>
</head>
<body>
<h1>Member list</h1>
<table border='1'>
    <c:forEach items="${members}" var="member">
        <tr>
            <td>
                <c:out value="${member.firstName}" />
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
