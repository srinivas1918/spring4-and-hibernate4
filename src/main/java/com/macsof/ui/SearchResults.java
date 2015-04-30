package com.macsof.ui;

import java.util.Date;

public class SearchResults {

	private int cusId;
	
	private String cname;
	
	private String phone;
	
	private String enqCode;
	
	private Date closedDate;
	
	private String enqFor;
	

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEnqCode() {
		return enqCode;
	}

	public void setEnqCode(String enqCode) {
		this.enqCode = enqCode;
	}

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getEnqFor() {
		return enqFor;
	}

	public void setEnqFor(String enqFor) {
		this.enqFor = enqFor;
	}

	
	
}
