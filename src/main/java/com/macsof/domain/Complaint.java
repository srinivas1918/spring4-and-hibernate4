package com.macsof.domain;

// Generated Apr 15, 2015 7:06:38 AM by Hibernate Tools 4.0.0

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Complaint generated by hbm2java
 */
@Entity
@Table(name = "complaint", catalog = "tracker")
public class Complaint implements java.io.Serializable {

	private Integer complaintId;
	
	private Date complaintDate;
	private String status;
	private String replaceParts;
	private String note;
	private Integer customerId;
	private String technician;
	private Date closedDate;
	
	public Complaint() {
	}


	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "COMPLAINT_ID", unique = true, nullable = false)
	public Integer getComplaintId() {
		return this.complaintId;
	}

	public void setComplaintId(Integer complaintId) {
		this.complaintId = complaintId;
	}

	

	@Temporal(TemporalType.DATE)
	@Column(name = "COMPLAINT_DATE", length = 10)
	public Date getComplaintDate() {
		return this.complaintDate;
	}

	public void setComplaintDate(Date complaintDate) {
		this.complaintDate = complaintDate;
	}

	@Column(name = "STATUS", length = 15)
	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "REPLACE_PARTS", length = 250)
	public String getReplaceParts() {
		return this.replaceParts;
	}

	public void setReplaceParts(String replaceParts) {
		this.replaceParts = replaceParts;
	}

	@Column(name = "NOTE", length = 500)
	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	@Column(name = "CUSTOMER_ID", length = 11)
	public Integer getCustomerId() {
		return customerId;
	}


	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	@Column(name = "TECHNICIAN", length = 25)
	public String getTechnician() {
		return technician;
	}


	public void setTechnician(String technician) {
		this.technician = technician;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "CLOSED_DATE", length = 10)
	public Date getClosedDate() {
		return closedDate;
	}


	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	
}
