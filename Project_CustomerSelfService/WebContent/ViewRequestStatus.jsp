<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="requests.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Request Status</title>
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
//User u=(User)session.getAttribute("customer");
String name="Testing";
%>

<body>
<div align='center'>
<h1>View Request Status</h1>
</div>
<div align='right'>
<h3 style='color: red'>Welcome <% out.println(name); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<p>Name:<% out.println(name); %></p>
Request Type:
<form action='ViewRequests' method='post'>

<select name='type'>
	<option value='0'> </option>
	<option value='1'>Cheque Book Request</option>
	<option value='3'>Report a Lost/Stolen Card</option>
	<option value='7'>Query Request</option>
</select>
<input type='submit' value='Submit'>
</form>

<br><br>

<div align='center'>
<table border=1>
<tr>
<td><b>Request Date</b></td>
<td><b>Request Type</b></td>
<td><b>Request Detail</b></td>
<td><b>Response</b></td>
<td><b>Status</b></td>
</tr>
</table>
</div>
<br>
<input type="button" onclick="location.href='CustomerService.jsp';" value="Back" />

</body>
</html>