package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Deletesyllabus
 */
@WebServlet("/deleterulebook")
public class DelRuleController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
			Statement st=conn.createStatement();
			ResultSet rs=st.executeQuery("select contact_id from rule_table");
			out.println("<center>");
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<div id='customers' width='100%'>");
			out.println("<table border=2>");
			out.println("<tr>");
			out.println("<th>S.no</th>");
			out.println("<th>Delete</th>");
			out.println("</tr>");
			while(rs.next())
			{
				int id=rs.getInt(1);
				out.println("<tr>");
				out.println("<td>" + rs.getInt(1) + "</td>");
				out.println("<td><a href='deleterule?x="+id+"'>Delete</a></td>");
				out.println("</tr>");
			}
			
			
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("</div>");
		out.println("<a href='rulebookmain.jsp'>Go Back</a>");
		out.println("</center>");
		
	}
	
	}


