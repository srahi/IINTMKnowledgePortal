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
@WebServlet("/MessageToFaculty")
public class MessageToFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("uname");
		
		String sub=request.getParameter("m1");
		String msg=request.getParameter("m2");
		
		try
		{
			Connection conn=ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("insert into student_message values(?,?,?)");
			ps.setString(1,uname);
			ps.setString(2,sub);
			ps.setString(3,msg);
			
			int i=ps.executeUpdate();
			
			if(i==0)
			{
				out.println("Message sending failed!!.Try Again!!");
				RequestDispatcher rd=request.getRequestDispatcher("SendMessageStudent.jsp");
				rd.include(request,response);
				
			}
			else
			{
				out.println("Your Messsage is Successfully Sent !!");
				RequestDispatcher rd=request.getRequestDispatcher("SendMessageStudent.jsp");
				rd.include(request,response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
