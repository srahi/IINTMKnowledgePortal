package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.models.UserModel;
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		
		String s1=request.getParameter("t1");
		String s2=request.getParameter("t2");
		String course=null;
		String semester=null;	
		
		UserModel obj=new UserModel();
		obj.setUn(s1);
		obj.setUp(s2);
		HttpSession session=request.getSession();
		session.setAttribute("uname",s1);
		session.setAttribute("pass",s2);
		
		
				String result[]=obj.login();
				if((s1.equals("admin"))&&(s2.equals(result[2])))
				{
					
					
					System.out.println("Logined user is an admin : "+s1+" "+s2);
				
					if(result[0].equals("success"))
					{
											
						session.setAttribute("user",result[1]);
						RequestDispatcher rd=request.getRequestDispatcher("CheckImageStatus");
						rd.forward(request,response);
						
					}
					else
					{
						out.println("<script type='text/javascript'>");  
						out.println("alert('Invalid Username or Password!!Try again..!');");  
						out.println("</script>"); 
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						rd.include(request,response);
					}
				}
				if((s1.equals("faculty"))&&(s2.equals(result[2])))
				{
					if(result[0].equals("success"))
					{
						
						session.setAttribute("user",result[1]);
						RequestDispatcher rd=request.getRequestDispatcher("CheckImageStatusFaculty");
						rd.forward(request,response);
					}
					else
					{
						out.println("<script type='text/javascript'>");  
						out.println("alert('Invalid Username or Password!!Try again..!');");  
						out.println("</script>"); 
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						rd.include(request,response);
					}
				}
				else
				{
					if(result[0].equals("success"))
					{
						
						try{
						Connection conn=ConnectionProvider.getConn();
						PreparedStatement ps=conn.prepareStatement("select * from course_detail where username=?");
						ps.setString(1,s1);
						ResultSet rs=ps.executeQuery();
						while(rs.next())
						{
							course=rs.getString(2);
							semester=rs.getString(5);
							session.setAttribute("course",course);
							session.setAttribute("semester",semester);
						}
						}catch(Exception e)
						{
							out.println("The Student does not have course detail..Therefore some features may not work properly...Please fill the course details");
							
						}
						session.setAttribute("user",result[1]);
						RequestDispatcher rd=request.getRequestDispatcher("CheckImageStatusStu");
						rd.forward(request,response);
					}
					else
					{
						out.println("<script type='text/javascript'>");  
						out.println("alert('Invalid Username or Password!!Try again..!');");  
						out.println("</script>"); 
						RequestDispatcher rd=request.getRequestDispatcher("login.jsp");
						rd.include(request,response);
					}
				}
				
				
			

	}

}
