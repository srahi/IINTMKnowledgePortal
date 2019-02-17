<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
input[type=submit]
{
width:15em;
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
</head>
<body>
<div style="background-color:#424242;;text-color:#69F0AE;height:100%">
<center>
<form action="SearchByUsername.jsp">
<input class="button" type="submit" value="Search By Username">
</form>
<br>
<form action="SearchBySemester.jsp">
<input class="button" type="submit" value="Search By Semester">
</form>
<br>
<form action="SearchByCourse.jsp">
<input class="button" type="submit" value="Search By Course">
</form>
<br>
<form action="SearchByFile.jsp">
<input class="button" type="submit" value="Search By File Name" >
</form>
<br>
<form action="SearchByTime.jsp">
<input class="button" type="submit" value="Search By Time" >
</form>
<br>
</center>
</div>
</body>
</html>