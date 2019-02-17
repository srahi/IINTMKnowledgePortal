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

@WebServlet("/CheckImageStatus")
public class CheckImageStatus extends HttpServlet {

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

	RequestDispatcher rd=request.getRequestDispatcher("homepageadmin.jsp");
	rd.forward(request,response);
	
	
	
	
	}
	catch(Exception e){e.printStackTrace();}
	}
}
