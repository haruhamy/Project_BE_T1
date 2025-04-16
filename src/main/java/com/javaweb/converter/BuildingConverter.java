package com.javaweb.converter;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.repository.DistrictRepository;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.entity.BuildingEntity;
import com.javaweb.repository.entity.DistrictEntity;
import com.javaweb.repository.entity.RentAreaEntity;


@Component
public class BuildingConverter {

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private RentAreaRepository rentAreaRepository;

    // DTO -> Entity

    // Entity -> DTO
    public BuildingResponseDTO toBuildingSearchResponseDTO(BuildingEntity buildingEntity) {
        BuildingResponseDTO buildingResponse = new BuildingResponseDTO();
        buildingResponse.setId(buildingEntity.getId());
        buildingResponse.setName(buildingEntity.getName());
        buildingResponse.setNumberOfBasement(buildingEntity.getNumberOfBasement());
        buildingResponse.setRentPrice(buildingEntity.getRentPrice());

        DistrictEntity districtEntity = districtRepository.findById(buildingEntity.getDistrictId());
        buildingResponse.setAddress(
            buildingEntity.getStreet() + " " +
            buildingEntity.getWard() + ", " +
            districtEntity.getName()
        );

        List<RentAreaEntity> rentAreas = rentAreaRepository.findByBuilding(buildingEntity.getId());
        StringBuilder rentAreaValue = new StringBuilder("");
        rentAreaValue.append(
            rentAreas.stream()
                     .map(i -> i.getValue().toString())
                     .collect(Collectors.joining(","))
        );

        buildingResponse.setRentArea(rentAreaValue.toString());
        return buildingResponse;
    }
}
