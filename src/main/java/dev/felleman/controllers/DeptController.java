package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.felleman.models.Department;

public interface DeptController {
	
	public void getDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getDepartmentByName(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllDepartments(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void addDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteDepartment(HttpServletRequest request, HttpServletResponse response) throws IOException;

}
