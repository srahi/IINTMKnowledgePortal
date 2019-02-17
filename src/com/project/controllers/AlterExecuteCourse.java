package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.controllers.ConnectionProvider;


@WebServlet("/AlterExecuteCourse")
public class AlterExecuteCourse extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		String uid=(String)session.getAttribute("uid");
		String uname = request.getParameter("uname");
		String course = request.getParameter("course");
		int rank=Integer.parseInt(request.getParameter("rank"));
		String status = request.getParameter("status");
		String semester = request.getParameter("semester");
		String batch = request.getParameter("batch");
		String rd = request.getParameter("rd");
		String vu = request.getParameter("vu");
		System.out.println(rank);
		try {
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps = conn.prepareStatement("update course_detail set username=? , course=?, rank=?, status=?, semester=?, batch=?, registrationdate=?, validupto=? where username=?");
			ps.setString(1,uname);
			ps.setString(2,course);
			ps.setInt(3,rank);
			ps.setString(4,status);
			ps.setString(5,semester);
			ps.setString(6,batch);
			ps.setString(7,rd);
			ps.setString(8,vu);
			ps.setString(9,uid);
			int check = ps.executeUpdate();
			if(check==0){
				out.println("Update Not Successfull");
			}
			else
			{
				out.println("Update Successfull ------ <a href='editCourse.jsp'>Click here to go back</a>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
