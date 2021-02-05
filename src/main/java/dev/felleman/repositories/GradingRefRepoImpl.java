package dev.felleman.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.felleman.models.GradingReference;
import dev.felleman.util.JDBCConnection;

public class GradingRefRepoImpl implements GradingRefRepo {
	
	Connection conn = JDBCConnection.getConnection();

	@Override
	public GradingReference getGradingReference(int gradeId) {
		
		try {
			
			String sql = "select * from grading_references where grade_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(gradeId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				GradingReference gr = new GradingReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				return gr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public GradingReference getGradeRefByGrade(String grade) {
		
			try {
			
			String sql = "select * from grading_references where grade = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, grade);
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				GradingReference gr = new GradingReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				return gr;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	@Override
	public List<GradingReference> getAllGradingReferences() {
		List<GradingReference> grList = new ArrayList<GradingReference>();
		try {
			
			String sql = "select * from grading_references";
			
			PreparedStatement ps = conn.prepareStatement(sql);
	
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				GradingReference gr = new GradingReference();
				
				gr.setGradeId(rs.getInt("grade_id"));
				gr.setGrade(rs.getString("grade"));
				gr.setPassing(rs.getInt("passing"));
				gr.setGradeFormat(rs.getString("grade_format"));
				
				grList.add(gr);
			}
			return grList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean addGradingReference(GradingReference r) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateGradingReference(GradingReference rChange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteGradingReference(GradingReference r) {
		// TODO Auto-generated method stub
		return false;
	}


	

}
