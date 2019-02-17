package com.project.controllers;
import java.sql.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/downloadstudent")
public class ShowStudyMaterialStudent extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	    final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    final String User = "system";
	    final String Password = "12345";
	    
	    HttpSession session=request.getSession();
	    String course=(String)session.getAttribute("course");
	    String semester=(String)session.getAttribute("semester");
	    try {
	        Class.forName(JDBC_DRIVER);
	        Connection conn = DriverManager.getConnection(DB_URL, User, Password);

	        PreparedStatement stmt = conn.prepareStatement("select photo from study_table where contact_id=? and course=? and semester=?");
	        stmt.setInt(1,Integer.valueOf(request.getParameter("id")));
	        stmt.setString(2,course);
	        stmt.setString(3,semester);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            response.getOutputStream().write(rs.getBytes("photo"));
	        }
	        conn.close();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	}


}
