<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

<body>
<div style="background:#424242;height:3em;width:100%;display:inline-block;color:white;">
<b>
Welcome : <%=session.getAttribute("user") %>
<select selected="selected" onchange="location = this.value;"><option selected>Your Account...</option><option value="changep.jsp">Change Password</option><option value="logout">Logout</option></select>
<br>
<%= new java.util.Date() %>
</b>
</div>
</body>
</html>