package com.cmput660.mooddetect;

import java.io.IOException;
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
		doGet(request, response);
	}

}
