<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
    <%@ page import="java.util.*" %>
    <%@ page import="accountStatement.Transaction" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Statement</title>
</head>

<%
User u=(User)session.getAttribute("customer");
ArrayList<Transaction> list=(ArrayList<Transaction>)session.getAttribute("transactions");
%>

<body>

<div align='center'>
<h1>My Accounts</h1>
</div>

<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<div align='center'>
<table border=1>
<tr>
<td><b>Account Number</b></td>
<td><b>Date</b></td>
<td><b>Description</b></td>
<td><b>Credit/Debit Amount</b></td>
<td><b>Closing Balance</b></td>
</tr>

<% for(Transaction t:list){%>
<tr>
<td><%out.println(t.getAcc_number()); %></td>
<td><%out.println(t.getTransaction_date()); %></td>
<td><%out.println(t.getDescription()); %></td>
<td><%out.println(t.getAmount()); %></td>
<td><%out.println(t.getBalance()); %></td>
</tr>
<%} %>

</table>
<input type='button' value='Back' onclick="location.href='Accounts.jsp';">
</div>

</body>
</html>