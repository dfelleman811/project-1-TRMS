package dev.felleman.servicestests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import dev.felleman.models.Department;
import dev.felleman.models.Employee;
import dev.felleman.models.Reimbursement;
import dev.felleman.models.Request;
import dev.felleman.services.DepartmentServices;
import dev.felleman.services.DepartmentServicesImpl;
import dev.felleman.services.EmployeeServices;
import dev.felleman.services.EmployeeServicesImpl;
import dev.felleman.services.ReimbursementServices;
import dev.felleman.services.ReimbursementServicesImpl;
import dev.felleman.services.RequestServices;
import dev.felleman.services.RequestServicesImpl;

//@RunWith(MockitoJUnitRunner.class)
public class ServicesTests {
	
//	@InjectMocks
//	public EmployeeServicesImpl es;
//
//	@Mock
//	public EmployeeRepositoryImpl er;
	
	public EmployeeServices er = new EmployeeServicesImpl();
	
	public RequestServices rs = new RequestServicesImpl();
	
	public DepartmentServices ds = new DepartmentServicesImpl();
	
	public ReimbursementServices rbs = new ReimbursementServicesImpl();
	
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
		
		String email = "basic.employee@example.com";
		
//		when(er.getEmployee(email)).thenReturn(e);
		
		Assert.assertEquals(e, er.getEmployee(email));
		
//		verify(er, times(1)).getEmployee(email);
	}
	
	@Test
	public void addRequestTest() {
		
		Employee e = new Employee();
		e.setEmployeeId(18);
		e.setFirstName("Basic");
		e.setLastName("TestEmployee");
		e.setEmail("basic.employee@example.com");
		e.setPassword("password");
		e.setDepartmentId(1);
		e.setSupervisorId(13);
		e.setAvailableReimbursement(1000);	
		
		Request r = new Request();
		r.setEmployeeId(18);
		r.setIsUrgent(1);
		
		rs.addRequest(r.getEmployeeId(), r.getIsUrgent()); // I just checked that the DB updated correctly, it did.
		
	}

	
	@Test
	public void getAllDepartmentsTest() {
		
		List<Department> deptList = new ArrayList<Department>();
		
		Department d6 = new Department(0, "benco",12);
		Department d1 = new Department(1, "sales",13);
		Department d2 = new Department(2, "research",14);
		Department d3 = new Department(3, "design",15);
		Department d4 = new Department(4, "marketing",16);
		Department d5 = new Department(5, "relations",17);
		
		deptList.add(d6);
		deptList.add(d1);
		deptList.add(d2);
		deptList.add(d3);
		deptList.add(d4);
		deptList.add(d5);
		
		
		Assert.assertEquals(deptList, ds.getAllDepartments());
		
	}
	
	@Test
	public void getAllReimbursementsByEmployeeTest() {
		
		
		List<Reimbursement> remList = new ArrayList<Reimbursement>();
		
		Reimbursement r = new Reimbursement(2, 300,	18,	3,	50);
		Reimbursement r1 = new Reimbursement(3, 300, 18, 3,	50);
		Reimbursement r2 = new Reimbursement(4, 300, 18, 3,	50);
		
		remList.add(r);
		remList.add(r1);
		remList.add(r2);
		
		Assert.assertEquals(remList, rbs.getAllReimbursementsByEmployee(18));
		
	}
	
	
}


















