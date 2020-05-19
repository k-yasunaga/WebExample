<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>追加確認</title>
</head>
<body>
<h1>追加確認</h1>
<p>以下を追加します。良いですか</p>
<p>商品：<c:out value="${shouhin.sname}"/> </p>
<p>単価：${shouhin.tanka} </p>
<form action="insert" method="post">
	<input type="hidden" name="sname" value="${shouhin.sname}"><br>
	<input type="hidden" name="tanka" value="${shouhin.tanka}"><br>
<input type="submit" value="追加">
</form>
</body>
</html>