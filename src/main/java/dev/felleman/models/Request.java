package dev.felleman.models;

import java.sql.Date;

public class Request {
	
	private int requestId;
	private Date submitDate;
	private int isUrgent;
	private String status;
	private int employeeId;
	private int devResource;
	
	public Request() {
		super();
	}

	public Request(Date submitDate, int isUrgent, String status, int employeeId, int devResource) {
		super();
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.employeeId = employeeId;
		this.devResource = devResource;
	}

	public Request(int requestId, Date submitDate, int isUrgent, String status, int employeeId, int devResource) {
		super();
		this.requestId = requestId;
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.employeeId = employeeId;
		this.devResource = devResource;
	}

	public int getRequestId() {
		return this.requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public Date getSubmitDate() {
		return this.submitDate;
	}

	public void setSubmitDate(Date submitDate) {
		this.submitDate = submitDate;
	}

	public int getIsUrgent() {
		return this.isUrgent;
	}

	public void setIsUrgent(int isUrgent) {
		this.isUrgent = isUrgent;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getDevResource() {
		return this.devResource;
	}

	public void setDevResource(int devResource) {
		this.devResource = devResource;
	}

	@Override
	public String toString() {
		return "Request [requestId=" + this.requestId + ", submitDate=" + this.submitDate + ", isUrgent=" + this.isUrgent + ", status="
				+ this.status + ", employeeId=" + this.employeeId + ", devResource=" + this.devResource + "]";
	}
	
	

}
