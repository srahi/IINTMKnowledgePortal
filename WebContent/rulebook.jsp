<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<script>
function validateForm() {
    var a = document.forms["LoginForm"]["photo"].value;
  
    if (a == null || a == "")
    		{
        alert("A .pdf File Must be Choosen");
        return false;
    }
 
}
</script>
<center>
<body>
<center>
        <h1>Upload Rule Book To Database</h1>
		<h3>Files to be uploaded should be in .pdf format and size not above 16MB.</h3>
        <form name="LoginForm" method="post" action="RuleBookController" enctype="multipart/form-data" onsubmit="return validateForm()">
            <table border="0">
                
                    <td>Upload RuleBook: </td>
                    <td><input type="file" name="photo" size="50"/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Save" >
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>