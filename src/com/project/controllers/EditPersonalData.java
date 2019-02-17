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
@WebServlet("/EditPersonalData")
public class EditPersonalData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session=request.getSession();
		String un=(String)session.getAttribute("uname");

		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from student_detail where username=?");
			ps.setString(1, un);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String DOB=rs.getString(2);
				String gender=rs.getString(3);
				String email=rs.getString(4);
				String contactno=rs.getString(5);
				String address=rs.getString(6);
				String city=rs.getString(7);
				String state=rs.getString(8);
				
				out.println("<center>");
				out.println("<h1>Edit Your Personal Details</h1>");
				out.println("<table style='border-spacing: 10px 0;'>");
				out.println("<form action='EditPersonalDataExecute' method='post'>");
				out.println("<tr>");
				out.println("<td>Date of Birth : </td><td><input type='text' name='m1' value='"+ DOB + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Gender : </td><td><input type='text' name='m2' value='"+ gender + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Email ID : </td><td><input type='text' name='m3' value='"+ email + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Contact no. : </td><td><input type='text' name='m4' value='"+ contactno + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>Addrress : </td><td><input type='text' name='m5' value='"+ address + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>City : </td><td><input type='text' name='m6' value='"+ city + "'></td>");
				out.println("</tr>");
				out.println("<tr>");
				out.println("<td>State : </td><td><input type='text' name='m7' value='"+ state + "'></td>");
				out.println("</tr>");
				out.println("</table>");
				out.println("<br>");
				out.println("<input type='submit' value='Save'>");
				out.println("</form>");
				out.println("</center>");
			}
			else{
				out.println("Can't Display your Personal Details");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
