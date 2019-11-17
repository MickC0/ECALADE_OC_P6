<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <%@include file="_include/head.jsp"%>
    <title>ADMINISTRATION DASHBOARD</title>
</head>
<body>
    <%@include file="_include/navbar.jsp"%>

    <table border="1" width="80%" align="center">

        <tr>
            <td height="350px" valign="top">
                <%-- Page Content Area--%>
                <h1>Admin Dashboard</h1>
                TODO : Admin Options in this page
            </td>
        </tr>

    </table>
    <%@include file="_include/footer.jsp"%>
</body>
</html>
