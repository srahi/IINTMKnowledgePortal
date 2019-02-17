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
@WebServlet("/AlterResultID")
public class AlterResultID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from result_table where username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String sem = rs.getString(2);
				String course = rs.getString(3);
				String internal = rs.getString(4);
				String external = rs.getString(5);
				String total = rs.getString(6);
				
				HttpSession session = request.getSession();
				session.setAttribute("uid1",uname);
				
				out.println("<center>");
				out.println("<h1>Alter Result</h1>");
				out.println("<form action='ResultModifyController' method='post'>");
				out.println("Username : <input type='text' name='un' disabled='disabled' required='required' value='"
						+ uname + "'>");
				out.println("<br>");
				out.println("Semester : <input type='text' required='required' disabled='disabled'  name='ts' value='"
						+ sem + "'>");
				out.println("<br>");
				out.println("Course : <input type='text' required='required' disabled='disabled' name='tc' value='"
						+ course + "'>");
				out.println("<br>");
				out.println("Internal Marks : <input type='number'  required='required' name='ti' value='"
						+ internal + "'>");
				out.println("<br>");
				out.println("External Marks : <input type='number' required='required' name='te' value='"
						+ external + "'>");
				out.println("<br>");
				out.println("Total Marks : <input type='number' required='required' name='tt' value='"
						+ total + "'>");
				out.println("<input type='submit' value='Update'>");
				out.println("</form>");
				out.println("<br>");
				out.println("</center>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		
	}}}
