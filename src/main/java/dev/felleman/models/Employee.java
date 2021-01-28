package dev.felleman.models;

public class Employee {

	private int employeeId;
	private String firstName;
	private String lastName;
	private String email; // this will double as 'username' to log into the webapp
	private String password;
	private int departmentId;
	private int supervisorId;
	private int availableReimbursement;
	
	public Employee() {
		super();
	}

	public Employee(String firstName, String lastName, String email, String password, int departmentId,
			int supervisorId) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.departmentId = departmentId;
		this.supervisorId = supervisorId;
		this.availableReimbursement = 1000;
	}

	public Employee(int employeeId, String firstName, String lastName, String email, String password, int departmentId,
			int supervisorId, int availableReimbursement) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.departmentId = departmentId;
		this.supervisorId = supervisorId;
		this.availableReimbursement = availableReimbursement;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public int getSupervisorId() {
		return this.supervisorId;
	}

	public void setSupervisorId(int supervisorId) {
		this.supervisorId = supervisorId;
	}

	public int getAvailableReimbursement() {
		return this.availableReimbursement;
	}

	public void setAvailableReimbursement(int availableReimbursement) {
		this.availableReimbursement = availableReimbursement;
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + this.employeeId + ", firstName=" + this.firstName + ", lastName=" + this.lastName + ", email="
				+ this.email + ", password=" + this.password + ", departmentId=" + this.departmentId + ", supervisorId=" + this.supervisorId
				+ ", availableReimbursement=" + this.availableReimbursement + "]";
	}
	
	
	
}
