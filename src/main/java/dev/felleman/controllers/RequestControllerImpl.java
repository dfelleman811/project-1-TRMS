package dev.felleman.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import dev.felleman.models.Employee;
import dev.felleman.models.Request;
import dev.felleman.services.RequestServices;
import dev.felleman.services.RequestServicesImpl;

public class RequestControllerImpl implements RequestController {
	
	private RequestServices rs = new RequestServicesImpl();
	private static Gson gson = new Gson();

	@Override
	public Request getRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		Request req = rs.getRequest(r.getRequestId());
		System.out.println(req);
		
		response.getWriter().append(gson.toJson(req));
		
		if (req != null) {
			return req;
		}else {
			return null;
		}
	}

	@Override
	public void getAllRequests(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		List<Request> reqList = rs.getAllRequests();
		
		response.getWriter().append(gson.toJson(reqList));
	}

	@Override
	public void getAllRequestsByEmployee(HttpServletRequest request, HttpServletResponse response, Employee e) throws IOException {
		int id = e.getEmployeeId();
		
		System.out.println(id);

		List<Request> reqList = rs.getAllRequestsByEmployee(id);
		System.out.println(reqList);
		
		response.getWriter().append(gson.toJson(reqList));
	}

	@Override
	public void getAllRequestsByStatus(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String input = request.getParameter("status");
		
		System.out.println(input);
		
		String status;
		
		try {
			status = input.toString();
		} catch (NumberFormatException e) {
			e.printStackTrace();
			response.sendError(400, "ID paramter incorrectly formatted.");
			return;
		}
		
		List<Request> reqList = rs.getAllRequestsByStatus(status);
		System.out.println(reqList);
		
		response.getWriter().append(gson.toJson(reqList));
	}
	
	@Override
	public void getAllRequestsByDept(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException {
		int superId = e.getEmployeeId();
		
		List<Request> reqList= rs.getAllDeptRequests(superId);
		
		response.getWriter().append(gson.toJson(reqList));
		
	}

	@Override
	public void addRequest(HttpServletRequest request, HttpServletResponse response, Employee e) throws JsonSyntaxException, JsonIOException, IOException {
		
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		rs.addRequest(e.getEmployeeId(), r.getIsUrgent());
		
		response.getWriter().append("Request Added");
		
	}

	@Override
	public void updateRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		rs.updateRequest(r);
		
		response.getWriter().append(gson.toJson(r));
	}

	@Override
	public void deleteRequest(HttpServletRequest request, HttpServletResponse response) throws JsonSyntaxException, JsonIOException, IOException {
		Request r = gson.fromJson(request.getReader(), Request.class);
		
		rs.deleteRequest(r);
		
		response.getWriter().append("Request Deleted");
		
	}

	

}
