<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Name</title>
</head>
<body>
<form action="Evaluate2" method="post">
enter old name<br>
<input type="text" name="oldname"><br><br>
enter new name<br>
<input type="text" name="newname"><br><br>
 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
  
</form>
</body>
</html>