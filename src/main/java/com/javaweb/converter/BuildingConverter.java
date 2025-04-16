package com.javaweb.converter;

import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;


@Component
public class BuildingConverter {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    @Autowired
    private ModelMapper modelMapper;
    
    // DTO -> Entity

    // Entity -> DTO
    public BuildingResponseDTO toBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
        BuildingResponseDTO buildingResponse = modelMapper.map(buildingEntity, BuildingResponseDTO.class);

        buildingResponse.setAddress(buildingEntity.getStreet() + ", " + buildingEntity.getWard() + ", "
				+ buildingEntity.getDistrictEntity().getName());
		StringBuilder rentAreaValue = new StringBuilder("");
		rentAreaValue.append(buildingEntity.getRentAreaEntity().stream().map(i -> i.getValue().toString())
				.collect(Collectors.joining(",")));
		buildingResponse.setRentedArea(rentAreaValue.toString());
		return buildingResponse;
    }
}
