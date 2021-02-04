package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dev.felleman.models.Employee;
import dev.felleman.models.Reimbursement;
import dev.felleman.services.ReimbursementServices;
import dev.felleman.services.ReimbursementServicesImpl;

public class ReimbursementControllerImpl implements ReimbursementController {
	
	public Gson gson = new Gson();
	public ReimbursementServices rs = new ReimbursementServicesImpl();

	@Override
	public Reimbursement getReimbursement(HttpServletRequest request, HttpServletResponse response) {
		
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements(HttpServletRequest request, HttpServletResponse response) throws IOException {
		List<Reimbursement> allRems = rs.getAllReimbursements();
		
		response.getWriter().append(gson.toJson(allRems));
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByEmployee(HttpServletRequest request,
			HttpServletResponse response, Employee e) throws IOException {
		List<Reimbursement> remList = rs.getAllReimbursementsByEmployee(e.getEmployeeId());
		
		response.getWriter().append(gson.toJson(remList));
		return null;
	}

	@Override
	public boolean addReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteReimbursement(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		return false;
	}

}
