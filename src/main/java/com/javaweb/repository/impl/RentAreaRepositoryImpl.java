package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.utils.ConnectionDriverUtils;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{	
	@Override
	public List<RentAreaEntity> findByBuilding(Long buildingId) {
		String sql = "SELECT * FROM rentarea WHERE 1=1 AND buildingId =" + buildingId;
		List<RentAreaEntity> result = new ArrayList<RentAreaEntity>();
		try (Connection conn = ConnectionDriverUtils.getConnection();
		         Statement stm = conn.createStatement();
		         ResultSet rs = stm.executeQuery(sql.toString())) {	

	        while(rs.next()){
	            RentAreaEntity rentAreaEntity = new RentAreaEntity();
	            rentAreaEntity.setId(rs.getLong("id"));
	            rentAreaEntity.setValue(rs.getLong("value"));
	            result.add(rentAreaEntity);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Query execution failed...");
	    }
		
		return result;
	}

}
