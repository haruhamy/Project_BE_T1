package com.javaweb.repository.entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name ="building")
public class BuildingEntity {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name ="name" , nullable = false )
	private String name;
	@Column(name ="street")
	private String street;
	
	@Column(name ="ward")
	private String ward;
	
	@ManyToOne
	@JoinColumn(name = "districtid")
	private DistrictEntity districtEntity ; 
	@OneToMany(mappedBy = "buildingEntity" , fetch = FetchType.LAZY)
	private List<RentAreaEntity> rentAreaEntity;
	
	
	@Column(name ="structure")
	private String structure;
	@Column(name ="numberofbasement")
	private Long numberOfBasement;
	@Column(name ="floorarea")
	private Long floorArea;
	@Column(name ="direction")
	private String direction;
	@Column(name ="level")
	private String level;	
	@Column(name ="rentprice", nullable = false)
	private Long rentPrice;
	@Column(name ="rentpricedescription")
	private String rentPriceDescription;
	@Column(name ="servicefee")
	private String serviceFee;
	@Column(name ="carfee")
	private String carFee;
	@Column(name ="motorbikefee")
	private String motorbikeFee;
	@Column(name ="overtimefee")
	private String overtimeFee;
	
	@Column(name ="waterfee")
	private String waterFee;
	@Column(name ="electricityfee")
	private String electricityFee;
	@Column(name ="deposit")
	private String deposit;
	@Column(name ="payment")
	private String payment;
	@Column(name ="renttime")
	private String rentTime;
	@Column(name ="decorationtime")
	private String decorationTime;
	@Column(name ="brokeragefee")
	private Long brokerageFee;
	@Column(name ="note")
	private String note;
	@Column(name ="linkofbuilding")
	private String linkOfBuilding;
	@Column(name ="map")
	private String map;
	@Column(name ="image")
	private String image;
	@Column(name ="createddate")
	private LocalDate createdDate;
	@Column(name ="modifieddate")
	private LocalDate modifiedDate;
	@Column(name ="createdby")
	private String createdBy;
	@Column(name ="modifiedby")
	private String modifiedBy;
	@Column(name ="managername")
	private String managerName;
	@Column(name ="managerphonenumber")
	private String managerPhoneNumber;
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getStreet() {
		return street;
	}
	public String getWard() {
		return ward;
	}
	public String getStructure() {
		return structure;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public String getDirection() {
		return direction;
	}
	public String getLevel() {
		return level;
	}
	public Long getRentPrice() {
		return rentPrice;
	}
	public String getRentPriceDescription() {
		return rentPriceDescription;
	}
	public String getServiceFee() {
		return serviceFee;
	}
	public String getCarFee() {
		return carFee;
	}
	public String getMotorbikeFee() {
		return motorbikeFee;
	}
	public String getOvertimeFee() {
		return overtimeFee;
	}
	public String getWaterFee() {
		return waterFee;
	}
	public String getElectricityFee() {
		return electricityFee;
	}
	public String getDeposit() {
		return deposit;
	}
	public String getPayment() {
		return payment;
	}
	public String getRentTime() {
		return rentTime;
	}
	public String getDecorationTime() {
		return decorationTime;
	}
	
	public Long getBrokerageFee() {
		return brokerageFee;
	}
	public String getNote() {
		return note;
	}
	public String getLinkOfBuilding() {
		return linkOfBuilding;
	}
	public String getMap() {
		return map;
	}
	public String getImage() {
		return image;
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
	public String getManagerName() {
		return managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public void setRentPrice(Long rentPrice) {
		this.rentPrice = rentPrice;
	}
	public void setRentPriceDescription(String rentPriceDescription) {
		this.rentPriceDescription = rentPriceDescription;
	}
	public void setServiceFee(String serviceFee) {
		this.serviceFee = serviceFee;
	}
	public void setCarFee(String carFee) {
		this.carFee = carFee;
	}
	public void setMotorbikeFee(String motorbikeFee) {
		this.motorbikeFee = motorbikeFee;
	}
	public void setOvertimeFee(String overtimeFee) {
		this.overtimeFee = overtimeFee;
	}
	public void setWaterFee(String waterFee) {
		this.waterFee = waterFee;
	}
	public void setElectricityFee(String electricityFee) {
		this.electricityFee = electricityFee;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public void setRentTime(String rentTime) {
		this.rentTime = rentTime;
	}
	public void setDecorationTime(String decorationTime) {
		this.decorationTime = decorationTime;
	}
	public void setBrokerageFee(Long brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public void setLinkOfBuilding(String linkOfBuilding) {
		this.linkOfBuilding = linkOfBuilding;
	}
	public void setMap(String map) {
		this.map = map;
	}
	public void setImage(String image) {
		this.image = image;
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
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public DistrictEntity getDistrictEntity() {
		return districtEntity;
	}
	public void setDistrictEntity(DistrictEntity districtEntity) {
		this.districtEntity = districtEntity;
	}
	public List<RentAreaEntity> getRentAreaEntity() {
		return rentAreaEntity;
	}
	public void setRentAreaEntity(List<RentAreaEntity> rentAreaEntity) {
		this.rentAreaEntity = rentAreaEntity;
	}
	
	
}
