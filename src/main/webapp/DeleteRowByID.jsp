<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Row By ID</title>
</head>
<body>
<form action="Evaluate2" method="post">
enter ID for deletion<br>
<input type="number" name="id"><br><br>

 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
  
</form>
</body>
</html>