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
@WebServlet("/ShowLoginIDattendance")
public class ShowLoginIDattendance extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		
		try{
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from attendance_detail where username like '%"+s1+"%'");
	
			ResultSet rs=ps.executeQuery();
			
		
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<div id='customers' width='100%'>");
			out.println("<table border=3>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>ATTENDANCE</th>");
			out.println("<th>Operations</th>");
			
			
			while(rs.next()){
				String i = rs.getString(1);
				String s = rs.getString(2);
				
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td><a href='AlterAttendanceID?a1="+i+"&a2="+s+"'</a>MODIFY</a></td>");
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
