package dev.felleman.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.felleman.controllers.EmployeeController;
import dev.felleman.controllers.EmployeeControllerImpl;

/**
 * This class is to manage incoming requests and reroute them to the proper controller
 * 
 * @author DanielFelleman
 *
 */
public class RequestManager {

	public EmployeeController ec = new EmployeeControllerImpl();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		
		// Get the uri from the request
		String uri = request.getRequestURI();
		
		// confirm
		System.out.println(uri);
		

		// Send to appropriate controller
		switch (uri) {
		
		case "/Project-1-TRMS/test.do": {
			response.getWriter().append("Test Worked!");
			break;
		}
		
		case "/Project-1-TRMS/getEmployee.do": {
			System.out.println("get employee case");
			ec.getEmployee(request, response);
			break;
		}
		
		case "/Project-1-TRMS/addEmployee.do": {
			System.out.println("add employee case");
			ec.addEmployee(request, response);
			break;
		}
		default: {
			response.sendError(418, "Reached Default Case - TEATIME!");
			break;
		}
		}
		
		
	}
}
