package com.javaweb.repository.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name ="user_role")
public class UserRoleEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
//	private Long roleid;
	
//	private Long roleId;
//	private Long userId;
	@ManyToOne
	@JoinColumn(name="userid")
	private UserEntity userEntity ;
	
	@ManyToOne
	@JoinColumn(name ="roleid")
	private RoleEntity roleEntity ;
	
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
	

//	public Long getRoleid() {
//		return roleid;
//	}


//	public void setRoleid(Long roleid) {
//		this.roleid = roleid;
//	}


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
	public UserEntity getUserEntity() {
		return userEntity;
	}
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}
	public RoleEntity getRoleEntity() {
		return roleEntity;
	}
	public void setRoleEntity(RoleEntity roleEntity) {
		this.roleEntity = roleEntity;
	}
	
	
	
}
