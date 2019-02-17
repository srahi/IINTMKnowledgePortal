package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int id=Integer.parseInt(request.getParameter("x"));
	
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("delete from syllabus_detail where contact_id=?");
			ps.setInt(1,id);
			int i=ps.executeUpdate();
			if(i==0)
			{
			
				out.println("Syllabus did not deleted.<br>");
				out.println("<a href='syllabus.jsp'>Go Back</a>");
			}
			else
			{
			
				out.println("Syllabus Deleted.<br>");
				out.println("<a href='syllabus.jsp'>Go Back</a>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

}
}
