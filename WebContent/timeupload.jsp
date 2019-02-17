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

</style>
<script>
function validateForm() {
    var a = document.forms["LoginForm"]["cs"].value;
    var b = document.forms["LoginForm"]["ss"].value;
    var c = document.forms["LoginForm"]["timedetail"].value;
    var c = document.forms["LoginForm"]["photo"].value;
    if ((a == null || a == "")||(b == null || b == "")||(c == null || c == ""))
    		{
        alert("All TextFields must be filled out and File must be choosen");
        return false;
    }
 
}
</script>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />
    
<body>
<center>
        <h1>Upload Time Table To Database</h1>
		<h3>Files to be uploaded should be in .pdf format and size not above 16MB.</h3>
        <form name="LoginForm" action="timeupload" method="post" enctype="multipart/form-data" onsubmit="return validateForm()">
            <table border="0">
                <tr>
                    <td>Upload Time Table: </td></tr>
					<tr><td>Select Course :</td><td>

<!-- selecting courses from database -->
<sql:query dataSource="${conn}"
    sql="select course from courses" var="result" />

<select name="cs"><c:forEach var="row" items="${result.rows}"><option value="${row.course}">${row.course}</option></c:forEach></select>

<br></td></tr>


<!-- Selection complete -->
					<tr><td>Select Semester :</td><td>
<!-- selecting -->
<sql:query dataSource="${conn}"
    sql="select semester from semesters" var="result" />

<select name="ss"><c:forEach var="row" items="${result.rows}"><option value="${row.semester}">${row.semester}</option></c:forEach></select>

<br></td></tr>
<!-- Selection complete -->
					<tr><td>Enter Detail:</td><td><input type="text" name="timedetail"></td></tr>
                    <tr><td><input type="file" name="photo" size="50"/></td></tr>
				<tr>
                    <td colspan="2">
                        <input type="submit" value="Save">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>