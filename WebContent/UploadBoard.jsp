<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="table.css" type="text/css" rel="stylesheet">
<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />

<center>
<h2>Uploaded Data in Database</h2>
</center>





<!-- Displaying Total Attendance Uploaded -->
<sql:query dataSource="${conn}"
    sql="select username,semester,attendance from attendance_detail" var="result" />
<div id="customers">
<center>Attendance Uploaded</center>
<table width="100%" border="1">
<tr>
<th>UserName</th>
<th>Semester</th>
<th>Attendance</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td>${row.semester}</td>
            <td>${row.attendance}</td>
        </tr>
    </c:forEach>
</table>




<!-- Displaying All The Result Uploaded -->

<sql:query dataSource="${conn}"
    sql="select username,semester,course,internal,external,total from result_table" var="result" />

<center>Result Uploaded</center>
<table width="100%" border="1">
<tr>
<th>UserName</th>
<th>Semester</th>
<th>Course</th>
<th>Internal</th>
<th>External</th>
<th>Total</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.username}</td>
            <td>${row.semester}</td>
            <td>${row.course}</td>
             <td>${row.internal}</td>
            <td>${row.external}</td>
             <td>${row.total}</td>
        </tr>
    </c:forEach>
</table>




<!-- Displaying All Syllabus Uploaded -->

<sql:query dataSource="${conn}"
    sql="select contact_id,course,semester,detail,photo from syllabus_detail" var="result" />

<center>Syllabus Uploaded</center>
<table width="100%" border="1">
<tr>

<th>Course</th>
<th>Semester</th>

<th>Detail</th>
<th>Data</th>
</tr>
<% %>
    <c:forEach var="row" items="${result.rows}">
        <tr>
          
            <td>${row.course}</td>
            <td>${row.semester}</td>
            <td>${row.detail}</td>
             <td>  <a href="ShowSyllabusAdmin?id=${row.contact_id}">View File</a></td>
            
        </tr>
    </c:forEach>
</table>



<!-- Displaying all Time Table Uploaded -->
<sql:query dataSource="${conn}"
    sql="select contact_id,course,semester,photo,detail from time_table" var="result" />

<center>TimeTable Uploaded</center>
<table width="100%" border="1">
<tr>

<th>Course</th>
<th>Semester</th>

<th>Detail</th>
<th>Data</th>
</tr>
<% %>
    <c:forEach var="row" items="${result.rows}">
        <tr>
           
            <td>${row.course}</td>
            <td>${row.semester}</td>
             <td>${row.detail}</td>
             <td>  <a href="timetableadmin?id=${row.contact_id}">View File</a></td>
           
        </tr>
    </c:forEach>
</table>




<!-- Displaying all Study Material Uploaded -->
<sql:query dataSource="${conn}"
    sql="select contact_id,course,semester,filename,filedetails,photo from study_table" var="result" />

<center>StudyMaterial Uploaded</center>
<table width="100%" border="1">
<tr>

<th>Course</th>
<th>Semester</th>
<th>FileName</th>
<th>FileDetails</th>
<th>Data</th>
</tr>
<% %>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            
            <td>${row.course}</td>
            <td>${row.semester}</td>
            <td>${row.filename}</td>
            <td>${row.filedetails}</td>
           
             <td>  <a href="downloadadmin?id=${row.contact_id}">View File</a></td>
        </tr>
    </c:forEach>
</table>


<!-- Displaying all Previous Year Uploaded -->
<sql:query dataSource="${conn}"
    sql="select contact_id,course,semester,filename,filedetails,photo from previous_table" var="result" />

<center>Previous Year Papers Uploaded</center>
<table width="100%" border="1">
<tr>

<th>Course</th>
<th>Semester</th>
<th>Year</th>
<th>FileDetails</th>
<th>Data</th>
</tr>
<% %>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            
            <td>${row.course}</td>
            <td>${row.semester}</td>
            <td>${row.filename}</td>
            <td>${row.filedetails}</td>
           
             <td>  <a href="downloadadmin2?id=${row.contact_id}">View File</a></td>
        </tr>
    </c:forEach>
</table>


<!-- Displaying Rule Book Uploaded -->
<sql:query dataSource="${conn}"
    sql="select contact_id,photo from rule_table" var="result" />

<center>RuleBook Uploaded</center>
<table width="100%" border="1">
<tr>
<th>S.No</th>
<th>Data</th>
</tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.contact_id}</td>
             <td>  <a href="rulebookstudent?id=${row.contact_id}">View File</a></td>
        </tr>
    </c:forEach>
</table>
</div>