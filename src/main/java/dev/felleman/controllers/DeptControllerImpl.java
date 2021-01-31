package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.felleman.models.Department;
import dev.felleman.services.DepartmentServices;
import dev.felleman.services.DepartmentServicesImpl;

public class DeptControllerImpl implements DeptController {
	
	public DepartmentServices ds = new DepartmentServicesImpl();
	public Gson gson = new Gson();

	@Override
	public void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String input = request.getParameter("departmentId");
		
		int id;
		
		try {
			id = Integer.parseInt(input);
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID parameter improperly formatted.");
			return;
		}
		
		Department d = ds.getDepartment(id);
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");
		
	}

	@Override
	public void getDepartmentByName(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("departmentName");
		
		String name;
		
		try {
			name = input.toString();
			
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "Department Name parameter improperly formatted.");
			return;
		}
		
		Department d = ds.getDepartment(name);
		
		response.getWriter().append((d != null) ? gson.toJson(d) : "{}");

	}

	@Override
	public void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Department> deptList = ds.getAllDepartments();
		System.out.println(deptList);
		
		response.getWriter().append(gson.toJson(deptList));

	}

	@Override
	public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.addDepartment(d);
		
		response.getWriter().append(gson.toJson(d));

	}

	@Override
	public void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.updateDepartment(d);
		
		response.getWriter().append(gson.toJson(d));
	}

	@Override
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException {
		Department d = gson.fromJson(request.getReader(), Department.class);
		
		ds.deleteDepartment(d);
		
		response.getWriter().append("Department " + d.getDepartmentName() + " deleted.");

	}

}
