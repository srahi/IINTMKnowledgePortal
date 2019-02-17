<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@include file="header2.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Change Password</title>
</head>
<script>
function validateForm() {
    var a = document.forms["RegisterForm"]["p2"].value;   
    if (a == null || a == "") {
        alert("New Password cannot be empty");
        return false;
    }     
    if (a.length<6) {
        alert("Password must be atleast of 6 characters");
        return false;
    }  
    if (a.length>32) {
        alert("Password must be less than or equal to 32 characters");
        return false;
    }  
}
</script>
<body bgcolor="#CCFF90">
<center>
<fieldset>
<legend>Change Password</legend>
<form name="RegisterForm" action="PassController"  onsubmit="return validateForm()">
<table>
<tr>
<td>Enter Old Password :</td><td><input type="password" name="p1"></td>
</tr><tr>
<td>Enter New Password :</td><td><input type="password" name="p2"></td>
</tr>
<td>Confirm New Password:</td><td><input type="password" name="p3"></td>
</table>
<input type="submit" value="Submit"> 
</form>
<a href="login.jsp">Home</a>
<a href="javascript:history.back()">Go Back</a>
</fieldset>
</center>
</body>
</html>
<div style="position:relative;bottom:0;left:0;">
<%@include file="footer.jsp" %>
</div>