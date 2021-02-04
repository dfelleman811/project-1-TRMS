package dev.felleman.models;

public class Reimbursement {
	
	private int paymentId;
	private int amount;
	private int empId;
	private int devResId;
	private int reqId;
	private String payDate;
	
	
	public Reimbursement() {
		super();
	}


	public Reimbursement(int amount, int empId, int devResId, int reqId) {
		super();
		this.amount = amount;
		this.empId = empId;
		this.devResId = devResId;
		this.reqId = reqId;
	}


	public Reimbursement(int paymentId, int amount, int empId, int devResId, int reqId) {
		super();
		this.paymentId = paymentId;
		this.amount = amount;
		this.empId = empId;
		this.devResId = devResId;
		this.reqId = reqId;
	}


	public int getPaymentId() {
		return this.paymentId;
	}


	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}


	public int getAmount() {
		return this.amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}


	public int getEmpId() {
		return this.empId;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public int getDevResId() {
		return this.devResId;
	}


	public void setDevResId(int devResId) {
		this.devResId = devResId;
	}


	public int getReqId() {
		return this.reqId;
	}


	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public String getPayDate() {
		return this.payDate;
	}
	
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	@Override
	public String toString() {
		return "Reimbursement [paymentId=" + this.paymentId + ", amount=" + this.amount + ", empId=" + this.empId + ", devResId="
				+ this.devResId + ", reqId=" + this.reqId + ", payDate=" + this.payDate + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reimbursement other = (Reimbursement) obj;
		if (amount != other.amount)
			return false;
		if (devResId != other.devResId)
			return false;
		if (empId != other.empId)
			return false;
		if (paymentId != other.paymentId)
			return false;
		if (reqId != other.reqId)
			return false;
		return true;
	}
	
	

}
