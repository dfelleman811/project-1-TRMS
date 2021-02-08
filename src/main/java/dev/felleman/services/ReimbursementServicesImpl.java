package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Reimbursement;
import dev.felleman.repositories.ReimbursementRepo;
import dev.felleman.repositories.ReimbursementRepoImpl;

/**
 * Implements ReimbursementServices Interface.
 * 
 * This Service Implementation calls the Repository Layer in order to retrieve, add, update, or delete Reimbursements in the Database.
 * @author DanielFelleman
 *
 */
public class ReimbursementServicesImpl implements ReimbursementServices {
	
	public ReimbursementRepo rr = new ReimbursementRepoImpl();

	@Override
	public Reimbursement getReimbursement(int paymentId) {
		return rr.getReimbursement(paymentId);
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
		return rr.getAllReimbursements();
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId) {
		return rr.getAllReimbursementsByEmployee(empId);
	}

	@Override
	public boolean addReimbursement(Reimbursement r) {
		return rr.addReimbursement(r);
	}

	@Override
	public boolean updateReimbursement(Reimbursement reqChange) {
		return rr.updateReimbursement(reqChange);
	}

	@Override
	public boolean deleteReimbursement(Reimbursement request) {
		return rr.deleteReimbursement(request);
	}

}
