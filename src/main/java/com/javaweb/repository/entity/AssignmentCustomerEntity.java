package com.javaweb.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="assignmentcustomer")
public class AssignmentCustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Long staffId;
	private Long customerId;
	
	@Column(name ="createddate")
	private LocalDate createdDate;
	
	@Column(name ="modifieddate")
	private LocalDate modifiedDate;
	
	@Column(name ="createdby")
	private String createdBy;
	
	@Column(name ="modifiedby")
	private String modifiedBy;
	
	public Long getId() {
		return id;
	}
	public Long getStaffId() {
		return staffId;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setStaffId(Long staffId) {
		this.staffId = staffId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	
}
