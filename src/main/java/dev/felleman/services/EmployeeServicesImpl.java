package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Employee;
import dev.felleman.repositories.EmployeeRepository;
import dev.felleman.repositories.EmployeeRepositoryImpl;

public class EmployeeServicesImpl implements EmployeeServices {

	private EmployeeRepository er = new EmployeeRepositoryImpl();

	@Override
	public Employee getEmployee(int employeeId) {
		return er.getEmployee(employeeId);
	}
	
	@Override
	public Employee getEmployee(String email) {
		return er.getEmployee(email);
	}


	@Override
	public boolean addEmployee(Employee employee) {
		return er.addEmployee(employee);
		
	}

	@Override
	public List<Employee> getAllEmployees() {
		return er.getAllEmployees();
		
	}

	@Override
	public boolean updateEmployee(Employee eChange) {
		return er.updateEmployee(eChange);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		return er.deleteEmployee(employee);
	}

	
}
