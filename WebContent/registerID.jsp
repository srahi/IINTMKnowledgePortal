<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register ID</title>
<style>
input[type=text]
{
width:130px;
height:40px;
font-size:20px;
}
input[type=password]
{
width:130px;
height:40px;
font-size:20px;
}
</style>

<script>
function validateForm() {
    var a = document.forms["RegisterForm"]["t1"].value;
    var b = document.forms["RegisterForm"]["t2"].value;
    var c = document.forms["RegisterForm"]["t3"].value;
    var d = document.forms["RegisterForm"]["t4"].value;
   
    if (a == null || a == "") {
        alert("User Name must be filled out");
        return false;
    }
    if (b == null || b == "") {
        alert("Password must be filled out");
        return false;
    }
    if (b.length<6) {
        alert("Password length should be equal or greater than 6 characters.");
        return false;
    }
    if (b.length>32) {
        alert("Password length should be equal or less than 32 characters");
        return false;
    }
   
    
    
    var letters=/^[A-Za-z]+$/;
    if (!c.match(letters)) {
        alert("Only Alphabetic letters can be entered");
        return false;
    }
    
    if (c == null || c == "") {
        alert("First Name must be filled out");
        return false;
    }
    var letters=/^[A-Za-z]+$/;
    if (!d.match(letters)) {
        alert("Only Alphabetic letters can be entered");
        return false;
    }
    
    if (d == null || d == "") {
        alert("Last Name must be filled out");
        return false;
    }
    
}
</script>
</head>
<body>
<center>
		<form name="RegisterForm" action='RegisterController' onsubmit="return validateForm()">
		<table>
		<tr><td>Enter username :</td><td> <input type='text' name='t1' maxlength="20" required="required"></td></tr>
		<tr><td>Enter password :</td><td> <input type='password' name='t2' required="required"></td></tr>
		<tr><td>Enter firstname :</td><td> <input type='text' name='t3' maxlength="25" required="required"></td></tr>
		<tr><td>Enter lastname :</td><td> <input type='text' name='t4' maxlength="25" required="required"></td></tr>
		</table>
		<input type='submit' value="next">
		</form>
		<a href="register.jsp">Go Back</a><br>
		If you have already completed this phase then <a href="courseReg.jsp">Click here</a>to continue to enter Course Details..
		</center>
		</body>
</html>