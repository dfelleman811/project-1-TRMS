package dev.felleman.services;

import java.util.List;

import dev.felleman.models.Department;
import dev.felleman.repositories.DepartmentRepo;
import dev.felleman.repositories.DepartmentRepoImpl;

public class DepartmentServicesImpl implements DepartmentServices {
	
	public DepartmentRepo dr = new DepartmentRepoImpl();

	@Override
	public Department getDepartment(int deptId) {
		return dr.getDepartment(deptId);
	}

	@Override
	public Department getDepartment(String deptName) {
		return dr.getDepartmentByName(deptName);
	}
	
	@Override
	public List<Department> getAllDepartments() {
		return dr.getAllDepartments();
	}

	@Override
	public boolean addDepartment(Department dept) {
		return dr.addDepartment(dept);
	}

	@Override
	public boolean updateDepartment(Department deptChange) {
		return dr.updateDepartment(deptChange);
	}

	@Override
	public boolean deleteDepartment(Department dept) {
		return dr.deleteDepartment(dept);
	}

}
