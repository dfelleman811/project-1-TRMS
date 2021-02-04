package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Reimbursement;


public interface ReimbursementServices {
	
	public Reimbursement getReimbursement(int remId);
	
	public List<Reimbursement> getAllReimbursements();
	
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId);
	
	public boolean addReimbursement(Reimbursement r);
	
	public boolean updateReimbursement(Reimbursement rChange);
	
	public boolean deleteReimbursement(Reimbursement r);

}
