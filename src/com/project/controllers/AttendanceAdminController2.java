package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.models.UserModel;

@WebServlet("/AttendanceAdminController2")
public class AttendanceAdminController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String un=(String)session.getAttribute("uid2");
		String sem=(String)session.getAttribute("sem2");
		Float a1=Float.parseFloat(request.getParameter("a1"));
		
		UserModel obj=new UserModel();
		obj.setUn(un);
		obj.setSem(sem);
		obj.setAttendance(a1);
		
		
		String result=obj.modifyattendance();
		
		if(result.equals("success"))
		{
			out.println("Attendance Updated.");
			out.println("Insert another by clicking<a href='updateattendance.jsp'>Here</a>");
			out.println("Or <a href='uploadattendance.jsp'>Go Back</a>");
		}
		if(result.equals("failed"))
		{
			out.println("Attendance did not updated..Please Try again!");
			RequestDispatcher rd=request.getRequestDispatcher("SearchloginIDattendance.jsp");
			rd.include(request,response);
		}
		

	}

}
