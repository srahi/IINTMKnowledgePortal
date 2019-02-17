package com.project.controllers;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 



import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
 
@WebServlet("/RuleBookController")
@MultipartConfig(maxFileSize = 16177215)    // upload file's size up to 16MB
public class RuleBookController extends HttpServlet {
     
    private String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
    private String dbUser = "system";
    private String dbPass = "12345";
     
    protected void service(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
    		HttpSession session=request.getSession();
    		String name=(String)session.getAttribute("uname");
         
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
 
           
            		System.out.println(name);
            		// constructs SQL statement
            		String sql = "insert into rule_table values(seq4.nextVal,?)";
            		PreparedStatement statement = conn.prepareStatement(sql);
             
             
            		if (inputStream != null) {
            		// fetches input stream of the upload file for the blob column
            		//statement.setBlob(2, inputStream,30000);
            			statement.setBinaryStream(1,inputStream,300000000);
            		}
 
            		// sends the statement to the database server
            		int row = statement.executeUpdate();
            		if (row > 0) {
            			message = "Rule Book Uploaded and saved into database";
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