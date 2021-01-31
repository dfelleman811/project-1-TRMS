package dev.felleman.repositories;

import java.util.List;

import dev.felleman.models.Department;

public interface DepartmentRepo {
	
	public Department getDepartment(int deptId);
	
	public Department getDepartmentByName(String deptName);
	
	public List<Department> getAllDepartments();
	
	public boolean addDepartment(Department dept);
	
	public boolean updateDepartment(Department deptChange);
	
	public boolean deleteDepartment(Department dept);
	
}
