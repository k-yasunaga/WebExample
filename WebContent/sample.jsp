<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.Date,java.text.SimpleDateFormat" %>
    <%
    String[]luckArray= {"超すっきり","普通","ダメ"};
	int index=(int)(Math.random()*3);
	String luck = luckArray[index];

	Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("MM月dd日");
	String today = sdf.format(date);
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>占い</title>
</head>
<body>
<%=today %>の運勢は<%=luck %>です
</body>
</html>