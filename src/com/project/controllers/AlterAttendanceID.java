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
@WebServlet("/AlterAttendanceID")
public class AlterAttendanceID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");
		String id2 = request.getParameter("a2");
		System.out.println(id2);
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from attendance_detail where username=? and semester=?");
			ps.setString(1,id);
			ps.setString(2,id2);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String sem = rs.getString(2);
				int attend = rs.getInt(3);
				
				System.out.println(uname);
				System.out.println(sem);
				System.out.println(attend);
				
				HttpSession session = request.getSession();
				session.setAttribute("uid2", uname);
				session.setAttribute("sem2", sem);
				
				out.println("<center>");
				out.println("<h1>Update Form</h1>");
				out.println("<form action='AttendanceAdminController2' method='post'>");
				out.println("Username : <input type='text' disabled='disabled' name='un' value='"
						+ uname + "'>");
				out.println("<br>");
				out.println("Semester : <input type='text' disabled='disabled' name='sem' value='"
						+ sem + "'>");
				out.println("<br>");
				out.println("Attendance : <input type='number' required='required' step='any' min='1' max='100' name='a1' value='"
						+ attend + "'>");
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
