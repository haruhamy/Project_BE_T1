package com.javaweb.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.stereotype.Repository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.entity.DistrictEntity;

@Repository
public class DistrictRepositoryImpl implements DistrictRepository {

	static final String DB_URL = "jdbc:mysql://localhost:3306/estatebasic";
	static final String USER = "root";
	static final String PASS = "titansword";

	@Override
	public DistrictEntity findById(Long id) {
		String sql = "SELECT d.* FROM district d WHERE d.id = " + id;
		DistrictEntity districtEntity = new DistrictEntity();

		try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				Statement stm = conn.createStatement();
				ResultSet rs = stm.executeQuery(sql.toString())) {

			while (rs.next()) {

				districtEntity = new DistrictEntity();
				districtEntity.setId(rs.getLong("id"));
				districtEntity.setCode(rs.getString("code"));
				districtEntity.setName(rs.getString("name"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Query execution failed...");
		}
		return districtEntity;
	}
}
