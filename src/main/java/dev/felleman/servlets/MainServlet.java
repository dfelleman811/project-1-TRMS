package dev.felleman.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestManager rm = new RequestManager();

	public MainServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		// Open/get session
//		HttpSession session = request.getSession();
//		
//		System.out.println(session.getId());
//	
//		
//		System.out.println(session.getMaxInactiveInterval());
//		
		
		// Implement RequestManager to route requests
		rm.process(request, response);
		
//		System.out.println(session.setAttribute("employeeId"));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		rm.process(request, response);
	}

}
