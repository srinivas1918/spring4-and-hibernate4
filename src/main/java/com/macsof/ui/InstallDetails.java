package com.macsof.ui;

import java.util.Date;

import org.codehaus.jackson.map.annotate.JsonSerialize;

import com.macsof.util.CustomDateSerializer;

public class InstallDetails {

	private String cname;
	private String phone;
	private String address;
	private String technician;
	private Date install;
	private String status;
	private String note;
	
	public String getCname() {
		return cname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
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
	public String getTechnician() {
		return technician;
	}
	public void setTechnician(String technician) {
		this.technician = technician;
	}
	
	@JsonSerialize(using=CustomDateSerializer.class)
	public Date getInstall() {
		return install;
	}
	public void setInstall(Date install) {
		this.install = install;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
