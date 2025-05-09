package com.javaweb.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javaweb.dto.BuildingDTO;
import com.javaweb.dto.response.BuildingResponseDTO;
import com.javaweb.service.BuildingService;

@RestController
public class BuildingAPI {
	
	@Autowired
	private BuildingService buildingService;
	
	@GetMapping("/api/building")
	private Object getBuilding(@RequestParam Map<String, Object> params,
								@RequestParam(name = "typeCode", required = false) List<String> typeCode) {
		
		List<BuildingResponseDTO> buildings = buildingService.findAll(params, typeCode);
		
		return buildings;
	}

	@PostMapping("/api/building")
	private void createBuilding(@RequestBody List<BuildingDTO> buildings) {
		System.out.print(buildings.get(0).getName());
	}
}
