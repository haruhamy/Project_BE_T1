package com.javaweb.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import antlr.collections.List;

@Entity
@Table(name ="user")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="username" , nullable = false, unique = true )
	private String userName;
	@Column(name ="password" , nullable = false )
	private String password;
	@Column(name ="fullname")
	private String fullName;
	@Column(name ="phone")
	private String phone;
	@Column(name ="email")
	private String email;
	@Column(name ="status" , nullable = false )
	private Long status;	
	@Column(name ="createddate")
	private LocalDate createdDate;
	@Column(name ="modifieddate")
	private LocalDate modifiedDate;
	@Column(name ="createdby")
	private String createdBy;
	@Column(name ="modifiedby")
	private String modifiedBy;
//	
//	@OneToMany(mappedBy="userEntity")
//	private List<UserRoleEntity> userRoleEntity;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Long getStatus() {
		return status;
	}
	public void setStatus(Long status) {
		this.status = status;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}
	public LocalDate getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getModifiedBy() {
		return modifiedBy;
	}
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
//	public List<UserRoleEntity> getUserRoleEntity() {
//		return userRoleEntity;
//	}
//	public void setUserRoleEntity(List<UserRoleEntity> userRoleEntity) {
//		this.userRoleEntity = userRoleEntity;
//	}

}
