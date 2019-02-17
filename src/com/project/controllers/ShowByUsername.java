package com.project.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ShowByUsername")
public class ShowByUsername extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String s1=request.getParameter("t1");
		
		try{
			out.println("Student details Found");
			Connection conn = ConnectionProvider.getConn();
			PreparedStatement ps=conn.prepareStatement("select * from login_table where username like '%"+s1+"%'");
	
			ResultSet rs=ps.executeQuery();
			
		
			
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>PASSWORD</th>");
			out.println("<th>FIRST NAME</th>");
			out.println("<th>LAST NAME</th>");
			out.println("</tr>");
			
			while(rs.next()){
				out.println("<tr>");
				out.println("<td>"+rs.getString(1)+"</td>");
				out.println("<td>"+rs.getString(2)+"</td>");
				out.println("<td>"+rs.getString(3)+"</td>");
				out.println("<td>"+rs.getString(4)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Student Course details Found");

			PreparedStatement ps2=conn.prepareStatement("select * from course_detail where username like '%"+s1+"%'");
			
			ResultSet rs2=ps2.executeQuery();
			
		
			
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>RANK</th>");
			out.println("<th>STATUS</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>BATCH</th>");
			out.println("<th>REGISTRATION DATE</th>");
			out.println("<th>VALID UPTO</th>");
			out.println("</tr>");
			
			while(rs2.next()){
				out.println("<tr>");
				out.println("<td>"+rs2.getString(1)+"</td>");
				out.println("<td>"+rs2.getString(2)+"</td>");
				out.println("<td>"+rs2.getInt(3)+"</td>");
				out.println("<td>"+rs2.getString(4)+"</td>");
				out.println("<td>"+rs2.getString(5)+"</td>");
				out.println("<td>"+rs2.getString(6)+"</td>");
				out.println("<td>"+rs2.getString(7)+"</td>");
				out.println("<td>"+rs2.getString(8)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Student Personal details Found");
			
			PreparedStatement ps3=conn.prepareStatement("select * from student_detail where username like '%"+s1+"%'");
			
			ResultSet rs3=ps3.executeQuery();
		
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>DATE OF BIRTH</th>");
			out.println("<th>GENDER</th>");
			out.println("<th>EMAIL</th>");
			out.println("<th>CONTACT NO</th>");
			out.println("<th>ADDRESS</th>");
			out.println("<th>CITY</th>");
			out.println("<th>STATE</th>");
			out.println("</tr>");
			
			while(rs3.next()){
				out.println("<tr>");
				out.println("<td>"+rs3.getString(1)+"</td>");
				out.println("<td>"+rs3.getString(2)+"</td>");
				out.println("<td>"+rs3.getString(3)+"</td>");
				out.println("<td>"+rs3.getString(4)+"</td>");
				out.println("<td>"+rs3.getString(5)+"</td>");
				out.println("<td>"+rs3.getString(6)+"</td>");
				out.println("<td>"+rs3.getString(7)+"</td>");
				out.println("<td>"+rs3.getString(8)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Attendance Found");
			
			PreparedStatement ps4=conn.prepareStatement("select * from attendance_detail where username like '%"+s1+"%'");
			
			ResultSet rs4=ps4.executeQuery();
			
		
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=3 id='customers' width='100%'>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>ATTENDANCE</th>");
			out.println("</tr>");
			
			while(rs4.next()){
				out.println("<tr>");
				out.println("<td>"+rs4.getString(1)+"</td>");
				out.println("<td>"+rs4.getString(2)+"</td>");
				out.println("<td>"+rs4.getString(3)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
		
			out.println("Result Found");
			
			PreparedStatement ps5=conn.prepareStatement("select * from result_table where username like '%"+s1+"%'");
			
			ResultSet rs5=ps5.executeQuery();
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=3 id='customers' width='100%'>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>SEMESTER</th>");
			out.println("<th>COURSE</th>");
			out.println("<th>INTERNAL MARKS</th>");
			out.println("<th>EXTERNAL MARKS</th>");
			out.println("<th>TOTAL MARKS</th>");
			out.println("</tr>");
			
			while(rs5.next()){
				out.println("<tr>");
				out.println("<td>"+rs5.getString(1)+"</td>");
				out.println("<td>"+rs5.getString(2)+"</td>");
				out.println("<td>"+rs5.getString(3)+"</td>");
				out.println("<td>"+rs5.getString(4)+"</td>");
				out.println("<td>"+rs5.getString(5)+"</td>");
				out.println("<td>"+rs5.getString(6)+"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			
			out.println("Messages Found");
			
			PreparedStatement ps6=conn.prepareStatement("select * from faculty_message where username like '%"+s1+"%'");
			
			ResultSet rs6=ps6.executeQuery();
			
			out.println("<body vlink='red'>");	
			out.println("<link href='table.css' type='text/css' rel='stylesheet'>");
			out.println("<table border=2 id='customers' width=100%>");
			out.println("<tr>");
			out.println("<th>USER NAME</th>");
			out.println("<th>Subject</th>");
			out.println("<th>Operations</th>");
			out.println("</tr>");
			
			while(rs6.next()){
				String i1 = rs6.getString(1);
				String i2 = rs6.getString(2);
				String i3 = rs6.getString(3);
				
				out.println("<tr>");
				out.println("<td>"+rs6.getString(1)+"</td>");
				out.println("<td>"+rs6.getString(2)+"</td>");
				out.println("<td><a onclick='this.style.color='red' href='ViewMessage?a1="+i1+"&a2="+i2+"&a3="+i3+"'</a>View</a></td>");	
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("</body>");
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}
