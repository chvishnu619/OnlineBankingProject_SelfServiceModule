<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="loginPage.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
</head>
<%
User u=(User)session.getAttribute("customer");
%>

<body>
<div align='center'>
<h1>My Profile Details</h1>
</div>
<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>
<div align='center'>
<form action='MyProfileSubmit' method='post'>
<table>
<tr>
<td>Name:</td><td> <% out.println(u.getName()); %></td>
</tr>

<tr>
<td>User Name:</td><td> <% out.println(u.getUsername()); %> </td>
</tr>

<tr>
<td>DOB:</td><td> <% out.println(u.getDob()); %></td>
</tr>

<tr>
<td>Phone No:</td><td> <% out.println(u.getPhoneno()); %></td>
</tr>

<tr>
<td><span style='color:red'>*</span>Address:</td>
<td><input type='text' name='addressupdate' value='<% out.println(u.getAddress()); %>' required></td>
</tr>

<tr>
<td><span style='color:red'>*</span>City:</td>
<td><input type='text' name='cityupdate' value='<% out.println(u.getCity()); %>' required></td>
</tr>

<tr>
<td><span style='color:red'>*</span>Pin Code:</td>
<td><input type='text' name='pincodeupdate' value='<% out.println(u.getPincode()); %>' required></td>
</tr>

<tr>
<td><span style='color:red'>*</span>Country:</td>
<td><input type='text' name='countryupdate' value='<% out.println(u.getCountry()); %>' required></td>
</tr>

<tr>
<td>Pan No:</td>
<td><% out.println(u.getPanno()); %></td>
</tr>

<tr>
<td>E-Mail</td>
<td><input type='text' name='emailupdate' value='<% out.println(u.getEmail()); %>' required></td>
</tr>

<tr>
<td><input type='submit' value='Submit'></td>
<td><input type="button" onclick="location.href='CustomerService.jsp';" value="Back" /></td>
</tr>

</table>
</form>
</div>
</body>
</html>