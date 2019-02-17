package com.project.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(name = "ShowSyllabusAdmin", urlPatterns = { "/ShowSyllabusAdmin" })
public class ShowSyllabusFaculty extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
	    final String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
	    final String User = "system";
	    final String Password = "12345";
	    
	    String id=(String)request.getParameter("id");
	    try {
	        Class.forName(JDBC_DRIVER);
	        Connection conn = DriverManager.getConnection(DB_URL, User, Password);

	        PreparedStatement stmt = conn.prepareStatement("select photo from syllabus_detail where contact_id=?");
	        stmt.setString(1,id);
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
