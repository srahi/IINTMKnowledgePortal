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
@WebServlet("/EditMessage")
public class EditMessage extends HttpServlet {
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
				out.println("<h1>Edit & send Message</h1>");
				out.println("<form action='MessageToAdmin' method='post' id='f1'>");
				out.println("<input type='hidden' name='m1' value='"
						+ id + "'>");
				out.println("<br>");
				out.println("Subject : <input type='text' required='required' name='m2' value='"
						+ sub + "'>");
				out.println("<br>");
				out.println("Message :"+"<textarea rows='10' cols='50' required='required' style='resize:none;' name='m3'>"+msg+"</textarea>");
				out.println("<br>");
				out.println("<input type='submit' value='send msg to Administrator'>");
				out.println("</form>");
				out.println("<br>");
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
