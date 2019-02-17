<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Send message to faculty</title>
<style>
div{color:white}
</style>
</head>
<body>
<center>
<div style="height=80em;background-color:#424242;">
!--This Message will be sent to your Faculty---!
<br>
<form method="post" action="MessageToFaculty">
Enter Subject Of your Message:<br>
<input type="text" required="required"  name="m1"><br>
Enter your Message here:<br>
<textarea rows="10" cols="50" name="m2" required="required" style='resize:none;'></textarea><br>
<input type="submit" value="Send Message">
</form>
</div>
</center>
</body>
</html>