<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
    <%@ page import="java.util.*" %>
    <%@ page import="accountPage.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Lost/Stolen card</title>
</head>

<%
User u=(User)session.getAttribute("customer");
ArrayList<Account> list=new AccountDAO().getAccounts(u.getUsername());
%>


<body>
<div align='center'>
<h1>Stolen / Lost Card Request</h1>

<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<form action='SubmitCard' method='post'>
<input type="hidden" name="username" value='<%= u.getUsername()%>'>

<table>

<tr>
<td>Name:</td>
<td><% out.println(u.getName()); %></td>
</tr>

<tr>
<td><span style='color:red'>*</span>Account No:</td>
<td>
<select name='accountnumber' required>
	<%for(Account acc:list) {%>
	<option value='<%= acc.getAccount_number()%>'><% out.println(acc.getAccount_number()); %></option>
	<%} %>
</select>
</td>
</tr>

<tr>
<td><span style='color:red'>*</span>Lost/Stolen On(DD-MMM-YYYY):</td>
<td><input type="text" name='stolendate' required></td>
</tr>

<tr>
<td><input type='submit' value='Submit'></td>
<td>
<input type="button" onclick="location.href='MakeServiceRequest.jsp';" value="Back" />
</td>
</tr>

</table>
</form>
</div>

</body>
</html>