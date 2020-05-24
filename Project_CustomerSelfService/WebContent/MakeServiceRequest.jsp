<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Make a Service Request</title>
</head>

<%
User u=(User) session.getAttribute("customer");
%>

<body>

<div align='center'>
<h1>Customer Service Menu</h1>
</div>

<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<div align="left">
<h3><a href='ChequeBook.jsp'>Request a new Cheque Book</a></h3><br>
<h3><a href='Card.jsp'>Report Lost/Stolen Card</a></h3><br>
<h3><a href='Query.jsp'>Post a Query</a></h3><br>
<input type="button" onclick="location.href='CustomerService.jsp';" value="Back" />
</div>

</body>
</html>