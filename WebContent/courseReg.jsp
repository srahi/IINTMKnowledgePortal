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
        alert("Course must be filled out");
        return false;
    }
    if (c == null || c == "") {
        alert("Rank Name must be filled out");
        return false;
    }
    if (d == null || d == "") {
        alert("Status must be filled out");
        return false;
    }
    if (e == null || e == "") {
        alert("Semester must be filled out");
        return false;
    }
    if (f == null || f == "") {
        alert("Batch must be filled out");
        return false;
    }
    if (g == null || g == "") {
        alert("Registration Date must be filled out");
        return false;
    }
    if (h == null || h == "") {
        alert("Registration Upto must be filled out");
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
<legend>Course Detail</legend>
<form name="CourseForm" action="CourseController" onsubmit="return validateForm()">
<table>
<tr><td>Select User Name :</td><td>

<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select username from login_table where username not like 'admin' and username not like 'faculty'" var="result" />

<select name="t1"><c:forEach var="row" items="${result.rows}"><option value="${row.username}">${row.username}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->

<tr><td>Select Course :</td><td>

<!-- selecting courses from database -->
<sql:query dataSource="${conn}"
    sql="select course from courses" var="result" />

<select name="t2"><c:forEach var="row" items="${result.rows}"><option value="${row.course}">${row.course}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->


<tr><td>Enter Rank :</td><td><input type="number" name="t3" min="1" max="20000" required="required"><br></td></tr>
<tr><td>Select Status :</td><td>

<!-- selecting courses from database -->
<sql:query dataSource="${conn}"
    sql="select status1 from status" var="result" />

<select name="t4"><c:forEach var="row" items="${result.rows}"><option value="${row.status1}">${row.status1}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->
<tr><td>Select Semester :</td><td>

<!-- selecting courses from database -->
<sql:query dataSource="${conn}"
    sql="select semester from semesters" var="result" />

<select name="t5"><c:forEach var="row" items="${result.rows}"><option value="${row.semester}">${row.semester}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->
<tr><td>Enter Batch :</td><td><input type="text" name="t6" required="required"><br></td></tr>
<tr><td>Enter RegistrationDate :</td><td><input type="date" name="t7" required="required"><br></td></tr>
<tr><td>Enter RegistrationUpto :</td><td><input type="date" name="t8" required="required"><br></td></tr>
</table>
<input type="submit">
</form>
If you have already completed this phase then <a href="personalReg.jsp">Click here</a>to continue to enter Personal Details..
<a href="register.jsp">Go Back</a>
</fieldset>
</center>
</body>
</html>