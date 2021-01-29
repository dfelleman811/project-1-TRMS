package dev.felleman.repositories;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dev.felleman.models.Employee;
import dev.felleman.util.JDBCConnection;

public class EmployeeRepositoryImpl implements EmployeeRepository {
	
	public static Connection conn = JDBCConnection.getConnection();

	
	
	@Override
	public Employee getEmployee(int employeeId) {
		
		try {
			
			String sql = "select * from employees where employee_id=?";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, Integer.toString(employeeId));
			
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				Employee e  = new Employee();
				
				e.setEmployeeId(rs.getInt("employee_id"));
				e.setFirstName(rs.getString("first_name"));
				e.setLastName(rs.getString("last_name"));
				e.setEmail(rs.getString("email"));
				e.setPassword(rs.getString("password"));
				e.setDepartmentId(rs.getInt("department_id"));
				e.setSupervisorId(rs.getInt("supervisor_id"));
				e.setAvailableReimbursement(rs.getInt("available_reimbursement"));
				
				return e;
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

		
		return null;
	}

	@Override
	public boolean addEmployee(Employee employee) {
		
		try {
			
			String sql = "call add_employee(?,?,?,?,?,?)";
			
			CallableStatement cs = conn.prepareCall(sql);
			
			cs.setString(1,employee.getFirstName());
			cs.setString(2, employee.getLastName());
			cs.setString(3, employee.getEmail());
			cs.setString(4,  employee.getPassword());
			cs.setString(5, Integer.toString(employee.getDepartmentId()));
			cs.setString(6, Integer.toString(employee.getAvailableReimbursement()));
			
			boolean success = cs.execute();
			
			return success;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// Empty list to populate with reulst set
		List<Employee> empList = new ArrayList<Employee>();
		
		try {
			
			String sql = "select * from employees";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateEmployee(Employee eChange) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return false;
	}

}
