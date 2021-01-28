package dev.felleman.models;

public class Department {

	private int departmentId;
	private String departmentName;
	private int departmentHead; // references employee id
	
	public Department() {
		super();
	}

	public Department(String departmentName, int departmentHead) {
		super();
		this.departmentName = departmentName;
		this.departmentHead = departmentHead;
	}

	public Department(int departmentId, String departmentName, int departmentHead) {
		super();
		this.departmentId = departmentId;
		this.departmentName = departmentName;
		this.departmentHead = departmentHead;
	}

	public int getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return this.departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDepartmentHead() {
		return this.departmentHead;
	}

	public void setDepartmentHead(int departmentHead) {
		this.departmentHead = departmentHead;
	}

	@Override
	public String toString() {
		return "Department [departmentId=" + this.departmentId + ", departmentName=" + this.departmentName + ", departmentHead="
				+ this.departmentHead + "]";
	}
	
	
}
