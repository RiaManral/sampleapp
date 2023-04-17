<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search by Name</title>
</head>
<body>
<form action="Evaluate2" method="post">
enter name to search<br>
<input type="text" name="name"><br><br>
 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
  
</form>


</body>
</html>