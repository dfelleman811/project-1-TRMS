package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.felleman.models.Employee;
import dev.felleman.models.Request;

public interface RequestController {
	
	public void getRequest(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllRequestsByEmployee(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllRequestsByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void addRequest(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException;
	
	public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException;
	
	public void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException;

}
