package dev.felleman.servlets;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dev.felleman.controllers.DeptController;
import dev.felleman.controllers.DeptControllerImpl;
import dev.felleman.controllers.DevResController;
import dev.felleman.controllers.DevResControllerImpl;
import dev.felleman.controllers.EmployeeController;
import dev.felleman.controllers.EmployeeControllerImpl;
import dev.felleman.controllers.RequestController;
import dev.felleman.controllers.RequestControllerImpl;
import dev.felleman.models.Employee;

/**
 * This class is to manage incoming requests and reroute them to the proper
 * controller
 * 
 * @author DanielFelleman
 *
 */
public class RequestManager {
	

	public EmployeeController ec = new EmployeeControllerImpl();
	public RequestController rc = new RequestControllerImpl();
	public DeptController dc = new DeptControllerImpl();
	public DevResController drs = new DevResControllerImpl();
	
	public void process(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

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
		
		case "/Project-1-TRMS/html/home.html": {
			System.out.println("home page now?");
			break;
		}

		case "/Project-1-TRMS/getEmployee.do": {
			System.out.println("get employee case");
			
			// check if params are empty or not - if empty look in request body for email
			if (request.getParameter("employeeId") == null) {
				Employee e = ec.getEmployeeByEmail(request, response);
				if (e != null) {
					//open session
					HttpSession session = request.getSession();
					session.setAttribute("loggedInUser", e);
					RequestDispatcher dis = request.getRequestDispatcher("/html/home.html");
					dis.forward(request, response);
				}else {
					response.sendError(400, "Email parameter improperly formatted.");
				}
			// else use the id in param
			} else {
				String emp = ec.getEmployee(request, response);
				response.getWriter().append(emp);
			}
			break;
		}

		case "/Project-1-TRMS/addEmployee.do": {
			System.out.println("add employee case");
			ec.addEmployee(request, response);
			break;
		}
		
		case "/Project-1-TRMS/updateEmployee.do": {
			System.out.println("update employee case");
			ec.updateEmployee(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getAllRequests.do": {
			System.out.println("get all requests case");
			rc.getAllRequests(request, response);
			break;
		}
		
		case "/Project-1-TRMS/addRequest.do": {
			System.out.println("adding request");
			rc.addRequest(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getDepartment.do": {
			System.out.println("getting department");
			dc.getDepartment(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getDepartmentByName.do": {
			System.out.println("getting department");
			if (request.getParameter("departmentName").equals("all")) {
				dc.getAllDepartments(request, response);
			}else {
				dc.getDepartmentByName(request, response);
			}
			break;
		}
		
		case "/Project-1-TRMS/getResource.do": {
			System.out.println("getting resource");
			drs.getResource(request, response);
			break;
		}
		
		case "/Project-1-TRMS/getAllResources.do": {
			System.out.println("getting resource");
			drs.getAllResources(request, response);
			break;
		}
		
		case "/Project-1-TRMS/addResource.do": {
			System.out.println("adding resource");
			drs.addDevelopmentResource(request, response);
			break;
		}
		default: {
			response.sendError(418, "Reached Default Case - TEATIME!");
			break;
		}
		}

	}
}
