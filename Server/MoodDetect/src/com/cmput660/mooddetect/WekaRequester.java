package com.cmput660.mooddetect;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import weka.core.Instances;
import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Servlet implementation class WekaRequester
 */
@WebServlet("/WekaRequester")
public class WekaRequester extends HttpServlet {
	
	static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://127.0.0.1:3306/moodstore";
//  Database credentials
    static final String USER = "root";
    static final String PASS = "cmput660";
    
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WekaRequester() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String hr = request.getParameter("hr");
		int hrvalue = Integer.parseInt(hr);
		
		// by logistic regression model, the following weights have been obtained from WEKA.
		//to be updated with Random forest model, once individual data is obtained.
		float mood= (float) ((hrvalue * -0.0064) +  1.7377) ;
		if(mood>=1) {
			response.getWriter().append("Positive");
		}
		else {
			response.getWriter().append("Negative");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		 try {
			 
			 String uname = request.getParameter("USER_NAME");
			 String hr = request.getParameter("HEART_RATE");
			 String detect = request.getParameter("DETECTED");
			 String humid = request.getParameter("HUMID");
			 String temp = request.getParameter("TEMP");
			 String cloud = request.getParameter("CLOUD");
			 String pressure =  request.getParameter("PRESS");
			 String wind = request.getParameter("WIND");
			 String gt = request.getParameter("GT");
	         // Register JDBC driver
			 
	         Class.forName("com.mysql.jdbc.Driver");

	         // Open a connection
	         Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

	         // Execute SQL query
	         Statement stmt = conn.createStatement();
	         String sql;
	         sql = "INSERT INTO moodcollect(userid,heartrate,detected,humidity,temperature,cloudiness,pressure,windiness, groundtruth) VALUES ('"+uname+"',"+hr+",'"+detect+"',"+humid+","+temp+","+cloud+","+pressure+","+wind+",'"+gt+"')";
	         stmt.executeUpdate(sql);
		 }
		 catch(Exception e) {
			 response.getWriter().append(""+e);
		 }
		response.getWriter().append("Thank you for the Feedback");
	}

}
