package com.macsof.ui;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.macsof.util.CustomDateSerializer;

public class WelcomResult {
	
	private Integer customerId;
	
	private String cname;
	
	private String phone;
	
	private String enqCode;
	
	private String demo;
	
	private Date followUp;
	
	private String Note;
	
	private String status;
	
	private String enqFor;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
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

	public String getDemo() {
		return demo;
	}

	public void setDemo(String demo) {
		this.demo = demo;
	}

	public Date getFollowUp() {
		return followUp;
	}

	@JsonSerialize(using=CustomDateSerializer.class)
	public void setFollowUp(Date followUp) {
		this.followUp = followUp;
	}

	public String getNote() {
		return Note;
	}

	public void setNote(String note) {
		Note = note;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEnqFor() {
		return enqFor;
	}

	public void setEnqFor(String enqFor) {
		this.enqFor = enqFor;
	}

	

}
