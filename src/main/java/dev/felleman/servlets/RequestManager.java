package dev.felleman.servlets;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.felleman.controllers.DeptController;
import dev.felleman.controllers.DeptControllerImpl;
import dev.felleman.controllers.DevResController;
import dev.felleman.controllers.DevResControllerImpl;
import dev.felleman.controllers.EmployeeController;
import dev.felleman.controllers.EmployeeControllerImpl;
import dev.felleman.controllers.RequestController;
import dev.felleman.controllers.RequestControllerImpl;

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
			if (request.getParameter("employeeId") == null) {
				ec.getEmployeeByEmail(request, response);
			} else {
			ec.getEmployee(request, response);
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
