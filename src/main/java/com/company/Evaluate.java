package com.company;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
public class Evaluate extends HttpServlet {
	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		
		
//		DbFunctions db=new DbFunctions();
//		Connection conn= db.connect_to_db("mydb", "postgres", "ria");
		PrintWriter out=res.getWriter();
		
		
		int ch= Integer.parseInt(req.getParameter("num1"));
		//System.out.println("ch after getParameter num1"+ch);
		req.setAttribute("ch",ch);
		   //res.sendRedirect("Evaluate");

		//System.out.println("ch after set"+ req.getAttribute("ch"));


		res.setContentType("text/html");
		RequestDispatcher rd;
		
		switch(ch) {
		case 1: rd=req.getRequestDispatcher("CreateTable.jsp");
		
		rd.forward(req, res);
		

		break;
		
		case 2: rd=req.getRequestDispatcher("ReadData.jsp");
		
		rd.forward(req, res);
		

		break;
		
		case 3: rd=req.getRequestDispatcher("UpdateName.jsp");
		
		rd.forward(req, res);
		

		break;
		
		case 4: rd=req.getRequestDispatcher("InsertRow.jsp");

		rd.forward(req, res);


		break;
		case 5: rd=req.getRequestDispatcher("SearchByName.jsp");

		rd.forward(req, res);


		break;
		case 6: rd=req.getRequestDispatcher("DeleteRowbyName.jsp");

		rd.forward(req, res);


		break;
		case 7: rd=req.getRequestDispatcher("DeleteRowByID.jsp");

		rd.forward(req, res);


		break;
		case 8: rd=req.getRequestDispatcher("DeleteTable.jsp");

		rd.forward(req, res);


		break;
		
		default:
			
			out.println("invalid choice!!!");
		
		}
		
		
		
	
	}

}
