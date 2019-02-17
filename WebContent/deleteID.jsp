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
    var a = document.forms["DeleteForm"]["t1"].value;

    if (a == null || a == "") {
        alert("User Name must be filled out");
        return false;
    }
   
}
</script>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />
    
    
<body>
<center>
<form name="DeleteForm" action='DeleteController' onsubmit="return validateForm()">
<table>
	<tr><td>Select User Name :</td><td>
	
	<!-- selecting -->
	<sql:query dataSource="${conn}"
	    sql="select username from login_table where username not like 'admin'" var="result" />
	
	<select name="t1"><c:forEach var="row" items="${result.rows}"><option value="${row.username}">${row.username}</option></c:forEach></select>
	
	<br></td></tr>
	</table>

<!-- Selection complete -->
		<input type='submit'>
		</form>
</center>
</body>
</html>