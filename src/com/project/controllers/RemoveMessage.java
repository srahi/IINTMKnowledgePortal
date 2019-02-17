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
@WebServlet("/RemoveMessage")
public class RemoveMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String id = request.getParameter("a1");
		String sub = request.getParameter("a2");
		String msg = request.getParameter("a3");
		
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("delete from faculty_message where username=? and subject=? and message=?");
			ps.setString(1, id);
			ps.setString(2, sub);
			ps.setString(3, msg);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				out.println("Message of id("+id+") Successfully deleted!!");
				RequestDispatcher rd=request.getRequestDispatcher("ShowMessageToAdmin");
				rd.include(request,response);
			}
			else
			{
				out.println("Message of id("+id+") failed to delete!!");
				RequestDispatcher rd=request.getRequestDispatcher("ShowMessageToAdmin");
				rd.include(request,response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
