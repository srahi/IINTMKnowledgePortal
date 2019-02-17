<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file="header.jsp" %>
    <%@include file="header2.jsp" %>
     <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Homepage Faculty</title>
  <link href="menudesign.css" rel="stylesheet" type="text/css">
</head>

<body bgcolor="#CCFF90">
	<iframe name="iframe" src="UploadBoard.jsp" align="right" height="640em" width="85%" position="relative"></iframe>
	
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
    <li><a href="UploadBoard.jsp" target="iframe">Home</a></li>
    <li><a href="facultyupdateattendance.jsp" target="iframe">Attendance </a></li>
    <li><a href="facultyupdateresult.jsp" target="iframe">Result </a></li>
    <li><a href="syllabusupload.jsp" target="iframe">Syllabus </a></li>
    <li><a href="timeupload.jsp" target="iframe">Time Table </a></li>
    <li><a href="UploadFile.jsp" target="iframe">Study Material </a></li>
    <li><a href="UploadPrevious.jsp" target="iframe">Upload Previous Year Papers</a></li>
    <li><a href="ShowMessagesToFaculty" target="iframe">Show Messages</a></li></ul>
    </nav>
 </div>
 </div>
 </body>
 </html>
<%@include file="footer.jsp"%>