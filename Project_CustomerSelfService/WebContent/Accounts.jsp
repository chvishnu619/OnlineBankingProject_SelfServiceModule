<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="loginPage.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="accountPage.AccountDAO" %>
<%@page import="accountPage.Account" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Accounts</title>
<style>
.btn-link {
    border: none;
    outline: none;
    background: none;
    cursor: pointer;
    color: #0000EE;
    padding: 0;
    text-decoration: underline;
    font-family: inherit;
    font-size: inherit;
}
</style>

</head>

<%
User u=(User)session.getAttribute("customer");
ArrayList<Account> list=new AccountDAO().getAccounts(u.getUsername());
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
<td><b>Account Type</b></td>
<td><b>Account Balance</b></td>
</tr>
<% for(Account acc:list){%>
<tr>
<td><form action="AccStatement" method="get">
    <button type="submit" name="account" value="<%= acc.getAccount_number() %>" class="btn-link"><%out.println(acc.getAccount_number()); %></button>
</form></td>
<td><%out.println(acc.getType()); %></td>
<td><%out.println(acc.getBalance()); %></td>
</tr>
<%} %>

</table>

<input type='button' value='Back' onclick="location.href='CustomerService.jsp';">

</div>

</body>
</html>