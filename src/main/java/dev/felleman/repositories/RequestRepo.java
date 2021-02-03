package dev.felleman.repositories;

import java.util.List;

import dev.felleman.models.Request;

public interface RequestRepo {
	
	public Request getRequest(int reqId);
	
	public List<Request> getAllRequests();
	
	public List<Request> getAllRequestsByEmployee(int empId);
	
	public List<Request> getAllRequestsByStatus(String status);
	
	public boolean addRequest(int employeeId, int urgency);
	
	public boolean updateRequest(Request reqChange);
	
	public boolean deleteRequest(Request request);
}
