<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>${xmlStatus}</h1>
<table border="2px">
    <tr class="firstTableLine">
        <th>uId</th>
        <th>first name</th>
    </tr>
    <c:forEach var="client" items="${clients}">
        <tr class="personItem">
            <td> <c:out value="${client.getClientId()}"/> </td>
            <td> <c:out value="${client.getName()}"/>  </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
