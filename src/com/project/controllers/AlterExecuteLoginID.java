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


@WebServlet("/AlterExecuteLoginID")
public class AlterExecuteLoginID extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String id =(String)session.getAttribute("uid");
		String uname = request.getParameter("user");
		String upass = request.getParameter("pass");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update login_table set username=? , password=?, firstname=?, lastname=? where username=?");
			ps.setString(1, uname);
			ps.setString(2, upass);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setString(5, id);
			int check = ps.executeUpdate();
			if(check==0){
				out.println("Update Not Successfull");
			}
			else
			{
				out.println("Update Successfull ------ <a href='SearchloginID.jsp'>Click here to go back</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
