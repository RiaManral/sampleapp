package com.company;
import java.io.IOException;
import java.util.*;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class DbFunctions{
	public Connection connect_to_db(String dbname, String user, String password) {
		Connection conn=null;
		
		try {
			
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://mypostgresdb2:5432/"+dbname,user,password);
			if(conn!=null)
				System.out.println("connection established !!!");
			else
				System.out.println("connection failed !!!");
			
		}catch(Exception e) {
			System.out.println(e);
		}
	
	
	return conn;
	}
	
//	public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
//		int ch=(int)req.getAttribute("ch");
//		switch(ch) {
//		case 1: 
//			String table=req.getParameter("table");
//			db.createTable(conn,table);
//		}
//	}

	
	public void createTable(Connection conn, String table_name){
        Statement statement;
        try{
            String query="create table "+table_name+"(empid SERIAL,name varchar(200),address varchar(200),primary key(empid));";
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Created");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void insert_row(Connection conn,String table_name,String name, String address){
        Statement statement;
        try {
            String query=String.format("insert into %s(name,address) values('%s','%s');",table_name,name,address);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Row Inserted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String[][] read_data(Connection conn, String table_name){
        Statement statement;
        ResultSet rs=null;
        String[][] data=null;
        try {
            String query=String.format("select * from %s",table_name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            
            // get the number of columns in the ResultSet object

            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
           
//                System.out.print(rs.getString("empid")+" ");
//                System.out.print(rs.getString("name")+" ");
//                System.out.println(rs.getString("Address")+" ");

            	// iterate over the ResultSet object and store the data in a 2D array
         // iterate over the ResultSet object and store the data in a 2D array
            ArrayList<String[]> rows = new ArrayList<>();
            while (rs.next()) {
                String[] row = new String[numColumns];
                for (int i = 1; i <= numColumns; i++) {
                    row[i-1] = rs.getString(i);
                }
                rows.add(row);
            }
            data = rows.toArray(new String[rows.size()][numColumns]);
        }
        catch (Exception e){
            System.out.println(e);
        }
        return data;
    }
    
    
    
    
    
    public void update_name(Connection conn,String table_name, String old_name,String new_name){
        Statement statement;
        try {
            String query=String.format("update %s set name='%s' where name='%s'",table_name,new_name,old_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Updated");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public String[][] search_by_name(Connection conn, String table_name,String name){
        Statement statement;
        ResultSet rs=null;
        String[][] data2=null;
        try {
            String query=String.format("select * from %s where name like '%s'",table_name,name);
            statement=conn.createStatement();
            rs=statement.executeQuery(query);
            
            ResultSetMetaData rsmd = rs.getMetaData();
            int numColumns = rsmd.getColumnCount();
            while (rs.next()){
                System.out.print(rs.getString("empid")+" ");
                System.out.print(rs.getString("name")+" ");
                System.out.println(rs.getString("address"));
            	
            	ArrayList<String[]> rows = new ArrayList<>();
                while (rs.next()) {
                    String[] row = new String[numColumns];
                    for (int i = 1; i <= numColumns; i++) {
                        row[i-1] = rs.getString(i);
                    }
                    rows.add(row);
                }
                data2 = rows.toArray(new String[rows.size()][numColumns]);

            }
        }catch (Exception e){
            System.out.println(e);
        }
		return data2;
    }
//    public String search_by_id(Connection conn, String table_name,int id){
//        Statement statement;
//        ResultSet rs=null;
//        String data="";
//        
//        try {
//            String query=String.format("select * from %s where empid= %s",table_name,id);
//            statement=conn.createStatement();
//            rs=statement.executeQuery(query);
//           
//            while (rs.next()){
////                System.out.print(rs.getString("empid")+" ");
////                System.out.print(rs.getString("name")+" ");
////                System.out.println(rs.getString("address"));
//            	data+=rs.getString("empid")+" ";
//            	data+=rs.getString("name")+" ";
//            	data+=rs.getString("address")+" ";
//            	
//
//            }
//        }catch (Exception e){
//            System.out.println(e);
//        }
//        return data;
//    }

    public void delete_row_by_name(Connection conn,String table_name, String name){
        Statement statement;
        try{
            String query=String.format("delete from %s where name='%s'",table_name,name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }
    public void delete_row_by_id(Connection conn,String table_name, int id){
        Statement statement;
        try{
            String query=String.format("delete from %s where empid= %s",table_name,id);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void delete_table(Connection conn, String table_name){
        Statement statement;
        try {
            String query= String.format("drop table %s",table_name);
            statement=conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table Deleted");
        }catch (Exception e){
            System.out.println(e);
        }
    }

	
			
		
		
}



