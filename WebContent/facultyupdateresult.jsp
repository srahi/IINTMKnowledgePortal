<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Uploading Result</title>
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
    var a = document.forms["LoginForm"]["tn"].value;
    var b = document.forms["LoginForm"]["ts"].value;
    var c = document.forms["LoginForm"]["tc"].value;
    var d = document.forms["LoginForm"]["ti"].value;
    var e = document.forms["LoginForm"]["te"].value;
    var f = document.forms["LoginForm"]["tt"].value;
    if ((a == null || a == "")||(b == null || b == "")||(c == null || c == "")||(d == null || d == "")||(e == null || e == "")||(f == null || f == "")) {
        alert("All TextFields must be filled out");
        return false;
    }
}
</script>


 <script>
 function calculate() {
		var myBox1=parseInt(document.getElementById('inter').value);	
		var myBox2=parseInt(document.getElementById('exter').value);
		var result=document.getElementById('result');	
		var myResult=myBox1+myBox2;
		result.value=myResult;
   
		
	}
</script>



<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />
    
    
    
<body>
<center>
<div>
<h2>Upload Result</h2>
<form name="LoginForm" action="ResultFacultyController" method="post" onsubmit="return validateForm()">
<table>
<tr><td>Select User Name :</td><td>

<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select username from login_table where username not like 'admin' and username not like 'faculty'" var="result" />

<select name="tn"><c:forEach var="row" items="${result.rows}"><option value="${row.username}">${row.username}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->
<tr><td>Select Semester :</td><td>
<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select semester from semesters" var="result" />

<select name="ts"><c:forEach var="row" items="${result.rows}"><option value="${row.semester}">${row.semester}</option></c:forEach></select>

<br></td></tr>
<!-- Selection complete -->
<tr><td>Select Course :</td><td>

<!-- selecting courses from database -->
<sql:query dataSource="${conn}"
    sql="select course from courses" var="result" />

<select name="tc"><c:forEach var="row" items="${result.rows}"><option value="${row.course}">${row.course}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->
<tr><td>Enter Internal Marks:</td><td>

<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select internal from internals" var="result" />

<select name="ti" style="width:5em;" id="inter" oninput="calculate()"><c:forEach var="row"  items="${result.rows}"><option value="${row.internal}">${row.internal}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->


<tr><td>Enter External Marks:</td><td>



<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select external from externals" var="result" />

<select style="width:5em;" name="te" id="exter" oninput="calculate()" ><c:forEach var="row" items="${result.rows}"><option value="${row.external}">${row.external}</option></c:forEach></select>

<br></td></tr>

<!-- Selection complete -->

<tr><td>Enter Total Marks:</td><td><input type="text" name="tt" id="result"></td></tr>
</table>
<input type="submit" value="Submit Details">
</form>
</div>
</center>
</body>
</html>