package dev.felleman.repositories;

import java.util.List;

import dev.felleman.models.Reimbursement;


public interface ReimbursementRepo {
	
	public Reimbursement getReimbursement(int paymentId);
	
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId);
	
	public List<Reimbursement> getAllReimbursements();
	
	public boolean addReimbursement(Reimbursement r);
	
	public boolean updateReimbursement(Reimbursement rChange);
	
	public boolean deleteReimbursement(Reimbursement r);

}
