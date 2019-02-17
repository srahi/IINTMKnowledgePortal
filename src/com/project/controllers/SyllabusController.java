package com.project.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
@WebServlet("/SyllabusController")
@MultipartConfig(maxFileSize = 16177215)   
public class SyllabusController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
	 private String dbUser = "system";
	 private String dbPass = "12345";
	 protected void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	        
	         
	    		String cs=request.getParameter("cs");
	    		String ss=request.getParameter("ss");
	    		String sd=request.getParameter("sylldetail");
	        InputStream inputStream = null; // input stream of the upload file
	         
	        // obtains the upload file part in this multipart request
	        System.out.println("before partfile");
	        Part filePart = request.getPart("photo");
	        System.out.println("after");
	        if (filePart != null) {
	            // prints out some information for debugging
	            System.out.println(filePart.getName());
	            System.out.println(filePart.getSize());
	            System.out.println(filePart.getContentType());
	             
	            // obtains input stream of the upload file
	            inputStream = filePart.getInputStream();
	        }
	         
	        Connection conn = null; // connection to the database
	        String message = null;  // message will be sent back to client
	         
	        try {
	            // connects to the database
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            
	            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
	            // constructs SQL statement
	            PreparedStatement statement = conn.prepareStatement("insert into syllabus_detail values(seq2.nextval,?,?,?,?)");
	            statement.setString(1,cs);
	            statement.setString(2,ss);
	             
	            if (inputStream != null) {
	                // fetches input stream of the upload file for the blob column
	                //statement.setBlob(2, inputStream,30000);
	                statement.setBinaryStream(3,inputStream,300000000);
	            }
	            statement.setString(4,sd);
	            // sends the statement to the database server
	            int row = statement.executeUpdate();
	            if (row > 0) {
	                message = "Syllabus Uploaded and saved into database";
	            }
	        } catch (SQLException ex) {
	            message = "ERROR: " + ex.getMessage();
	            ex.printStackTrace();
	        } catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
	            if (conn != null) {
	                // closes the database connection
	                try {
	                    conn.close();
	                } catch (SQLException ex) {
	                    ex.printStackTrace();
	                }
	            }
	            // sets the message in request scope
	            request.setAttribute("Message", message);
	             
	            // forwards to the message page
	            getServletContext().getRequestDispatcher("/Message.jsp").forward(request, response);
	        }
	    }
}
