<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert new Row</title>
</head>
<body>
<form action="Evaluate2" method="post">
enter employee name<br>
<input type="text" name="name"><br><br>
enter location<br>
<input type="text" name="loc"><br><br>
 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
  
</form>

</body>
</html>