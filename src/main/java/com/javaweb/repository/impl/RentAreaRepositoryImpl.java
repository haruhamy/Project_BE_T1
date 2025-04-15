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

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepository{

	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "titansword";
	
	@Override
	public List<RentAreaEntity> findByBuilding(Long buildingId) {
		String sql = "SELECT * FROM rentarea WHERE 1=1 AND buildingId =" + buildingId;
		List<RentAreaEntity> result = new ArrayList<RentAreaEntity>();
		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		         Statement stm = conn.createStatement();
		         ResultSet rs = stm.executeQuery(sql.toString())) {	

	        while(rs.next()){
	            RentAreaEntity rentAreaEntity = new RentAreaEntity();
	            rentAreaEntity.setBuildingId(rs.getLong("buildingid"));
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
