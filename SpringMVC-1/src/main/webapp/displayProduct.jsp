<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.example.demo.model.Product"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body>
<h1>Product details</h1>
<%
Product prd=(Product)request.getAttribute("product");
%>
<li><%=prd.getPrdName() %>
<h3>${product}</h3>
</body>
</body>
</html>