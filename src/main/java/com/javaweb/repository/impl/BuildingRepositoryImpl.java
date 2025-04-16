package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.ConnectionDriverUtils;
import com.javaweb.utils.DataUtil;
import com.javaweb.utils.NumberUtil;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	private void sqlJoin(BuildingSearchBuilder buildingSearchBuilder, StringBuilder join) {
		
		// Nếu có tìm kiếm theo nhân viên (staff)
	    if (buildingSearchBuilder.getStaffId() != null) {
	        join.append(" JOIN assignmentbuilding ab ON ab.buildingid = b.id");
	    }

	    // Nếu có lọc theo loại hình thuê (typeCode)
	    if (buildingSearchBuilder.getTypeCode() != null && !buildingSearchBuilder.getTypeCode().isEmpty()) {
	        join.append(" JOIN buildingrenttype brt ON brt.buildingid = b.id");
	        join.append(" JOIN renttype rt ON rt.id = brt.renttypeid");
	    }

	    // Nếu có lọc theo diện tích thuê
	    if (buildingSearchBuilder.getRentAreaFrom() != null || buildingSearchBuilder.getRentAreaTo() != null) {
	        join.append(" JOIN rentarea ra ON ra.buildingid = b.id");
	    }
	}

	private void sqlWhereSpecial(BuildingSearchBuilder buildingSearchBuilder, List<String> typeCode) {
	    // Xử lý staffId
	    Long staffId = params.get("staffId") != null ? Long.valueOf(params.get("staffId").toString()) : null;
	    if (DataUtil.checkData(staffId)) {
	        where.append(" AND ab.staffid = ").append(staffId);
	    }

	    // Xử lý rentArea
	    Long rentAreaFrom = params.get("rentAreaFrom") != null ? Long.valueOf(params.get("rentAreaFrom").toString()) : null;
	    Long rentAreaTo = params.get("rentAreaTo") != null ? Long.valueOf(params.get("rentAreaTo").toString()) : null;
	    if (DataUtil.checkData(rentAreaFrom)) {
	        where.append(" AND rt.value >= ").append(rentAreaFrom);
	    }
	    if (DataUtil.checkData(rentAreaTo)) {
	        where.append(" AND rt.value <= ").append(rentAreaTo);
	    }

	    // Xử lý rentPrice
	    Long rentPriceFrom = params.get("rentPriceFrom") != null ? Long.valueOf(params.get("rentPriceFrom").toString()) : null;
	    Long rentPriceTo = params.get("rentPriceTo") != null ? Long.valueOf(params.get("rentPriceTo").toString()) : null;
	    if (DataUtil.checkData(rentPriceFrom)) {
	        where.append(" AND b.rentprice >= ").append(rentPriceFrom);
	    }
	    if (DataUtil.checkData(rentPriceTo)) {
	        where.append(" AND b.rentprice <= ").append(rentPriceTo);
	    }

	    // Xử lý typeCode
	    if (typeCode != null && !typeCode.isEmpty()) {
	        where.append(" AND renttype.code IN (")
	             .append(typeCode.stream()
	                             .map(i -> "'" + i + "'")
	                             .collect(Collectors.joining(",")))
	             .append(")");
	    }
	}



	private void sqlWhereNormal(Map<String, Object> params, StringBuilder where) {
		for (Map.Entry<String, Object> it : params.entrySet()) {
			String key = it.getKey();
			if (!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
					&& !key.startsWith("rentPrice")) {
				String value = it.getValue().toString();
				if (!NumberUtil.checkNumber(value)) {
					where.append(" AND b." + key + " LIKE '%" + value + "%'");
				} else {
					where.append(" AND b." + key + " = " + value);
				}
			}
		}
	}

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {

		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b "); //Câu truy vấn 
		sqlJoin(params, sql);
		StringBuilder where = new StringBuilder(" Where 1=1");
		sqlWhereNormal(params, where);
		sqlWhereSpecial(params, where, typeCode);
		sql.append(where).append(" GROUP BY b.id");
		
		// Thêm điều kiện WHERE để tìm kiếm theo tên tòa nhà
		String buildingName = (String) params.get("buildingName");
		if (DataUtil.checkData(buildingName)) {
			sql.append(" WHERE b.name LIKE '%").append(buildingName).append("%'");
		}

		List<BuildingEntity> results = new ArrayList<>();
		try (Connection conn = ConnectionDriverUtils.getConnection();
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString())) {

			while (rs.next()) {
				BuildingEntity building = new BuildingEntity();
				building.setId(rs.getLong("id")); // Lấy ID của tòa nhà từ cơ sở dữ liệu
				building.setName(rs.getString("name")); // Lấy tên tòa nhà
				building.setStreet(rs.getString("street")); // Lấy tên đường của tòa nhà
				building.setWard(rs.getString("ward")); // Lấy phường của tòa nhà
				building.setDistrictId(rs.getLong("districtid")); // Lấy ID quận liên quan đến tòa nhà
				building.setStructure(rs.getString("structure")); // Lấy thông tin cấu trúc của tòa nhà
				building.setNumberOfBasement(rs.getLong("numberofbasement")); // Lấy số tầng hầm của tòa nhà
				building.setFloorArea(rs.getLong("floorarea")); // Lấy diện tích sàn của tòa nhà
				building.setDirection(rs.getString("direction")); // Lấy hướng của tòa nhà (ví dụ: Đông, Tây)
				building.setLevel(rs.getString("level")); // Lấy cấp độ của tòa nhà (ví dụ: cao cấp, trung cấp)
				building.setRentPrice(rs.getDouble("rentprice")); // Lấy giá thuê của tòa nhà
				building.setRentPriceDescription(rs.getString("rentpricedescription")); // Lấy mô tả về giá thuê
				building.setServiceFee(rs.getDouble("servicefee")); // Lấy phí dịch vụ của tòa nhà
				building.setCarFee(rs.getString("carfee")); // Lấy phí gửi xe ô tô
				building.setMotorbikeFee(rs.getString("motorbikefee")); // Lấy phí gửi xe máy
				building.setOvertimeFee(rs.getDouble("overtimefee")); // Lấy phí làm thêm ngoài giờ
				building.setWaterFee(rs.getString("waterfee")); // Lấy phí nước
				building.setElectricityFee(rs.getDouble("electricityfee")); // Lấy phí điện
				building.setDeposit(rs.getString("deposit")); // Lấy thông tin tiền đặt cọc
				building.setPayment(rs.getString("payment")); // Lấy thông tin phương thức thanh toán
				building.setRentTime(rs.getString("renttime")); // Lấy thời gian thuê
				building.setDecorationTime(rs.getString("decorationtime")); // Lấy thời gian trang trí (nếu có)
				building.setBrokerageFee(rs.getDouble("brokeragefee")); // Lấy phí môi giới
				building.setNote(rs.getString("note")); // Lấy ghi chú liên quan đến tòa nhà
				building.setLinkOfBuilding(rs.getString("linkofbuilding")); // Lấy liên kết thông tin tòa nhà
				building.setMap(rs.getString("map")); // Lấy thông tin bản đồ (URL hoặc tọa độ)
				building.setImage(rs.getString("image")); // Lấy thông tin ảnh đại diện của tòa nhà
				building.setCreatedDate(rs.getString("createddate")); // Lấy ngày tạo bản ghi tòa nhà
				building.setModifiedDate(rs.getString("modifieddate")); // Lấy ngày chỉnh sửa bản ghi tòa nhà
				building.setCreatedBy(rs.getString("createdby")); // Lấy thông tin người tạo bản ghi
				building.setModifiedBy(rs.getString("modifiedby")); // Lấy thông tin người chỉnh sửa bản ghi
				building.setManagerName(rs.getString("managername")); // Lấy tên người quản lý tòa nhà
				building.setManagerPhoneNumber(rs.getString("managerphonenumber")); // Lấy số điện thoại người quản lý
																					// tòa nhà

				results.add(building);
			}

			System.out.println("Query executed successfully...");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query execution failed...");
		}
		return results;
	}
}