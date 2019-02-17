package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.models.UserModel;
@WebServlet("/ResultModifyController")
public class ResultModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		
		String s1=(String)session.getAttribute("uid1");
		
		String s4=request.getParameter("ti");
		String s5=request.getParameter("te");
		String s6=request.getParameter("tt");
	
		
						
			UserModel obj=new UserModel();
			obj.setUn(s1);
			
			obj.setTi(s4);
			obj.setTe(s5);
			obj.setTt(s6);
			
			String result=obj.modifyResult();
				if(result.equals("Success"))
				{
					out.println("Result for Student "+s1+" has been modified to Knowledge portal!!");
					
				}
				if(result.equals("Failed"))
				{
					out.println("Result for Student "+s1+" Failed to modify!! Try again...");
					RequestDispatcher rd=request.getRequestDispatcher("SearchloginIDresult.jsp");
					rd.include(request,response);
				}
			
		}
	
	}


