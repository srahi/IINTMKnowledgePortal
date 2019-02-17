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
import javax.servlet.http.HttpSession;

@WebServlet("/ShowStudentMessage")
public class ShowStudentMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String un=(String)session.getAttribute("uname");
		
		try
		{
			Connection conn = ConnectionProvider.getConn(); 
			PreparedStatement ps=conn.prepareStatement("select * from student_message where username=?");
			ps.setString(1,un);
			ResultSet rs=ps.executeQuery();
			
		
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			
			out.println("<th>Subject</th>");
			out.println("<th colspan='2'>Operations</th>");
			
			
			while(rs.next()){
				String i1 = rs.getString(1);
				String i2 = rs.getString(2);
				String i3 = rs.getString(3);
				
				out.println("<tr>");
	
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td><a href='ViewStudentMessage?a1="+i1+"&a2="+i2+"&a3="+i3+"'</a>View</a></td>");

				out.println("</tr>");
				
			}
			out.println("</table>");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
