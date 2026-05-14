<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

String name=(String) session.getAttribute("empName");

%>

<% if(name!=null){%>
<a href="Registration-form.html">Add Employee</a>
<a href="display">View Employee</a>
<a href="logout">Logout</a>

<%} else{%>
<h1>Without login you can't access any page</h1>

<a href="login.html">Login here</a>
<%}%>


</body>
</html>