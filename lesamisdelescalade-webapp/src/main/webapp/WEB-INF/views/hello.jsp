<%--
  Created by IntelliJ IDEA.
  User: kyo_i
  Date: 04/10/2019
  Time: 21:09
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
        <h1>Hello - Spring Application</h1>
        <p>Greetings, it is now <c:out value="${now}" default="None" /></p>
    </body>
</html>
