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
@WebServlet("/ShowByFile")
public class ShowByFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		try
		{
			Connection conn = ConnectionProvider.getConn();
			
			out.println("Syllabus Found");
			PreparedStatement ps4=conn.prepareStatement("select * from syllabus_detail where detail like '%"+s1+"%'");
			ResultSet rs4=ps4.executeQuery();
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=3 id='customers' width='100%'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>FILE</th>");
			out.println("<th>DETAIL</th>");
			out.println("</tr>");
			
			while(rs4.next())
			{
				String id1=rs4.getString(1);
				
				out.println("<tr>");
				out.println("<td>"+rs4.getString(1)+"</td>");
				out.println("<td>"+rs4.getString(2)+"</td>");
				out.println("<td>"+rs4.getString(3)+"</td>");
				out.println("<td><a href='ShowSyllabusAdmin?id="+id1+"'>View File</a></td>");
				out.println("<td>"+rs4.getString(5)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Time Table Found");
			
			PreparedStatement ps5=conn.prepareStatement("select * from time_table where detail like '%"+s1+"%'");
			
			ResultSet rs5=ps5.executeQuery();
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=3 id='customers' width='100%'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>DETAIL</th>");
			out.println("<th>FILE</th>");
			out.println("</tr>");
			
			while(rs5.next())
			{
				String id1=rs5.getString(1);
				
				out.println("<tr>");
				out.println("<td>"+rs5.getString(1)+"</td>");
				out.println("<td>"+rs5.getString(2)+"</td>");
				out.println("<td>"+rs5.getString(3)+"</td>");
				out.println("<td>"+rs5.getString(4)+"</td>");
				out.println("<td><a href='timetableadmin?id="+id1+"'>View File</a></td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Study Material Found");
			
			PreparedStatement ps6=conn.prepareStatement("select * from study_table where filename like '%"+s1+"%' or filedetails like '%"+s1+"%'");
			
			ResultSet rs6=ps6.executeQuery();
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=3 id='customers' width='100%'>");
			out.println("<tr>");
			out.println("<th>ID</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>NAME</th>");
			out.println("<th>DETAIL</th>");
			out.println("<th>FILE</th>");
			out.println("</tr>");
			
			while(rs6.next())
			{
				String id1=rs6.getString(1);
				
				out.println("<tr>");
				out.println("<td>"+rs6.getString(1)+"</td>");
				out.println("<td>"+rs6.getString(2)+"</td>");
				out.println("<td>"+rs6.getString(3)+"</td>");
				out.println("<td>"+rs6.getString(4)+"</td>");
				out.println("<td>"+rs6.getString(5)+"</td>");
				out.println("<td><a href='downloadadmin?id="+id1+"'>View File</a></td>");
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
