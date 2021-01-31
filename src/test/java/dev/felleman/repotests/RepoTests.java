package dev.felleman.repotests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.felleman.models.Department;
import dev.felleman.models.Employee;
import dev.felleman.repositories.DepartmentRepo;
import dev.felleman.repositories.DepartmentRepoImpl;
import dev.felleman.repositories.EmployeeRepository;
import dev.felleman.repositories.EmployeeRepositoryImpl;

public class RepoTests {
	
	public EmployeeRepository er = new EmployeeRepositoryImpl();
	
	public DepartmentRepo dr = new DepartmentRepoImpl();

	@Test
	public void getEmployeeByEmailTest() {
		
		Employee e = new Employee();
		
		e.setEmployeeId(18);
		e.setFirstName("Basic");
		e.setLastName("TestEmployee");
		e.setEmail("basic.employee@example.com");
		e.setPassword("password");
		e.setDepartmentId(1);
		e.setSupervisorId(13);
		e.setAvailableReimbursement(1000);
		
		Assert.assertEquals(e, er.getEmployee("basic.employee@example.com"));
		
	}
	
	@Test
	public void getAllEmployeesTest() {
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee e1 = new Employee("BenCo", "BenefitsCoordinator", "benco@example.com", "admin", 0, 0);
		e1.setEmployeeId(12);
		
		Employee e2 = new Employee("Sales", "DepartmentHead", "sales.depthead@example.com", "saleshead", 1,	12);
		e2.setEmployeeId(13);
		
		Employee e3 = new Employee("Research", "DepartmentHead", "research.depthead@example.com", "researchhead", 2, 12);
		e3.setEmployeeId(14);
		
		Employee e4 = new Employee("Design", "DepartmentHead", "design.depthead@example.com", "designhead", 3, 12);
		e4.setEmployeeId(15);
		
		Employee e5 = new Employee("Marketing", "DepartmentHead", "marketing.depthead@example.com", "marketinghead", 4, 12);
		e5.setEmployeeId(16);
		
		Employee e6 = new Employee("Relations", "DepartmentHead", "relations.depthead@example.com",	"relationshead", 5,	12);
		e6.setEmployeeId(17);
		
		Employee e7 = new Employee("Basic",	"TestEmployee",	"basic.employee@example.com", "password", 1, 13);
		e7.setEmployeeId(18);
		
		empList.add(e1);
		empList.add(e2);
		empList.add(e3);
		empList.add(e4);
		empList.add(e5);
		empList.add(e6);
		empList.add(e7);
		
		Assert.assertEquals(empList, er.getAllEmployees());
		
	}

	
	@Test
	public void getDepartmentTest() {
		
		Department d = new Department();
		
		d.setDepartmentId(1);
		d.setDepartmentName("sales");
		d.setDepartmentHead(13);
		
		Assert.assertEquals(d, dr.getDepartment(1));
	}
	

}
