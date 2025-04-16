package com.javaweb.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.converter.BuildingConverter;
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
	private BuildingConverter buildingConverter;
	
	@Override
	public List<BuildingResponseDTO> findAll(Map<String, Object> params, List<String> typeCode) {
		
		List<BuildingEntity> buildingEntities = buildingRepository.findAll(params, typeCode);
		
		List<BuildingResponseDTO> result = new ArrayList<BuildingResponseDTO>();
		
		for(BuildingEntity x : buildingEntities) {
			BuildingResponseDTO buildingResponseDTO = buildingConverter.toBuildingSearchResponseDTO(x);
			result.add(buildingResponseDTO);
		}
		
		return result;
	}
	
}
