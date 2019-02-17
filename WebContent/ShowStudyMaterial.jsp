<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />

<sql:query dataSource="${conn}"
    sql="select contact_id,filename,filedetails,course,semester from study_table" var="result" />
 <link href='table.css' type='text/css' rel='stylesheet'>
<table width="100%" border="1" id="customers">
     <tr>
<th>S.no</th>
<th>File Name</th>
<th>File Details</th>
<th>Course</th>
<th>Semester</th>
<th>Data</th>
</tr>
    <c:forEach var="row" items="${result.rows}">

    <%String course=(String)session.getAttribute("course"); %>
     <%String semester=(String)session.getAttribute("semester"); %>
    <c:if test="${row.course==sessionScope.course}">
       <c:if test="${row.semester==sessionScope.semester}">
        	<tr>
            <td>${row.contact_id}</td>
            <td>${row.filename}</td> 
            <td>${row.filedetails}</td>
            <td>${row.course}</td>
            <td>${row.semester}</td>
            <td>
              <a href="downloadstudent?id=${row.contact_id}">View File</a>
             <%--    <img style="height:100px;width:100px" src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${row.contact_id}" />--%>
            </td>
        </tr>
        </c:if>
        </c:if>
    </c:forEach>
</table>
