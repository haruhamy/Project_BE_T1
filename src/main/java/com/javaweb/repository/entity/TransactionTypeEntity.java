package com.javaweb.repository.entity;

import java.security.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="transactiontype")
public class TransactionTypeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="name" , nullable = false )
	private String name;
	@Column(name ="code" , nullable = false )
	private String code;
	@Column(name ="createddate")
	private Timestamp createdData;
	@Column(name ="modifieddate")
	private Timestamp modifiedData;
	@Column(name ="createdby")
	private String createdBy;
	@Column(name ="modifiedby")
	private String modifiedBy;
	private Long transactionId;
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCode() {
		return code;
	}
	public Timestamp getCreatedData() {
		return createdData;
	}
	public Timestamp getModifiedData() {
		return modifiedData;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public Long getTransactionId() {
		return transactionId;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public void setCreatedData(Timestamp createdData) {
		this.createdData = createdData;
	}
	public void setModifiedData(Timestamp modifiedData) {
		this.modifiedData = modifiedData;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}
	
	
	
}
