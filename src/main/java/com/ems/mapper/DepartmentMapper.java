package com.ems.mapper;

import com.ems.dto.DepartmentDto;
import com.ems.entity.Department;

public class DepartmentMapper {

	public Department mapToEntity(Department dep, DepartmentDto dto) {
		dep.setName(dto.getName());
		dep.setDescription(dto.getDescription());
		return dep;
	}

	public DepartmentDto mapToDto(Department dep) {
		return DepartmentDto.builder().id(dep.getId())
				.name(dep.getName())
				.description(dep
						.getDescription()).build();
	}

	public Department mapToEntity(DepartmentDto dto) {
		return Department.builder()
				.name(dto.getName()).description(dto.getDescription()).build();
	}

}
