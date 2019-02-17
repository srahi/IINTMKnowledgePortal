package com.project.controllers;
import java.sql.*;
public class ConnectionProvider {

	private ConnectionProvider(){}
    private static Connection conn=null;
    public static Connection getConn()
    {
    	try
    	{
    		Class.forName("oracle.jdbc.driver.OracleDriver");
    		System.out.println("Driver Loaded.........");
    		conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","12345");
    		System.out.println("Connection Created....");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}
    	return conn;
    }
    
}
