<%--
  Created by IntelliJ IDEA.
  User: shieh
  Date: 2020/7/4
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <table bgcolor="#f0f8ff">
        <tr>
            <td>
                id
            </td>
            <td>
                name
            </td>
            <td>
                age
            </td>
        </tr>
    <c:forEach items="${list}" var="user">
        <tr>
            <td>
                    ${user.id}
            </td>
            <td>
                    ${user.name}
            </td>
            <td>
                    ${user.age}
            </td>
        </tr>
    </c:forEach>
    </table>
</body>
</html>
