<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update attendance</title>
</head>
<style>
input[type=text]
{
width:130px;
height:40px;
font-size:20px;
}

</style>

<script>
function validateForm() {
    var a = document.forms["AttendanceForm"]["t1"].value;
    var b = document.forms["AttendanceForm"]["t2"].value;
    var c = document.forms["AttendanceForm"]["t3"].value;

    if (a == null || a == "") {
        alert("User Name must be filled out");
        return false;
    }
    if (b == null || b == "") {
        alert("Semester must be filled out");
        return false;
    }
    if (c == null || c == "") {
        alert("Attendance must be filled out");
        return false;
    }
  
    
}
</script>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />
<body style="overflow:auto;">
<div>
<center>
<form name="AttendanceForm" action="AttendanceAdminController" onsubmit="return validateForm()">
<h3>Upload Attendance</h3>
<table>
<tr><td>Enter User Name :</td><td>
<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select username from login_table where username not like 'admin' and username not like 'faculty'" var="result" />

<select name="un"><c:forEach var="row" items="${result.rows}"><option value="${row.username}">${row.username}</option></c:forEach></select>

<br></td></tr>
<!-- Selection complete -->

<tr><td>Select Semester :</td><td>
<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select semester from semesters" var="result" />

<select name="sem"><c:forEach var="row" items="${result.rows}"><option value="${row.semester}">${row.semester}</option></c:forEach></select>

<br></td></tr>
<!-- Selection complete -->
<tr><td>Enter Attendance :</td><td> <input type="number" step='any' required="required" max="100" min="1" name="a1"><br></td></tr>
</table>
<input type="submit">
</form>
</center>
</div>
</body>
</html>