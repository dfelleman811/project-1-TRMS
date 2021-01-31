package dev.felleman.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.felleman.models.Employee;
import dev.felleman.services.EmployeeServices;
import dev.felleman.services.EmployeeServicesImpl;

public class EmployeeControllerImpl implements EmployeeController {

	private EmployeeServices es = new EmployeeServicesImpl();
	private static Gson gson = new Gson();

	@Override
	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String input = request.getParameter("employeeId");

		System.out.println(input);
		int id;

		try {
			id = Integer.parseInt(input);

		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter incorrectly formatted.");
			return;
		}

		Employee e = es.getEmployee(id);
		System.out.println(e);

		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");

	}
	
	@Override
	public void getEmployeeByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String email = gson.fromJson(request.getReader(), Employee.class).getEmail();

		Employee e = es.getEmployee(email);
		
		System.out.println(e);

		response.getWriter().append((e != null) ? gson.toJson(e) : "{}");

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
