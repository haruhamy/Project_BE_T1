package com.javaweb.repository;

import java.util.*;

import com.javaweb.repository.entity.BuildingEntity;

public interface BuildingRepository {
	List<BuildingEntity> findAll(Map<String, Object> params, List<String> typeCode);
}
