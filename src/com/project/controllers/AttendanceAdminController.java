package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.models.UserModel;

@WebServlet("/AttendanceAdminController")
public class AttendanceAdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String un=request.getParameter("un");
		String sem=request.getParameter("sem");
		Float a1=Float.parseFloat(request.getParameter("a1"));
		
		UserModel obj=new UserModel();
		obj.setUn(un);
		obj.setAttendance(a1);
		obj.setSem(sem);
		
		String result=obj.uploadattendance();
		
		if(result.equals("success"))
		{
			out.println("Attendance Uploaded.");
			out.println("Insert another by clicking<a href='updateattendance.jsp'>Here</a>");
			out.println("Or <a href='uploadattendance.jsp'>Go Back</a>");
		}
		if(result.equals("failed"))
		{
			out.println("Attendance did not upload..Please Try again!");
			RequestDispatcher rd=request.getRequestDispatcher("updateattendance.jsp");
			rd.include(request,response);
		}
		if(result.equals("failed1"))
		{
			out.println("Record already exists..Please add different record.");
			RequestDispatcher rd=request.getRequestDispatcher("updateattendance.jsp");
			rd.include(request,response);
		}
		
		
	}

}
