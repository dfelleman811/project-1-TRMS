package dev.felleman.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * This Servlet instantiates a RequestManager in order to route service requests to the appropriate controller.
 * See dev.felleman.servlets.RequestManager for more details.
 * @author DanielFelleman
 *
 */
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RequestManager rm = new RequestManager();

	public MainServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		rm.process(request, response);
		


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		rm.process(request, response);
	}

}
