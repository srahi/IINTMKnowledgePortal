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

@WebServlet("/PassController")
public class PassController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String p1=request.getParameter("p1");
		String p2=request.getParameter("p2");
		String p3=request.getParameter("p3");
		
		HttpSession session=request.getSession();
		String s2=(String)session.getAttribute("pass");
		String uname=(String)session.getAttribute("uname");
		
		
		
		if(p1.equals(s2))
		{
			if(p2.equals(p3))
			{
				UserModel obj=new UserModel();
				obj.setUp(p2);
				obj.setUn(uname);
				String result=obj.password();
				if(result.equals("success"))
				{
					out.println("Password Changed Successfully");
					out.println("<a href='login.jsp'>Login Here</a>");
				}
				if(result.equals("failed"))
				{
					out.println("Password did not changed..Try again!!");
					RequestDispatcher rd=request.getRequestDispatcher("changep.jsp");
					rd.include(request,response);
				}
			}
			else
			{
				out.println("New Password did not matched!");
				RequestDispatcher rd=request.getRequestDispatcher("changep.jsp");
				rd.include(request,response);
			}
		}
		else
		{
			out.println("Invalid Old Password..Please try again.");
			RequestDispatcher rd=request.getRequestDispatcher("changep.jsp");
			rd.include(request,response);
		}
		
	}

}
