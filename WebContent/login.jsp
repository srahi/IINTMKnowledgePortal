<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>IITMKP-Login</title>
<style>

input[type=submit] {
    padding:5px 15px;
    background:#ccc;
    border:0 none;
    cursor:pointer;
    -webkit-border-radius: 5px;
    border-radius: 5px;
}
</style>
<script>
function validateForm() {
    var x = document.forms["LoginForm"]["t1"].value;
    var y = document.forms["LoginForm"]["t2"].value;
    if ((y == null || y == "")&&(x == null || x == "")) {
        alert("Name and Password must be filled out");
        return false;
    }
    if (x == null || x == "") {
        alert("Name must be filled out");
        return false;
    }
    if (y == null || y == "") {
        alert("Password must be filled out");
        return false;
    }
    
}
</script>
</head>
<body>

<form name="LoginForm" action="login" method="post" onsubmit="return validateForm()">
<center>
<img src="Capture.PNG" width="822" height="323" alt="na" /><br>
<pre>
<h1 style="color:#536DFE">LOGIN </h1>
<div style="width:250px;height:220px;background:#536DFE;box-shadow: 10px 10px 5px #BBDEFB;border-radius:25px;" align="center">
 <img src="User.png" style="height:0.5cm;width:0.5cm"> <b style="color:#E1F5FE">Enter Username :</b>
  <input type="text" name="t1" required="required" placeholder="Enter Username..." ><br>
<img src="lock.png" style="height:0.5cm;width:0.5cm"> <b style="color:#E1F5FE">Enter Password :</b>
  <input type="password" name="t2" required="required" placeholder="Enter Password..."><br>

  <center><input type="submit"></center>
  <br>
  <center><div style="color:red">Forgot Password? Contact Admin to update.</div></center>
</div>
<font color="#536DFE" align="center" style="color:#536DFE">


  <b>INSTITUTE OF INNOVATION IN TECHNOLOGY AND MANAGEMENT</b>
  <b>AFFILIATED TO GGSIP UNIVERSITY</b>
  <b>ISO 9001-2008 CERTIFIED INSTITUTE</b>
  </font>
</pre>
</center>
</form>
</body>
</html>