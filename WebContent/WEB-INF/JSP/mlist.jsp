<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メンバー一覧</title>
<style>
 td,th{
 	border:1px solid gray;
 	padding0.2em 0.5em;
 	}
 table{
 	border-collapse: collapse;
 }
</style>
</head>
<body>

<h1>メンバー一覧</h1>

<form action="mlist" method="post">
	氏名：<input type="text" name="name" value="${member.name}"><br>
	住所：<input type="text" name="adr" value="${member.adr}"><br>

<input type="submit" value="追加">
</form>

<table>
<tr><th><h2>氏名</h2></th><th><h2>住所</h2></th></tr>
<c:forEach var="member" items="${list}">
	<tr>
		<td><a href="mupdate?mid=${member.mid}">${member.name}</a></td>
		<td>${member.adr}</td>

	</tr>
</c:forEach>
</table>

</body>
</html>