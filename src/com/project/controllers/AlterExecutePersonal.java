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


@WebServlet("/AlterExecutePersonal")
public class AlterExecutePersonal extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String uid=(String)session.getAttribute("uid");
		String uname = request.getParameter("uname");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String contactno = request.getParameter("contactno");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update student_detail set username=? , dob=?, gender=?, email=?, contactno=?, address=?, city=?, state=? where username=?");
			ps.setString(1,uname);
			ps.setString(2,dob);
			ps.setString(3,gender);
			ps.setString(4,email);
			ps.setString(5,contactno);
			ps.setString(6,address);
			ps.setString(7,city);
			ps.setString(8,state);
			ps.setString(9,uid);
			int check = ps.executeUpdate();
			if(check==0){
				out.println("Update Not Successfull");
			}
			else
			{
				out.println("Update Successfull ------ <a href='editCourse.jsp'>Click here to go back</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
