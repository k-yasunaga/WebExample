<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>削除確認</title>
</head>
<body>
<h1>削除確認</h1>
<p>以下を削除します。良いですか</p>
<p>商品ID：${shouhin.sid} </p>
<p>商品：${shouhin.sname} </p>
<p>単価：${shouhin.tanka} </p>
<form action="del" method="post">
	<input type="hidden" name="sid" value="${shouhin.sid}"><br>
	<input type="hidden" name="sname" value="${shouhin.sname}"><br>
	<input type="hidden" name="tanka" value="${shouhin.tanka}"><br>
<input type="submit" value="削除">
</form>
</body>
</html>