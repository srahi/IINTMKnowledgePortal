<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<sql:setDataSource var="conn"
    driver="oracle.jdbc.driver.OracleDriver" url="jdbc:oracle:thin:@localhost:1521:xe"
    user="system" password="12345" />

<sql:query dataSource="${conn}"
    sql="select contact_id,filename,filedetails,course,semester from study_table" var="result" />

<table width="100%" border="1">
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td>${row.contact_id}</td>
            <td>${row.filename}</td>
            <td>${row.filedetail}</td>
            <td>${row.course}</td>
            <td>${row.semester}</td>
            <td>
              <a href="download?id=${row.contact_id}">View File</a>
             <%--    <img style="height:100px;width:100px" src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${row.contact_id}" />--%>
            </td>
        </tr>
    </c:forEach>
</table>
