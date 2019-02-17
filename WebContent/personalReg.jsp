<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    var a = document.forms["CourseForm"]["t1"].value;
    var b = document.forms["CourseForm"]["t2"].value;
    var c = document.forms["CourseForm"]["t3"].value;
    var d = document.forms["CourseForm"]["t4"].value;
    var e = document.forms["CourseForm"]["t5"].value;
    var f = document.forms["CourseForm"]["t6"].value;
    var g = document.forms["CourseForm"]["t7"].value;
    var h = document.forms["CourseForm"]["t8"].value;
   
    if (a == null || a == "") {
        alert("User Name must be filled out");
        return false;
    }
    if (b == null || b == "") {
        alert("Date of Birth must be filled out");
        return false;
    }
    if (c == null || c == "") {
        alert("Gender must be filled out");
        return false;
    }
    if (d == null || d == "") {
        alert("Email must be filled out");
        return false;
    }
    if (e == null || e == "") {
        alert("Contact No must be filled out");
        return false;
    }
    if (f == null || f == "") {
        alert("Address must be filled out");
        return false;
    }
    if (g == null || g == "") {
        alert("City must be filled out");
        return false;
    }
    if (h == null || h == "") {
        alert("State Upto must be filled out");
        return false;
    }
}
</script>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />
    
<body>
<center>
<fieldset>
<legend>Personal Detail</legend>
<form name="CourseForm" action="PersonalController" onsubmit="return validateForm()">
<table>
<tr><td>Select User Name :</td><td>

<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select username from login_table where username not like 'admin' and username not like 'faculty'" var="result" />

<select name="t1"><c:forEach var="row" items="${result.rows}"><option value="${row.username}">${row.username}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->

<tr><td>Enter Date Of Birth :</td><td><input type="date" required='required' name="t2"><br></td></tr>
<tr><td>Enter Gender :</td><td><input type="text" name="t3" required='required' ><br></td></tr>
<tr><td>Enter Email :</td><td><input type="email" name="t4" required='required' ><br></td></tr>
<tr><td>Enter Contact No :</td><td><input type="number" maxlength="10" name="t5" required='required' ><br></td></tr>
<tr><td>Enter Address :</td><td><input type="text" name="t6" required='required' ><br></td></tr>
<tr><td>Enter City :</td><td><input type="text" name="t7" required='required' ><br></td></tr>
<tr><td>Enter State :</td><td><input type="text" name="t8" required='required' ><br></td></tr>
</table>
<input type="submit">
</form>
<a href="register.jsp">Go Back</a>
</fieldset>
</center>
</body>
</html>