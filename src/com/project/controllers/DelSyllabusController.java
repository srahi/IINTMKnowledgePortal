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


@WebServlet("/DelSyllabusController")
public class DelSyllabusController extends HttpServlet {


	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		int seq1=Integer.parseInt(request.getParameter("seq1"));
				UserModel obj=new UserModel();
				
				
				String result=obj.deletesyllabus();
				obj.setSeq(seq1);
				if(result.equals("success"))
				{
					out.println("Syllabus Deleted.<br>");
					out.println("Insert new RuleBook by clicking<a href='rulebook.jsp'>Here</a><br>");
					out.println("Or <a href='rulebookmain.jsp'>Go Back</a>");
				}
				if(result.equals("failed"))
				{
					out.println("RuleBook Did not Deleted..Please Try again!");
					RequestDispatcher rd=request.getRequestDispatcher("rulebookmain.jsp");
					rd.include(request,response);
				}
			}
}


