<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete Table</title>
</head>
<body>
<form action="Evaluate2" method="post">
enter table name to be deleted<br>
<input type="text" name="table"><br><br>
 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
</body>
</html>