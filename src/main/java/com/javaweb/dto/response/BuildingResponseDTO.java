package com.javaweb.dto.response;

public class BuildingResponseDTO { //Class ném ra ngoài màn hình
	//tên QL, SĐT QL, D.T sàn, D.T trống, D.T thuê, Giá thuê, Phí dịch vụ, Phí môi giới,
	
	private Long id; //key_1
	private String name; //tên tòa nhà_2
	private String address; //duong,phuong,quan_3
	private Long numberOfBasement; //Số tầng hầm_4	
	private String managerName; //Tên người quản lí_5
	private String managerPhoneNumber; //sđt quản lí_6
	private Long floorArea; //Diện tích sàn_7
	private String emptyArea; //Diện tích trống_8
	private String rentArea; //Diện tích thuê_9
	private Double rentPrice; //Giá thuê_10
	private Double serviceFee; //Phí dịch vụ_11
	private Double brokerageFee; //Phí môi giới_12
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Long numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerPhoneNumber() {
		return managerPhoneNumber;
	}
	public void setManagerPhoneNumber(String managerPhoneNumber) {
		this.managerPhoneNumber = managerPhoneNumber;
	}
	public Long getFloorArea() {
		return floorArea;
	}
	public void setFloorArea(Long floorArea) {
		this.floorArea = floorArea;
	}
	public String getEmptyArea() {
		return emptyArea;
	}
	public void setEmptyArea(String emptyArea) {
		this.emptyArea = emptyArea;
	}
	public String getRentArea() {
		return rentArea;
	}
	public void setRentArea(String rentArea) {
		this.rentArea = rentArea;
	}
	public Double getRentPrice() {
		return rentPrice;
	}
	public void setRentPrice(Double rentPrice) {
		this.rentPrice = rentPrice;
	}
	public Double getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Double serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Double getBrokerageFee() {
		return brokerageFee;
	}
	public void setBrokerageFee(Double brokerageFee) {
		this.brokerageFee = brokerageFee;
	}
	
	
}
