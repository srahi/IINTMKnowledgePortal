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


@WebServlet("/ViewStudentMessage")
public class ViewStudentMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");
		String sub = request.getParameter("a2");
		String msg = request.getParameter("a3");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from student_message where username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				out.println("<center>");
				out.println("<h1>Message</h1>");
				out.println("<form >");
			
			
				out.println("Subject : <input type='text' name='m2' value='"
						+ sub + "'>");
				out.println("<br>");
				out.println("Message :"+"<textarea rows='10' cols='50' style='resize:none;' name='m3'>"+msg+"</textarea>");
				out.println("<br>");
				out.println("</form>");
				out.println("<br>");
				out.println("<a href='ShowStudentMessage'>Go Back</a>");
				out.println("</center>");
				
			}
			else{
				out.println("No Messages were Found!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
