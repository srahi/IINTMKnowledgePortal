<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="table.css" type="text/css" rel="stylesheet">
<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />



<!-- Displaying Every Login Details -->
<sql:query dataSource="${conn}"
    sql="select username,password,firstname,lastname from login_table where username like '%00%'" var="result" />
<div id="customers">
<center>Login Data</center>
<table width="100%" border="1">
<tr>
<th>UserName</th>
<th>Password</th>
<th>First Name</th>
<th>Last Name</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td>${row.password}</td>
            <td>${row.firstname}</td>
            <td>${row.lastname}</td>
        </tr>
    </c:forEach>
</table>


<!-- Displaying All Student Personal Details -->
<sql:query dataSource="${conn}"
    sql="select username,dob,gender,email,contactno,address,city,state from student_detail" var="result" />
<div id="customers">
<center>Student Details Uploaded</center>
<table width="100%" border="1">
<tr>
<th>UserName</th>
<th>Date of Birth</th>
<th>Gender</th>
<th>Email</th>
<th>Contact No.</th>
<th>Address</th>
<th>City</th>
<th>State</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td>${row.dob}</td>
            <td>${row.gender}</td>
            <td>${row.email}</td>
            <td>${row.contactno}</td>
            <td>${row.address}</td>
            <td>${row.city}</td>
            <td>${row.state}</td>
        </tr>
    </c:forEach>
</table>




<!-- Displaying All Student Course Details -->
<sql:query dataSource="${conn}"
    sql="select username,course,rank,status,semester,batch,registrationdate,validupto from course_detail" var="result" />
<div id="customers">
<center>Course Details Uploaded</center>
<table width="100%" border="1">
<tr>
<th>UserName</th>
<th>Course</th>
<th>Rank</th>
<th>Status</th>
<th>Semester</th>
<th>Batch</th>
<th>Registration Date</th>
<th>Valid Upto</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td>${row.course}</td>
            <td>${row.rank}</td>
            <td>${row.status}</td>
            <td>${row.semester}</td>
            <td>${row.batch}</td>
            <td>${row.registrationdate}</td>
            <td>${row.validupto}</td>
        </tr>
    </c:forEach>
</table>

