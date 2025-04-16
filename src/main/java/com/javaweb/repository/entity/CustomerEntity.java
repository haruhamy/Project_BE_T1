package com.javaweb.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="customer")
public class CustomerEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	@Column(name = "fullname" )
	private String fullName;
	@Column(name = "phone" )
	private String phone;
	@Column(name = "email" )
	private String email;
	@Column(name = "createddate" )
	private LocalDate createdDate;
	@Column(name = "modifieddate" )
	private LocalDate modifiedDate;
	@Column(name = "createdby" )
	private String createdBy;
	@Column(name = "modifiedby" )
	private String modifiedBy;
	
	public Long getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
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
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
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
