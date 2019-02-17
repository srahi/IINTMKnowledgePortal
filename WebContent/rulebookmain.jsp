<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload Attendance</title>
</head>
<body>
<center>
<form>
<select onchange="location = this.value;"  style="width:150px;height:50px">
<option >Select...</option>
<option value="rulebook.jsp">Upload RuleBook</option>
<option value="deleterulebook.jsp">Delete RuleBook</option>
</select>
</form>
</center>
</body>
</html>