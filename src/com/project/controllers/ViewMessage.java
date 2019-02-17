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
@WebServlet("/ViewMessage")
public class ViewMessage extends HttpServlet {
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
				out.println("<h1>Messsage from "+id+"</h1>");
				out.println("<fieldset>");
				out.println("<legend>");
				out.println("<b>"+sub+"</b>");
				out.println("</legend>");
				out.println("<form>");
				out.println("<textarea rows='10' cols='50' style='resize:none;'>"+msg+"</textarea>");
				out.println("</form>");
				out.println("</fieldset>");
				out.println("</center>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
