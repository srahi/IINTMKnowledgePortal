<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alter ID</title>
</head>
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
    var a = document.forms["AlterForm"]["t1"].value;
    var b = document.forms["AlterForm"]["t2"].value;
    var c = document.forms["AlterForm"]["t3"].value;
    var d = document.forms["AlterForm"]["t4"].value;
   
    if (a == null || a == "") {
        alert("User Name must be filled out");
        return false;
    }
    if (b == null || b == "") {
        alert("Password must be filled out");
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
<body>
<center>
<form name="AlterForm" action='AlterController' onsubmit="return validateForm()">
		Enter username : <input type='text' name='t1'><br>
		Enter password : <input type='password' name='t2'><br>
		Enter firstname : <input type='text' name='t3'><br>
		Enter lastname : <input type='text' name='t4'><br>
		<input type='submit'>
		</form>
		To update Course Details of student <a href="SearchloginID.jsp">Click here</a>
		</center>
		
</body>
</html>