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

@WebServlet("/timeupload")
@MultipartConfig(maxFileSize = 16177215)
public class timeupload extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUser = "system";
    private String dbPass = "12345";
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String cs=request.getParameter("cs");
		String ss=request.getParameter("ss");
		String timedetail=request.getParameter("timedetail");
     
    InputStream inputStream = null; // input stream of the upload file
     
    // obtains the upload file part in this multipart request
    Part filePart = request.getPart("photo");
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
        String sql = "insert into time_table values(seq3.nextval,?,?,?,?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1,cs);
        statement.setString(2,ss);
        statement.setString(3,timedetail);
  
         
        if (inputStream != null) {
            // fetches input stream of the upload file for the blob column
            //statement.setBlob(2, inputStream,30000);
            statement.setBinaryStream(4,inputStream,300000000);
        }

        // sends the statement to the database server
        int row = statement.executeUpdate();
        if (row > 0) {
            message = "Time Table Uploaded and saved into database";
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
