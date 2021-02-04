package dev.felleman.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.felleman.models.Reimbursement;
import dev.felleman.util.JDBCConnection;

public class ReimbursementRepoImpl implements ReimbursementRepo {

	
	public Connection conn = JDBCConnection.getConnection();
	@Override
	public Reimbursement getReimbursement(int paymentId) {
		
		
		try {
			
			String sql = "select * from reimbursements where payment_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(paymentId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Reimbursement r = new Reimbursement();
				
				r.setPaymentId(rs.getInt("payment_id"));
				r.setAmount(rs.getInt("amount"));
				r.setEmpId(rs.getInt("emp_id"));
				r.setDevResId(rs.getInt("devres_id"));
				r.setReqId(rs.getInt("req_id"));
				
				return r;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursementsByEmployee(int empId) {
		List<Reimbursement> remList = new ArrayList<Reimbursement>();
		
		try {
			
			String sql = "select * from reimbursements where emp_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(empId));
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Reimbursement r = new Reimbursement();
				
				r.setPaymentId(rs.getInt("payment_id"));
				r.setAmount(rs.getInt("amount"));
				r.setEmpId(rs.getInt("emp_id"));
				r.setDevResId(rs.getInt("devres_id"));
				r.setReqId(rs.getInt("req_id"));
				
				remList.add(r);
				
			}
			
			return remList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Reimbursement> getAllReimbursements() {
List<Reimbursement> remList = new ArrayList<Reimbursement>();
		
		try {
			
			String sql = "select * from reimbursements";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				
				Reimbursement r = new Reimbursement();
				
				r.setPaymentId(rs.getInt("payment_id"));
				r.setAmount(rs.getInt("amount"));
				r.setEmpId(rs.getInt("emp_id"));
				r.setDevResId(rs.getInt("devres_id"));
				r.setReqId(rs.getInt("req_id"));
				
				remList.add(r);
				
			}
			
			return remList;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addReimbursement(Reimbursement r) {
		
		try {
			
			String sql = "call add_reimbursement(?, ?, ?, ?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1, Integer.toString(r.getAmount()));
			cs.setString(2, Integer.toString(r.getEmpId()));
			cs.setString(3, Integer.toString(r.getDevResId()));
			cs.setString(4, Integer.toString(r.getReqId()));
			
			boolean success = cs.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}

	@Override
	public boolean updateReimbursement(Reimbursement rChange) {
		
		try {
			
			String sql = "update reimbursements set amount = ?, emp_id = ?, devres_id = ?, req_id = ? where payment_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(rChange.getAmount()));
			ps.setString(2, Integer.toString(rChange.getEmpId()));
			ps.setString(3, Integer.toString(rChange.getDevResId()));
			ps.setString(4, Integer.toString(rChange.getReqId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public boolean deleteReimbursement(Reimbursement r) {
		
		try {
			
			String sql = "delete reimbursements where payment_id = ?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(r.getPaymentId()));
			
			boolean success = ps.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return false;

	}

}
