package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Request;
import dev.felleman.repositories.RequestRepo;
import dev.felleman.repositories.RequestRepoImpl;

public class RequestServicesImpl implements RequestServices {

	public RequestRepo rr = new RequestRepoImpl();

	@Override
	public Request getRequest(int reqId) {
		return rr.getRequest(reqId);
	}

	@Override
	public List<Request> getAllRequests() {
		return rr.getAllRequests();
	}

	@Override
	public List<Request> getAllRequestsByEmployee(String email) {
		return rr.getAllRequestsByEmployee(email);
	}

	@Override
	public List<Request> getAllRequestsByStatus(String status) {
		return rr.getAllRequestsByStatus(status);
	}

	@Override
	public boolean addRequest(int employeeId, int urgency) {
		return rr.addRequest(employeeId, urgency);
	}

	@Override
	public boolean updateRequest(Request reqChange) {
		return rr.updateRequest(reqChange);
	}

	@Override
	public boolean deleteRequest(Request request) {
		return rr.deleteRequest(request);
	}
	

}
