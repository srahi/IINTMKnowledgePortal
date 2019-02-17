package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/StudentDashboard")
public class StudentDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("uname");
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			PreparedStatement ps=conn.prepareStatement("select username,course,rank,status,semester,batch,registrationdate,validupto from course_detail where username=?");
			ps.setString(1,uname);
			ResultSet rs=ps.executeQuery();
			
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<center>");
			out.println("<div id='customers'>");
			out.println("<table border=2 width=100% height=50%>");
			out.println("<tr>");
			out.println("<th>UserName</th>");
			out.println("<th>Course</th>");
			out.println("<th>Rank</th>");
			out.println("<th>Status</th>");
			out.println("<th>Semester</th>");
			out.println("<th>Batch</th>");
			out.println("<th>Registration Date</th>");
			out.println("<th>Valid Upto</th>");
			out.println("</tr>");
			System.out.println("outside rs.next");
			while(rs.next())
			{
				System.out.println("inside rs.next");
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td>" + rs.getString(5) + "</td>");
				out.println("<td>" + rs.getString(6) + "</td>");
				out.println("<td>" + rs.getString(7) + "</td>");
				out.println("<td>" + rs.getString(8) + "</td>");
				out.println("</tr>");
			}
			
			
			out.println("</div>");
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</center>");
		
		out.println("<br><br><br>");
		

		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			PreparedStatement ps=conn.prepareStatement("select username,dob,gender,email,contactno,address,city,state from student_detail where username=?");
			ps.setString(1,uname);
			ResultSet rs=ps.executeQuery();
			
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<center>");
			out.println("<div id='customers'>");
			out.println("<table border=2 width=100% height=50%>");
			out.println("<tr>");
			out.println("<th>UserName</th>");
			out.println("<th>Date Of Birth</th>");
			out.println("<th>Gender</th>");
			out.println("<th>Email</th>");
			out.println("<th>Contact No.</th>");
			out.println("<th>Address</th>");
			out.println("<th>City</th>");
			out.println("<th>State</th>");
			out.println("</tr>");
		
			while(rs.next())
			{
				System.out.println("inside rs.next");
				out.println("<tr>");
				out.println("<td>" + rs.getString(1) + "</td>");
				out.println("<td>" + rs.getString(2) + "</td>");
				out.println("<td>" + rs.getString(3) + "</td>");
				out.println("<td>" + rs.getString(4) + "</td>");
				out.println("<td>" + rs.getString(5) + "</td>");
				out.println("<td>" + rs.getString(6) + "</td>");
				out.println("<td>" + rs.getString(7) + "</td>");
				out.println("<td>" + rs.getString(8) + "</td>");
				out.println("</tr>");
			}
			
			
			out.println("</div>");
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</center>");
		out.println("<a href='EditPersonalData' target='iframe'>Click here</a> to edit your personal details");
		
	}
	}

