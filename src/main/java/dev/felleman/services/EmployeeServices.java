package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Employee;

public interface EmployeeServices {
	
	public Employee getEmployee(int employeeId);
	
	public Employee addEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public boolean updateEmployee(Employee eChange);
	
	public boolean deleteEmployee(Employee employee);
	
	

}
