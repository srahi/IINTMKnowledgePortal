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
@WebServlet("/ResultFacultyController")
public class ResultFacultyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
		protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html");
			PrintWriter out=response.getWriter();
			
			String s1=request.getParameter("tn");
			String s2=request.getParameter("ts");
			String s3=request.getParameter("tc");
			String s4=request.getParameter("ti");
			String s5=request.getParameter("te");
			String s6=request.getParameter("tt");
			
			UserModel obj=new UserModel();
			obj.setUn(s1);
			obj.setTs(s2);
			obj.setTc(s3);
			obj.setTi(s4);
			obj.setTe(s5);
			obj.setTt(s6);
			String result=obj.uploadResult();
				if(result.equals("success"))
				{
					out.println("Result of Student "+s1+" has been uploaded to Knowledge portal!!");
					RequestDispatcher rd=request.getRequestDispatcher("facultyupdateresult.jsp");
					rd.include(request,response);
				}
				if(result.equals("failed"))
				{
					out.println("Result  "+s1+" Failed to upload!! Try again...");
					RequestDispatcher rd=request.getRequestDispatcher("facultyupdateresult.jsp");
					rd.include(request,response);
				}
				if(result.equals("failed1"))
				{
					out.println("Result  already uploaded.Try modify result...");
				
				}
				if(result.equals("failed2"))
				{
					out.println("Oops...Either the course for the selected username is wrong or the course details are not filled for selected username.");
					
				}
	}

}
