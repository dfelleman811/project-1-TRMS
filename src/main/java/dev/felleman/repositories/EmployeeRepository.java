package dev.felleman.repositories;

import java.util.List;

import dev.felleman.models.Employee;

public interface EmployeeRepository {
	
	public Employee getEmployee(int employeeId);
	public boolean addEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public boolean updateEmployee(Employee eChange);
	public boolean deleteEmployee(Employee employee);
}
