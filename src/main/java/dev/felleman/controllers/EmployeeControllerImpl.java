package dev.felleman.controllers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.felleman.models.Employee;
import dev.felleman.services.EmployeeServices;
import dev.felleman.services.EmployeeServicesImpl;


/**
 * Implements the EmployeeController Interface.
 * 
 * This Controller class is used to call the Service Layer to retrieve, add, update, or delete Employees from the Database.
 * @author DanielFelleman
 *
 */
public class EmployeeControllerImpl implements EmployeeController {

	private EmployeeServices es = new EmployeeServicesImpl();
	private static Gson gson = new Gson();

	@Override
	public Employee getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("employeeId");

		System.out.println(input);
		int id;

		try {
			id = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return null;
		}

		Employee e = es.getEmployee(id);
		System.out.println(e);
		
		if (e != null) {
			return e;
		} else {
			return null;
		}

	}
	
	@Override
	public Employee getEmployeeByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		//System.out.println(gson.fromJson(request.getReader(), Employee.class));
		Employee emp = gson.fromJson(request.getReader(), Employee.class);
		
		String email = emp.getEmail();
		String password = emp.getPassword();
		
		System.out.println(email);
		System.out.println(password);
		
		Employee e = es.getEmployee(email);
		
		if (e.getPassword().equals(password)) {
			return e;
		}else {
			return null;
		}


	}

	@Override
	public void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException {
		// Retrieve info being sent in body (employee object(
		Employee e = gson.fromJson(request.getReader(), Employee.class);

		es.addEmployee(e);

		response.getWriter().append(gson.toJson(e));

	}

	@Override
	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		// Retrieve info being sent in body
		Employee e = gson.fromJson(request.getReader(), Employee.class);
		
		es.updateEmployee(e);
		
		response.getWriter().append(gson.toJson(e));

	}

	@Override
	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Employee e = gson.fromJson(request.getReader(), Employee.class);
		
		es.deleteEmployee(e);
		
		response.getWriter().append("Employee Deleted");

	}

}
