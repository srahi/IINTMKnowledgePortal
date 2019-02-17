package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.models.UserModel;


@WebServlet("/PersonalController")
public class PersonalController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String s3=request.getParameter("t3");
		String s4=request.getParameter("t4");
		String s5=request.getParameter("t5");
		String s6=request.getParameter("t6");
		String s7=request.getParameter("t7");
		String s8=request.getParameter("t8");
		
		UserModel obj=new UserModel();
		obj.setUn(s1);
		obj.setDob(s2);
		obj.setGender(s3);
		obj.setEmail(s4);
		obj.setContactno(s5);
		obj.setAddress(s6);
		obj.setCity(s7);
		obj.setState(s8);
		
		String result=obj.personalReg();
		
		if(result.equals("success"))
		{
			out.println("Student Full Registration Successfull!!!! <br><a href='register.jsp'>Click here</a> to go back");
		}
		if(result.equals("failed"))
		{
			out.println("Student Full Registration Failed!!!! <br><a href='registerID.jsp'>Click here</a> to Try again");
		}
		if(result.equals("failed1"))
		{
			out.println("Record Already Uploaded..Try Alter Personal Details..");
		}
		
	}
	}

