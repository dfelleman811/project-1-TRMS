package dev.felleman.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.felleman.models.Request;
import dev.felleman.util.JDBCConnection;
import oracle.sql.DATE;

public class RequestRepoImpl implements RequestRepo {
	
	public Connection conn = JDBCConnection.getConnection();

	@Override
	public Request getRequest(int reqId) {
		
		try {
			
			String sql = "select * from requests where request_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(reqId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Request r = new Request();
				
				r.setRequestId(rs.getInt("request_id"));
				r.setSubmitDate(rs.getDate("submit_date"));
				r.setIsUrgent(rs.getInt("urgent"));
				r.setStatus(rs.getString("status"));
				r.setEmployeeId(rs.getInt("employee_id"));
				r.setDevResource(rs.getInt("development_resource"));
				
				return r;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllRequests() {
		
		List<Request> reqList = new ArrayList<Request>();
		
		try {
			
			String sql = "select * from requests order by last_updated desc nulls last";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				Request r = new Request();
				
				r.setRequestId(rs.getInt("request_id"));
				r.setSubmitDate(rs.getDate("submit_date"));
				r.setIsUrgent(rs.getInt("urgent"));
				r.setStatus(rs.getString("status"));
				r.setEmployeeId(rs.getInt("employee_id"));
				r.setDevResource(rs.getInt("development_resource"));
				
				reqList.add(r);
			}
			return reqList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllRequestsByEmployee(String email) {
		
		List<Request> reqList = new ArrayList<Request>();
		
		try {
		
			String sql = "select * from requests where email = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, email);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Request r = new Request();
				
				r.setRequestId(rs.getInt("request_id"));
				r.setSubmitDate(rs.getDate("submit_date"));
				r.setIsUrgent(rs.getInt("urgent"));
				r.setStatus(rs.getString("status"));
				r.setEmployeeId(rs.getInt("employee_id"));
				r.setDevResource(rs.getInt("development_resource"));
				
				reqList.add(r);
			}
			return reqList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Request> getAllRequestsByStatus(String status) {
		
		List<Request> reqList = new ArrayList<Request>();
		
		try {
		
			String sql = "select * from requests where status = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, status);
			
			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				Request r = new Request();
				
				r.setRequestId(rs.getInt("request_id"));
				r.setSubmitDate(rs.getDate("submit_date"));
				r.setIsUrgent(rs.getInt("urgent"));
				r.setStatus(rs.getString("status"));
				r.setEmployeeId(rs.getInt("employee_id"));
				r.setDevResource(rs.getInt("development_resource"));
				
				reqList.add(r);
			}
			return reqList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addRequest(int employeeId, int urgency) {
		
		try {
			
			String sql = "call add_request(?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(employeeId));
			cs.setString(2, Integer.toString(urgency));
			
			boolean success = cs.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateRequest(Request reqChange) { // do i set date here or in sql? Trying in sql to no avail...come back later TODO
		
		try {
			
			String sql = "update requests set urgent = ?, status = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(reqChange.getIsUrgent()));
			ps.setString(2, reqChange.getStatus());
		
			
			boolean success = ps.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteRequest(Request request) {
		
		try {
			
			String sql = "delete requests where request_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(request.getRequestId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
