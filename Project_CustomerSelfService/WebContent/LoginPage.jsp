<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<div align='center'>
<h1>Welcome to the Customer Self - Service Portal</h1>
<form action='Login' method="post">
<span style='color:red'>*</span>Username<input type="text" name='username' required><br>
<span style='color:red'>*</span>Password<input type="password" name='password' required><br>
<input type='submit' value='Submit'> <input type='reset' value='Clear'>
</form>
</div>
</body>
</html>