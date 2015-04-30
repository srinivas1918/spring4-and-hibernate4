package com.macsof.ui;

import java.util.Date;

public class CustomerInstallDetails {
	
	private int installId;
	
	private String cname;
	
	private String phone;
	
	private String enqId;
	
	private String name;
	
	private Date date;
	
	private String status;
	
	private String address;
	
	private String note;
	
	private Date cDate;
	
	private int cusId;
	
	private String enqFor;

	public int getCusId() {
		return cusId;
	}

	public void setCusId(int cusId) {
		this.cusId = cusId;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getInstallId() {
		return installId;
	}

	public void setInstallId(int installId) {
		this.installId = installId;
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

	public String getEnqId() {
		return enqId;
	}

	public void setEnqId(String enqId) {
		this.enqId = enqId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getcDate() {
		return cDate;
	}

	public void setcDate(Date cDate) {
		this.cDate = cDate;
	}

	public String getEnqFor() {
		return enqFor;
	}

	public void setEnqFor(String enqFor) {
		this.enqFor = enqFor;
	}
	
	

}
