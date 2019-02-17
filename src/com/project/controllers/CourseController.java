package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.project.models.UserModel;

@WebServlet("/CourseController")
public class CourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		int s3=Integer.parseInt(request.getParameter("t3"));
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
		String s6=request.getParameter("t6");
		String s7=request.getParameter("t7");
		String s8=request.getParameter("t8");
		
		UserModel obj=new UserModel();
		obj.setUn(s1);
		obj.setTc(s2);
		obj.setRank(s3);
		obj.setStatus(s4);
		obj.setTs(s5);
		obj.setBatch(s6);
		obj.setRegdate(s7);
		obj.setRegupto(s8);
		
		String result=obj.courseReg();
		
		if(result.equals("Success"))
		{
			out.println("Student Registration Successfull!!!! <br><a href='register.jsp'>Click here</a> to go back");
			out.println("<a href='personalReg.jsp'>Click here</a>to continue to enter Personal Details..");
		}
		if(result.equals("Failed"))
		{
			out.println("Student Registration Failed!!!! <br><a href='registerID.jsp'>Click here</a> to Try again");
		}
		
	}

}
