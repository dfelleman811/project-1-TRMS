package dev.felleman.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public MainServlet() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// To make sure request is happening correctly
		response.getWriter().append("Served at Main Servlet. Response Status: " + response.getStatus());
		System.out.println("Served at Main Servlet. Response Status: " + response.getStatus());
		
		// Switch for URIs
		
		// Get Request URI
		String uri = request.getRequestURI();
		
		switch (uri) {
		
		
		default: {
			response.sendError(418);
			break;
		}
		}
		
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
