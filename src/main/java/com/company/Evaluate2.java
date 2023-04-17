package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Evaluate2 extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		DbFunctions db=new DbFunctions();
		Connection conn= db.connect_to_db("mydb", "postgres", "ria");


		//error - Cannot invoke "java.lang.Integer.intValue()" because the return value of 
		//"javax.servlet.http.HttpServletRequest.getAttribute(String)" is null

		int ch=Integer.parseInt(req.getParameter("ch"));
//		System.out.println("table in evaluate2 "+ req.getParameter("table"));
//		System.out.println(ch);
		
//		int ch=(int)req.getAttribute("ch");
//		System.out.println(ch);
		
		PrintWriter out=res.getWriter();
		switch(ch) {
		  case 1:
			  String table=req.getParameter("table");
			  db.createTable(conn,table);
			  out.println("table "+table+" is created");
			  
		    break;
		  case 2:
			  table=req.getParameter("table");
			  String[][] data =db.read_data(conn,table);
			  out.println("Reading Table "+table);
		       res.setContentType("text/html");
		    // write the HTML code to display the data in a table
		        out.println("<html>");
		        out.println("<head><title>Data from Database</title></head>");
		        out.println("<body>");
		        out.println("<table border=\"1\">");
		      
		        
		        
		     // write the data rows
		        for (int i = 0; i < data.length; i++) {
		            out.println("<tr>");
		            for (int j = 0; j < data[i].length; j++) {
		                out.println("<td>" + data[i][j] + "</td>");
		            }
		            out.println("</tr>");
		        }
		        out.println("</table>");
		        out.println("</body>");
		        out.println("</html>");
			  break;
			  //fetched results

		  case 3:
			  
			  String oldname=req.getParameter("oldname");
		
			  String newname= req.getParameter("newname");
			  db.update_name(conn,"employee", oldname, newname);
			  out.println("row updated by name");
		    break;
		  case 4:
			
			  String name=req.getParameter("name");
			  String loc= req.getParameter("loc");
			  db.insert_row(conn,"employee",name,loc);
			  out.println("new row inserted");
			  break;
//		
		  case 5:
			  //search by name
			  
			  name= req.getParameter("name");
			  String[][] data2=db.search_by_name(conn,"employee",name);
			  out.println("search by name: "+name);
			  res.setContentType("text/html");
			    // write the HTML code to display the data in a table
			        out.println("<html>");
			        out.println("<head><title>Data from Database</title></head>");
			        out.println("<body>");
			        out.println("<table border=\"1\">");
				      
			        
			        
				     // write the data rows
				        for (int i = 0; i < data2.length; i++) {
				            out.println("<tr>");
				            for (int j = 0; j < data2[i].length; j++) {
				                out.println("<td>" + data2[i][j] + "</td>");
				            }
				            out.println("</tr>");
				        }
				        out.println("</table>");
			        
			        
			    
			        out.println("</body>");
			        out.println("</html>");
			  
			  break;
			  //fetched results
//		    
		  case 6:
			  
			  name= req.getParameter("name");

			  db.delete_row_by_name(conn,"employee",name);
			  out.println("row with name "+name+" is deleted. Check Database!");
			 break;
//			 
		  case 7:
			  
			  int ID= Integer.parseInt(req.getParameter("id"));
			  db.delete_row_by_id(conn,"employee",ID);
			  out.println("row with name "+ID+" is deleted. Check Database!");
			  
		    break;
		  case 8:
			   table=req.getParameter("table");
			  db.delete_table(conn,table);
			  out.println(table+" table is deleted. Check Database!");
			  break;
			  
		  default:
			  System.out.println("wrong choiceeee");

}
		res.setContentType("text/html");
		out.println("<html>");
	    out.println("<head><title>Index.html</title></head>");
	    out.println("<body>");
	    out.println("<br><br>");
	    out.println("<button onclick=\"window.location.href='index.html'\">Go to main page?</button>");
	    out.println("</body>");
	    out.println("</html>");
		
	}

}
