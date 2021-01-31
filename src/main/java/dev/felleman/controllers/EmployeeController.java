package dev.felleman.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public interface EmployeeController {

	public void getEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getEmployeeByEmail(HttpServletRequest request, HttpServletResponse response) throws IOException;

	public void addEmployee(HttpServletRequest request, HttpServletResponse response)
			throws JsonSyntaxException, JsonIOException, IOException;

	public void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException;

	public void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException;

}
