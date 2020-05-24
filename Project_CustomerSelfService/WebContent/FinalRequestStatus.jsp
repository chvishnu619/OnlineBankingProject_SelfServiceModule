<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="loginPage.User" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.text.SimpleDateFormat" %>
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
User u=(User)session.getAttribute("customer");
%>

<body>
<div align='center'>
<h1>View Request Status</h1>
</div>
<div align='right'>
<h3 style='color: red'>Welcome <% out.println(u.getName()); %> !</h3>
<h3 style='color: red'><a href='LoginPage.jsp'>Signout</a></h3>
</div>

<p>Name:<% out.println(u.getName()); %></p>
Request Type:
<form action='ViewRequests' method='post'>
<input type="hidden" name="username" value='<%= u.getUsername()%>'>

<select name='type'>
	<option value='0'> </option>
	<option value='1'>Cheque Book Request</option>
	<option value='3'>Report a Lost/Stolen Card</option>
	<option value='7'>Query Request</option>
</select>
<input type='submit' value='Submit'>
</form>

<br><br>
<%
ArrayList<CSR> list=new ArrayList<CSR>();
try
{
	list=(ArrayList<CSR>)session.getAttribute("requests");
	if(list==null)
	{
		list=(new CSRDAO().getRequests(0, u.getUsername()));
	}
}
catch(Exception e)
{
	list=(new CSRDAO().getRequests(0, u.getUsername()));
}
%>
<div align='center'>
<table border=1>
<tr>
<td><b>Request ID</b></td>
<td><b>Request Date</b></td>
<td><b>Request Type</b></td>
<td><b>Request Detail</b></td>
<td><b>Response</b></td>
<td><b>Status</b></td>
</tr>

<% for(CSR acc:list){%>
<tr>
<td><form action="RequestFetch" method="get">
    <button type="submit" name="r_id" value="<%= acc.getRequest_id() %>" class="btn-link"><%out.println(acc.getRequest_id()); %></button>
</form></td>
<td><%out.println((String)(new SimpleDateFormat("dd-MMM-yyyy").format(acc.getRequest_date())));; %></td>
<td><%out.println(acc.getType()); %></td>
<td><%out.println(acc.getDetail()); %></td>
<td><%out.println(acc.getResponse()); %></td>
<td><%out.println(acc.getStatus()); %></td>
</tr>
<%} %>

</table>

<% 
if((String)session.getAttribute("rview")!=null)
	out.println(session.getAttribute("rview")); 
%>
</div>
<br>
<input type="button" onclick="location.href='CustomerService.jsp';" value="Back" />

</body>
</html>