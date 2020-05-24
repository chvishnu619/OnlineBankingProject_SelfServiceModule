<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Change Password</title>
</head>

<%
User u=(User)session.getAttribute("customer");
%>

<body>

<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<div align='center'>
<form action='PasswordSubmit' method='post'>
<!-- Create a servlet PasswordSubmit and validate and update this. Include a response called 'updated password' or 'failed' and link to CUstomerService.jsp -->

<table>
<tr>
<td><span style='color:red'>*</span>Old Password: </td>
<td><input type='password' name='oldpassword' id='opass' required></td>
</tr>

<tr>
<td><span style='color:red'>*</span>New Password: </td>
<td><input type='password' name='newpassword' id='npass' required></td>
</tr>

<tr>
<td><span style='color:red'>*</span>Re-Enter New Password:</td>
<td><input type='password' name='reenterpassword' id='rpass' required></td>
</tr>

<tr>
<td><input type='submit' value='Change Password'></td>
<td><input type='button' value='Back' onclick="location.href='CustomerService.jsp';"></td>
</tr> 

<tr>
<td>
 <div align="center"><div id="result" style="display: inline-block; text-align: left;"></div></div>
</td>
</tr>
</table>
</form>
</div>
</body>
</html>