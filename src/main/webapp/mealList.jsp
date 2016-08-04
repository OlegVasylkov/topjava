<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Meal list</title>
</head>
<body>
<h2><a href="index.html">Home</a></h2>
<h2>Meal list</h2>
<table style="border: 1px solid; width: 500px; text-align:center">
    <tr>
        <th>Description</th>
        <th>Calories</th>
        <th>Date Time</th>
    </tr>
    <c:forEach items="${mealList}" var="meal">
        <tr style="color: ${meal.exceed ? 'red':'green'};">
            <td><c:out value="${meal.description}"/></td>
            <td><c:out value="${meal.calories}"/></td>
            <td><c:out value="${meal.dateTime.toLocalDate()} ${meal.dateTime.toLocalTime()}"/></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
