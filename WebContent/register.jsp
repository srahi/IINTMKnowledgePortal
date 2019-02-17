<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
input[type=submit]
{
width:9em;
height:5em;
}
.button{
    background-color: white;
    color: black;
    border: 2px solid #4CAF50;
}
.button:hover {
    background-color: #4CAF50;
    color: white;
}

</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:#424242;;text-color:#69F0AE;height:100%">
<center>
<form action="registerID.jsp">
<input class="button" type="submit" value="RegisterID">
</form>
<br>
<form action="SearchloginID.jsp">
<input class="button" type="submit" value="AlterID">
</form>
<br>
<form action="deleteID.jsp">
<input class="button" type="submit" value="DeleteID">
</form>
<br>
<form action="editCourse.jsp">
<input class="button" type="submit" value="AlterCourseDetails" style="width:10em">
</form>
<br>
<form action="editPersonal.jsp">
<input class="button" type="submit" value="AlterPersonalDetails" style="width:10em">
</form>
</center>
</div>
</body>
</html>