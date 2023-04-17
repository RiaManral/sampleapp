<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Table</title>
</head>
<body>

<%
//int ch=(int)request.getAttribute("ch");

//System.out.println("ch from createtable.jsp "+ch );
//request.setAttribute("ch",ch);
//System.out.println("ch from createtable.jsp again "+ch );
// 

%>

<form action="Evaluate2" method="post">
enter table name<br>
<input type="text" name="table"><br><br>
 <input type="hidden" name="ch" value="<%= request.getAttribute("ch") %>">
    <input type="submit" value="SUBMIT">
  
 
  
</form>
</body>
</html>