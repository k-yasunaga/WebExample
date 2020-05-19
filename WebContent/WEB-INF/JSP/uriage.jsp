<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上</title>
</head>
<body>
<h1>${shouhin.sname} の売上</h1>

<table>
<tr><th>日</th><td><th>個数</th></tr>
<c:forEach var="uriage" items="${list}">
	<tr>

		<td>${uriage.hi}　</td>
		<td>${uriage.kosu}</td>

	</tr>
</c:forEach>
</table>
<form action="uriage" method="post">
		  <input type="hidden" name="sid"value="${shouhin.sid}">
	個数：<input type="text" name="kosu"value="${uriage.kosu}"><br>
	<input type="submit" value="追加">
</form>

</body>
</html>