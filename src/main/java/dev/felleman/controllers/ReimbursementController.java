package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.felleman.models.Employee;
import dev.felleman.models.Reimbursement;

public interface ReimbursementController {
	
	public Reimbursement getReimbursement(HttpServletRequest request, HttpServletResponse response);
	
	public List<Reimbursement> getAllReimbursements(HttpServletRequest request, HttpServletResponse response);
	
	public List<Reimbursement> getAllReimbursementsByEmployee(HttpServletRequest request, HttpServletResponse response, Employee e) throws IOException;
	
	public boolean addReimbursement(HttpServletRequest request, HttpServletResponse response);
	
	public boolean updateReimbursement(HttpServletRequest request, HttpServletResponse response);
	
	public boolean deleteReimbursement(HttpServletRequest request, HttpServletResponse response);

}
