package dev.felleman.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.felleman.models.DevelopmentResource;
import dev.felleman.util.JDBCConnection;
import oracle.sql.DATE;

public class DevResRepoImpl implements DevResRepo {
	
	public Connection conn = JDBCConnection.getConnection();

	@Override
	public DevelopmentResource getResource(int rId) {
		
		try {
			
			String sql = "select * from development_resources where resource_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(rId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				DevelopmentResource d = new DevelopmentResource();
				
				d.setResourceId(rs.getInt("resource_id"));
				d.setStartDate(rs.getString("start_date"));
				d.setResourceTime(rs.getString("resource_time"));
				d.setResourceLocation(rs.getString("resource_location"));
				d.setResourceCost(rs.getInt("resource_cost"));
				d.setGradingFormat(rs.getString("grading_format"));
				d.setResourceType(rs.getString("res_type"));
				d.setResourceDescription(rs.getString("res_description"));
				d.setResourceJustification(rs.getString("justification"));
				
				return d;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DevelopmentResource> getAllResources() {
		
		List<DevelopmentResource> resList = new ArrayList<DevelopmentResource>();
		
		try {
			
			String sql = "select * from development_resources";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				DevelopmentResource d = new DevelopmentResource();
				
				d.setResourceId(rs.getInt("resource_id"));
				d.setStartDate(rs.getString("start_date"));
				d.setResourceTime(rs.getString("resource_time"));
				d.setResourceLocation(rs.getString("resource_location"));
				d.setResourceCost(rs.getInt("resource_cost"));
				d.setGradingFormat(rs.getString("grading_format_"));
				d.setResourceType(rs.getString("res_type"));
				d.setResourceDescription(rs.getString("res_description"));
				d.setResourceJustification(rs.getString("justification"));
				
				resList.add(d);
			}
			return resList;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<DevelopmentResource> getAllResourcesByType(String type) {
	
		List<DevelopmentResource> resList = new ArrayList<DevelopmentResource>();
		
		try {
			
			String sql = "select * from development_resources where status = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, type);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				DevelopmentResource d = new DevelopmentResource();
				
				d.setResourceId(rs.getInt("resource_id"));
				d.setStartDate(rs.getString("start_date"));
				d.setResourceTime(rs.getString("resource_time"));
				d.setResourceLocation(rs.getString("resource_location"));
				d.setResourceCost(rs.getInt("resource_cost"));
				d.setGradingFormat(rs.getString("grading_format"));
				d.setResourceType(rs.getString("res_type"));
				d.setResourceDescription(rs.getString("res_description"));
				d.setResourceJustification(rs.getString("justification"));
				
				resList.add(d);
			}
			return resList;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addDevelopmentResource(DevelopmentResource r) {
		
		try {
			
			String sql = "call add_dev_resource(?, ?, ?, ?, ?, ?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, r.getStartDate());
			cs.setString(2, r.getResourceTime());
			cs.setString(3, r.getResourceLocation());
			cs.setString(4, Integer.toString(r.getResourceCost()));
			cs.setString(5, r.getGradingFormat());
			cs.setString(6, r.getResourceType());
			cs.setString(7, r.getResourceDescription());
			cs.setString(8, r.getResourceJustification());
			
			boolean success = cs.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updateDevelopmentResource(DevelopmentResource r) {
		
		try {
			
			String sql = "update development_resources set start_date = ?, resource_time = ?, resource_location = ?, resource_cost = ?, grading_format = ?, res_type = ?, res_description = ?, justification = ?, final_grade = ? where resource_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, r.getStartDate().toString());
			ps.setString(2, r.getResourceTime().toString());
			ps.setString(3, r.getResourceLocation());
			ps.setString(4, Integer.toString(r.getResourceCost()));
			ps.setString(5, r.getGradingFormat());
			ps.setString(6, r.getResourceType());
			ps.setString(7, r.getResourceDescription());
			ps.setString(8, r.getResourceJustification());
			ps.setString(9, Integer.toString(r.getFinalGrade()));
			ps.setString(10, Integer.toString(r.getResourceId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public boolean updateDevelopmentResourceGrade(DevelopmentResource r) {
		
		try {
			
			String sql = "update development_resources set final_grade = ? where resource_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(r.getFinalGrade()));
			ps.setString(2, Integer.toString(r.getResourceId()));
			
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteDevelopmentResource(DevelopmentResource r) {
		
		try {
			
			String sql = "delete development_resources where resource_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(r.getResourceId()));
			
			boolean success = ps.execute();
			
			return success;
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
