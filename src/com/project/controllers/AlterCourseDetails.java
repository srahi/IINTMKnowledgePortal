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


@WebServlet("/AlterCourseDetails")
public class AlterCourseDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from course_detail where username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String course = rs.getString(2);
				int rank =rs.getInt(3);
				String status = rs.getString(4);
				String semester = rs.getString(5);
				String batch = rs.getString(6);
				String rd = rs.getString(7);
				String vu = rs.getString(8);
				
				HttpSession session = request.getSession();
				session.setAttribute("uid", uname);
				
				out.println("<center>");
				out.println("<h1>Update Form</h1>");
				out.println("<form action='AlterExecuteCourse' method='post'>");
				out.println("Username : <input type='text' disabled='disabled' name='uname' value='"
						+ uname + "'>");
				out.println("<br>");
				out.println("Course : <input type='text' required='required' maxlength='20' name='course' value='"
						+ course + "'>");
				out.println("<br>");
				out.println("Rank : <input type='number' required='required' max='20000' name='rank' value='"
						+ rank + "'>");
				out.println("<br>");
				out.println("Status : <input type='text'  required='required' name='status' value='"
						+ status + "'>");
				out.println("<br>");
				out.println("Semester : <input type='text' required='required' name='semester' value='"
						+ semester + "'>");
				out.println("<br>");
				out.println("Batch : <input type='text' required='required' name='batch' value='"
						+ batch + "'>");
				out.println("<br>");
				out.println("Registration Date : <input type='date' required='required' name='rd' value='"
						+ rd + "'>");
				out.println("<br>");
				out.println("Valid Upto : <input type='date' required='required' name='vu' value='"
						+ vu + "'>");
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
