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


@WebServlet("/AlterPersonalDetails")
public class AlterPersonalDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from student_detail where username=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String uname = rs.getString(1);
				String dob = rs.getString(2);
				String gender = rs.getString(3);
				String email = rs.getString(4);
				String contactno = rs.getString(5);
				String address = rs.getString(6);
				String city = rs.getString(7);
				String state = rs.getString(8);
				
				HttpSession session = request.getSession();
				session.setAttribute("uid", uname);
				
				out.println("<center>");
				out.println("<h1>Update Form</h1>");
				out.println("<form action='AlterExecutePersonal' method='post'>");
				out.println("Username : <input type='text' required='required' name='uname' value='"
						+ uname + "'>");
				out.println("<br>");
				out.println("Course : <input type='text' required='required' maxlength='20' name='dob' value='"
						+ dob + "'>");
				out.println("<br>");
				out.println("Rank : <input type='number' max='20000' required='required' name='gender' value='"
						+ gender + "'>");
				out.println("<br>");
				out.println("Status : <input type='text' required='required' name='email' value='"
						+ email + "'>");
				out.println("<br>");
				out.println("Semester : <input type='text' required='required' name='contactno' value='"
						+ contactno + "'>");
				out.println("<br>");
				out.println("Batch : <input type='text' required='required' name='address' value='"
						+ address + "'>");
				out.println("<br>");
				out.println("Registration Date : <input type='date' required='required' name='city' value='"
						+ city + "'>");
				out.println("<br>");
				out.println("Valid Upto : <input type='date' required='required' name='state' value='"
						+ state + "'>");
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
