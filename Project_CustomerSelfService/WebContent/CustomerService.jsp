<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Service Menu</title>
</head>

<%
User u=(User)session.getAttribute("customer");
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
<h3><a href='MyProfile.jsp'>My Profile</a></h3><br>
<h3><a href='ChangePassword.jsp'>Change Password</a></h3><br>
<h3><a href='Accounts.jsp'>View statement</a></h3><br>
<h3><a href='MakeServiceRequest.jsp'>Make a Service Request</a></h3><br>
<h3><a href='FinalRequestStatus.jsp'>View Request Status</a></h3><br>
</div>

</body>
</html>