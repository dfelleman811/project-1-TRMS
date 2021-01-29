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
	public Employee addEmployee(Employee employee) {
		er.addEmployee(employee);
		return null;
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
