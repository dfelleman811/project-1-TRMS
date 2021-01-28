package dev.felleman.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
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
