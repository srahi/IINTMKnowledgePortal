package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/EditPersonalDataExecute")
public class EditPersonalDataExecute extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String uid=(String)session.getAttribute("uname");
		String dob = request.getParameter("m1");
		String gender = request.getParameter("m2");
		String email = request.getParameter("m3");
		String contactno = request.getParameter("m4");
		String address = request.getParameter("m5");
		String city = request.getParameter("m6");
		String state = request.getParameter("m7");
		
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update student_detail set dob=?, gender=?, email=?, contactno=?, address=?, city=?, state=? where username=?");
			ps.setString(1,dob);
			ps.setString(2,gender);
			ps.setString(3,email);
			ps.setString(4,contactno);
			ps.setString(5,address);
			ps.setString(6,city);
			ps.setString(7,state);
			ps.setString(8,uid);
			int check = ps.executeUpdate();
			if(check==0){
				out.println("Update Not Successfull");
			}
			else
			{
				out.println("Update Successfull ------ <a href='StudentDashboard'>Click here to go back</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
