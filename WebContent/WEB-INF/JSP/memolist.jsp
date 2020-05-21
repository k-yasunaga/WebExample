<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メモ</title>
</head>
<body>
<h1>Memo</h1>
<c:forEach var="memo" items="${list}">
	<ul>
	<li> <a href="memo?mid=${memo.mid}">${memo.title}</a></li>
	</ul>
</c:forEach>
</body>
</html>