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

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String un=request.getParameter("t1");
	
		
		
		UserModel obj=new UserModel();
		obj.setUn(un);
		
		String result=obj.delete();
		if(result.equals("success"))
		{
			out.println("StudentID Deleted.");
			out.println("Insert new Record by clicking<a href='registerID.jsp'>Here</a>");
			out.println("Or <a href='register.jsp'>Go Back</a>");
		}
		if(result.equals("failed"))
		{
			out.println("Record Did not Deleted..Please Try again!");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request,response);
		}
	}

}
