<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />

<sql:query dataSource="${conn}"
    sql="select contact_id from rule_table where contact_id=(select max(contact_id) from rule_table)" var="result" />
<link href='table.css' type='text/css' rel='stylesheet'>
<table width="100%" border="1" id="customers">
    <c:forEach var="row" items="${result.rows}">
    
     <tr>
<th>S.no</th>
<th>Description</th>
<th>Data</th>
</tr>

        	<tr>
            <td>${row.contact_id}</td>
            <td>Rule Book</td>
            <td>
              <a href="rulebookstudent?id=${row.contact_id}">View File</a>
             <%--    <img style="height:100px;width:100px" src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${row.contact_id}" />--%>
            </td>
        </tr>
  
    </c:forEach>
</table>
