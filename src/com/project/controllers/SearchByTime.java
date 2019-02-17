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


@WebServlet("/SearchByTime")
public class SearchByTime extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String t1=request.getParameter("t1");
		String t2=request.getParameter("t2");
		
			System.out.println(t1);
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			PreparedStatement ps=conn.prepareStatement("SELECT * FROM login_table WHERE time1 between ? and ?");
			ps.setString(1,t1);
			ps.setString(2,t2);
			ResultSet rs=ps.executeQuery();
			out.println("<center>");
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>UserName</th>");
			out.println("<th>Password</th>");
			out.println("<th>FirstName</th>");
			out.println("<th>LastName</th>");
			out.println("<th>Date</th>");
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
				out.println("</tr>");
			}			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</center>");
		
	}

}
