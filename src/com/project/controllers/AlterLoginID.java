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


@WebServlet("/AlterLoginID")
public class AlterLoginID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from login_table where username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String upass = rs.getString(2);
				String fname = rs.getString(3);
				String lname = rs.getString(4);
				
				HttpSession session = request.getSession();
				session.setAttribute("uid", uname);
				
				out.println("<center>");
				out.println("<h1>Update Form</h1>");
				out.println("<form action='AlterExecuteLoginID' method='post'>");
				out.println("Username : <input type='text' name='user' value='"
						+ uname + "'>");
				out.println("<br>");
				out.println("Password : <input type='text' name='pass' value='"
						+ upass + "'>");
				out.println("<br>");
				out.println("First Name : <input type='text' name='fname' value='"
						+ fname + "'>");
				out.println("<br>");
				out.println("Last Name : <input type='text' name='lname' value='"
						+ lname + "'>");
				out.println("<br>");
				out.println("<input type='submit' value='Update'>");
				out.println("</form>");
				out.println("<br>");
				out.println("</center>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
