package dev.felleman.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.felleman.models.GradingReference;
import dev.felleman.services.GradeRefServices;
import dev.felleman.services.GradeRefServicesImpl;


/**
 * Implements the GradeRefController Interface.
 * 
 * This Controller Class is used to call the Service Layer in order to retrieve Grading References from the Database.
 * In order to add, update, or delete Grading References from the Database, you will need to implement those methods. 
 * 
 * @author DanielFelleman
 *
 */
public class GradeRefControllerImpl implements GradeRefController {
	
	public GradeRefServices grs = new GradeRefServicesImpl();
	public Gson gson = new Gson();

	@Override
	public GradingReference getGradingReference(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		return null;
	}

	public GradingReference getGradeRefByGrade(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String grade = gson.fromJson(request.getReader(), String.class);
	
		
		GradingReference gR = grs.getGradeRefByGrade(grade);
		
		response.getWriter().append(gson.toJson(gR));
		
		return gR;
		
	}
	@Override
	public void getAllGradingReference(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

	}

}
