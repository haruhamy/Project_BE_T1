package com.javaweb.repository.impl;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.utils.NumberUtil;
import javax.persistence.Query;

@Repository
public class BuildingRepositoryImpl implements BuildingRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
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

	private void sqlCondition(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
		try {
		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
		for(Field item : fields) {
			item.setAccessible(true);
			String key = item.getName();
			if(!key.equals("staffId") && !key.equals("typeCode") && !key.startsWith("rentArea")
					&& !key.startsWith("rentPrice")) {
				Object value = item.get(buildingSearchBuilder);	
				if(value != null) {
					if (NumberUtil.checkNumber(value.toString())) {
						where.append(" AND b." + key + " = " + value.toString());
					} else {
						where.append(" AND b." + key + " Like '%" + value.toString() + "%'");
					}
				}
			}
		}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		// Xử lý staffId
		Long staffId = buildingSearchBuilder.getStaffId();
	    if (buildingSearchBuilder.getStaffId() != null) {
	        where.append(" AND ab.staffid = ").append(staffId);
	    }

	    // Xử lý rentArea
	    Long rentAreaFrom = buildingSearchBuilder.getRentAreaFrom();
	    Long rentAreaTo = buildingSearchBuilder.getRentAreaTo();
	    if (rentAreaFrom != null) {
	        where.append(" AND ra.value >= ").append(rentAreaFrom);
	    }
	    if (rentAreaTo != null) {
	        where.append(" AND ra.value <= ").append(rentAreaTo);
	    }

	    // Xử lý rentPrice
	    Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
	    Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();
	    if (rentPriceFrom != null) {
	        where.append(" AND b.rentprice >= ").append(rentPriceFrom);
	    }
	    if (rentPriceTo != null) {
	        where.append(" AND b.rentprice <= ").append(rentPriceTo);
	    }

	    // Xử lý typeCode	    
	    List<String> typeCode = buildingSearchBuilder.getTypeCode();
	    if (typeCode != null && !typeCode.isEmpty()) {
	        where.append(" AND rt.code IN (")
	             .append(typeCode.stream()
	                             .map(i -> "'" + i + "'")
	                             .collect(Collectors.joining(",")))
	             .append(")");
	    }
	}

	@Override
	public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder) {

		StringBuilder sql = new StringBuilder("SELECT b.* FROM building b "); //Câu truy vấn 
		sqlJoin(buildingSearchBuilder, sql);
		StringBuilder where = new StringBuilder(" Where 1=1");
		
		sqlCondition(buildingSearchBuilder, where);
		sql.append(where).append(" GROUP BY b.id");		

		Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
		return query.getResultList();
	}
}