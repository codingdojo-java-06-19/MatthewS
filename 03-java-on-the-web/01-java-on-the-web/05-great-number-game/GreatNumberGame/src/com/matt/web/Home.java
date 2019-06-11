package com.matt.web;

import java.io.IOException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		Random rand = new Random();
		int random = rand.nextInt(101);
		
		HttpSession session = request.getSession();
		if (session.getAttribute("num")== null) {
			session.setAttribute("num", random);
		}
	
		System.out.println(session.getAttribute("num"));
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/index.jsp");
        view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String takeaguess = request.getParameter("num");
		int guess = Integer.parseInt(takeaguess);
		int number = (int)session.getAttribute("num");
		if (number < guess) {
			String result = "high";
			session.setAttribute("result", result);
		}else if (number > guess) {
			String result = "low";
			session.setAttribute("result", result);
		} else {
			String result = "correct";
			session.setAttribute("result", result);
		}
		response.sendRedirect("/GreatNumberGame/Home");
	}
	

}
