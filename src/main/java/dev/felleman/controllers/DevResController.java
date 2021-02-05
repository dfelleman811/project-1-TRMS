package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.felleman.models.DevelopmentResource;

public interface DevResController {
	
	public DevelopmentResource getResource(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllResources(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void getAllResourcesByType(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void addDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void updateDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public boolean updateDevelopmentResourceGrade(HttpServletRequest request, HttpServletResponse response) throws IOException;
	
	public void deleteDevelopmentResource(HttpServletRequest request, HttpServletResponse response) throws IOException;


}
