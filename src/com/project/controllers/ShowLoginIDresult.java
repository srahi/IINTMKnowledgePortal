package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowLoginIDresult")
public class ShowLoginIDresult extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		
		try{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from result_table where username like '%"+s1+"%'");
	
			ResultSet rs=ps.executeQuery();
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<div id='customers' width='100%'>");
			out.println("<table border=3>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>INTERNAL MARKS</th>");
			out.println("<th>EXTERNAL MARKS</th>");
			out.println("<th>TOTAL MARKS</th>");
			out.println("<th>Operations</th>");
			
			
			while(rs.next()){
				String i = rs.getString(1);
				
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("<td>"+rs.getString(5)+"</td>");
				out.println("<td>"+rs.getString(6)+"</td>");
				out.println("<td><a href='AlterResultID?a1="+i+"'</a>MODIFY</a></td>");
				out.println("</tr>");
				
				
				//out.println(name);
			}
			out.println("</table>");
			out.println("</div>");
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
