package dev.felleman.models;

import java.sql.Date;

public class Request {

	private int requestId;
	private Date submitDate;
	private int isUrgent;
	private String status;
	private Date lastUpdated;
	private int employeeId;
	private int devResource;

	public Request() {
		super();
	}

	public Request(Date submitDate, int isUrgent, String status, Date lastUpdated, int employeeId, int devResource) {
		super();
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.lastUpdated = lastUpdated;
		this.employeeId = employeeId;
		this.devResource = devResource;
	}

	public Request(int requestId, Date submitDate, int isUrgent, String status, Date lastUpdated, int employeeId, int devResource) {
		super();
		this.requestId = requestId;
		this.submitDate = submitDate;
		this.isUrgent = isUrgent;
		this.status = status;
		this.lastUpdated = lastUpdated;
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
	
	public Date getLastUpdated() {
		return this.lastUpdated;
	}
	
	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
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
		return "Request [requestId=" + this.requestId + ", submitDate=" + this.submitDate + ", isUrgent="
				+ this.isUrgent + ", status=" + this.status + ", lastUpdated=" + this.lastUpdated + ", employeeId=" + this.employeeId + ", devResource="
				+ this.devResource + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Request other = (Request) obj;
		if (devResource != other.devResource)
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (isUrgent != other.isUrgent)
			return false;
		if (lastUpdated == null) {
			if (other.lastUpdated != null)
				return false;
		} else if (!lastUpdated.equals(other.lastUpdated))
			return false;
		if (requestId != other.requestId)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (submitDate == null) {
			if (other.submitDate != null)
				return false;
		} else if (!submitDate.equals(other.submitDate))
			return false;
		return true;
	}

	
}
