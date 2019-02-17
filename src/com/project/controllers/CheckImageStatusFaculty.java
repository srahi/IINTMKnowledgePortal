package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/CheckImageStatusFaculty")
public class CheckImageStatusFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		try{
	
		HttpSession session=request.getSession();
		String uname=(String)session.getAttribute("uname");
		
	Connection conn=ConnectionProvider.getConn();
	PreparedStatement ps=conn.prepareStatement("select flag from userdp where username=?");
	ps.setString(1,uname);
	ResultSet rs=ps.executeQuery();
if(rs.next()){
		
		
	if(rs.getInt("flag")==1){

	request.setAttribute("image","available");}
	else{
	
		request.setAttribute("image","not available");}	
	}
else
{
	
	PreparedStatement ps1=conn.prepareStatement("insert into userdp(username) values(?)");
	ps1.setString(1,uname);
	ps1.executeUpdate();
	
	PreparedStatement ps2=conn.prepareStatement("select flag from userdp where username=?");
	ps2.setString(1,uname);
	ResultSet rs1=ps2.executeQuery();
	System.out.println("inside the else");
	if(rs1.next())
	{	
		System.out.println("inside the rs.next");
		if(rs1.getInt("flag")==1)
		{
			request.setAttribute("image","available");
		}
		else
		{	
			request.setAttribute("image","not available");
		}
		RequestDispatcher rd=request.getRequestDispatcher("homepagefaculty.jsp");
		rd.forward(request,response);
	}
}

	RequestDispatcher rd=request.getRequestDispatcher("homepagefaculty.jsp");
	rd.forward(request,response);
	
	
	
	
	}
	catch(Exception e){e.printStackTrace();}
	}
	}

