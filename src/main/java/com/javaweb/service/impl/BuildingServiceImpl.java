package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;
import com.javaweb.service.BuildingService;

@Service
public class BuildingServiceImpl implements BuildingService{

	@Autowired
	private BuildingRepository buildingRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	@Autowired
	private RentAreaRepository rentAreaRepository;
	
	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);
		
		List<BuildingResponseDTO> result = new ArrayList<BuildingResponseDTO>();
		
		for(BuildingEntity x : buildingEntities) {
			BuildingResponseDTO buildingResponseDTO = new BuildingResponseDTO();
			
			buildingResponseDTO.setId(x.getId());
			buildingResponseDTO.setName(x.getName());
			
			DistrictEntity districtEntity = districtRepository.findById(x.getDistrictId());
			buildingResponseDTO.setAddress(x.getStreet() + "," + x.getWard() + "," + districtEntity.getName());
			
			buildingResponseDTO.setNumberOfBasement(x.getNumberOfBasement());
			
			List<RentAreaEntity> rentAreaEntities = rentAreaRepository.findByBuilding(x.getId());
			String rentArea = "";
			for(int i = 0; i < rentAreaEntities.size(); i++) {
				rentArea += rentAreaEntities.get(i).getValue().toString();
				rentArea += ",";
			}
			
			buildingResponseDTO.setManagerName(x.getManagerName());
			buildingResponseDTO.setManagerPhoneNumber(x.getManagerPhoneNumber());
			buildingResponseDTO.setFloorArea(x.getFloorArea());
			buildingResponseDTO.setEmptyArea(null);
			buildingResponseDTO.setRentArea(rentArea);
			buildingResponseDTO.setBrokerageFee(x.getBrokerageFee());
			buildingResponseDTO.setRentPrice(x.getRentPrice());
			buildingResponseDTO.setServiceFee(x.getServiceFee());
			
			result.add(buildingResponseDTO);
		}
		
		return result;
	}
	
}
