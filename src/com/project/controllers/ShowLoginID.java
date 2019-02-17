package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ShowLoginID")
public class ShowLoginID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		
		try{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from login_table where username like '%"+s1+"%' and username not like 'admin' and username not like 'faculty'");
	
			ResultSet rs=ps.executeQuery();
			
		
			
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>PASSWORD</th>");
			out.println("<th>FIRST NAME</th>");
			out.println("<th>LAST NAME</th>");
			out.println("<th colspan=2>Operations</th>");
			
			
			while(rs.next()){
				String i = rs.getString(1);
				
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td><a href='AlterLoginID?a1="+i+"'</a>UPDATE</a></td>");
				out.println("</tr>");
				
				
				//out.println(name);
			}
			out.println("</table>");
			
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
