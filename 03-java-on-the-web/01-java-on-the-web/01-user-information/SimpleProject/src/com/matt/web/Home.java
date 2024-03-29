package com.matt.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Home
 */
@WebServlet("/Home")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Home() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("name");
        String homeTown = request.getParameter("city");
        String language = request.getParameter("lang");
		response.setContentType("text/html");
        // writes the response
        PrintWriter out = response.getWriter();
        if (userName == null) {
        	userName = "Unknown";
        }
        if (homeTown == null) {
        	homeTown = "Unkown";
        }
        if (language == null) {
        	language = "Unkown";
        }
        out.write("<h1>Welcome " + userName + "</h1><br><br>Your favorite language is: " + language + "<br>Your hometown is: " + homeTown);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
