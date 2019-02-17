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

@WebServlet("/AlterController")
public class AlterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String un=request.getParameter("t1");
		String up=request.getParameter("t2");
		String fn=request.getParameter("t3");
		String ln=request.getParameter("t4");
		
		
		UserModel obj=new UserModel();
		obj.setUn(un);
		obj.setUp(up);
		obj.setFn(fn);
		obj.setLn(ln);
		String result=obj.alter();
		if(result.equals("success"))
		{
			out.println("StudentID Updated.");
			out.println("Insert new Record by clicking<a href='alterID.jsp'>Here</a>");
			out.println("Or <a href='register.jsp'>Go Back</a>");
		}
		if(result.equals("failed"))
		{
			out.println("Record Did not Updated..Please Try again!");
			RequestDispatcher rd=request.getRequestDispatcher("register.jsp");
			rd.include(request,response);
		}
	}

}
