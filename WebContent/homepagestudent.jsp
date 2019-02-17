<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@include file="header2.jsp" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage</title>
  <link href="menudesign.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#CCFF90">
	<iframe name="iframe" src="StudentDashboard" align="right" height="750em" width="85%" position="relative"></iframe>
	
	<%
	String m=(String)request.getAttribute("image");
	
	if(m.equals("available")){
		%>
		


		<form method="post" action="UploadPicture" enctype="multipart/form-data">
		  <img id="i1" align="center" height="180" width="180" alt="noimage" title="profile image" src="${pageContext.servletContext.contextPath }/PhotoServlet?id=${sessionScope.uname}" />
 <br><input style="margin-left:35px;width:85px;border-radius:25px" type="file" placeholder="UploadImage" accept="image/*" name="photo"><br><input style="margin-left:35px;width:85px;border-radius:25px" type="submit">
			</form>
		<%
	}
	else {
		%>
		        <form method="post" action="UploadPicture" enctype="multipart/form-data">
<img  id="i1" src="icon.png" align="center" height="180" width="180" alt="noimage" title="profile image" >
<br><input style="margin-left:35px;width:85px;border-radius:25px" type="file" placeholder="UploadImage" accept="image/*" name="photo"><br><input style="margin-left:35px;width:85px;border-radius:25px" type="submit">
</form>
		
		<%
	}
%>

 <div style="position:relative">
    <div style="width:11em;display:inline-block;height:20%;position:absolute;">
    <nav>
    <ul class="tab">
    <li><a href="StudentDashboard" target="iframe">Dashboard</a></li>
    <li><a href="ShowAttendanceStudent" target="iframe">Attendance </a></li>
    <li><a href="ShowResultStudent" target="iframe">Result </a></li>
    <li><a href="ShowSyllabusStudent.jsp" target="iframe">Syllabus </a></li>
    <li><a href="ShowTimeTableStudent.jsp" target="iframe">Time Table </a></li>
    <li><a href="ShowStudyMaterial.jsp" target="iframe">Study Material </a></li>
    <li><a href="ShowPreviousYear.jsp" target="iframe">Previous Year Papers</a></li>
    <li><a href="ShowRuleBookStudent.jsp" target="iframe">Rule Book </a></li>
    <li><a href="SendMessageStudent.jsp" target="iframe">Contact Faculty </a></li>
    <li><a href="ShowStudentMessage" target="iframe">Show Sent Messages </a></li></ul>
    </nav>
     
  </div>
    </div>
    
    <%@include file="footer.jsp" %>
  </body>
  </html>

