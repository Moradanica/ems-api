package com.ems.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ems.dto.DepartmentDto;
import com.ems.entity.Department;
import com.ems.mapper.DepartmentMapper;
import com.ems.repository.DepartmentRepo;

@Service
public class DepartmentService {

	public static final Logger logger = LoggerFactory.getLogger(DepartmentService.class);

	DepartmentRepo departmentRepo;
	DepartmentMapper mapper = new DepartmentMapper();

	DepartmentService(DepartmentRepo repo) {
		this.departmentRepo = repo;
	}

	public List<DepartmentDto> getDepartments() {
		List<Department> departments = departmentRepo.findAll();
		return departments.stream().map(
				d -> DepartmentDto.builder().id(d.getId()).name(d.getName()).description(d.getDescription()).build())
				.toList();
	}

	public Optional<DepartmentDto> getDepartmentById(int id) {
		return departmentRepo.findById(id).map(
				d -> DepartmentDto.builder().id(d.getId()).name(d.getName()).description(d.getDescription()).build());
	}

	public Optional<DepartmentDto> updateDepartment(int id, DepartmentDto dto) {
		return departmentRepo.findById(id).map(dep -> {
			mapper.mapToEntity(dep, dto);
			return departmentRepo.save(dep);
		}).map(updated -> mapper.mapToDto(updated));
	}

	public DepartmentDto addDepartment(DepartmentDto dto) {
		Department save = departmentRepo.save(mapper.mapToEntity(dto));
		logger.info(save.toString());
		return mapper.mapToDto(save);
	}

	public boolean deleteDepartmentById(int id) {
		return departmentRepo.findById(id).map(d -> {
			departmentRepo.deleteById(id);
			return true;
		}).orElse(false);
	}

}
