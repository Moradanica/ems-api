package com.ems.controller.rest;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.DepartmentDto;
import com.ems.service.DepartmentService;

@RestController
@RequestMapping("/api")
public class DepartmentController {

	DepartmentService departmentService;

	public DepartmentController(DepartmentService service) {
		this.departmentService = service;
	}

	@GetMapping(path="/departments", produces = "application/xml")
	@ResponseBody()
	public ResponseEntity<List<DepartmentDto>> getDepartments() {
		List<DepartmentDto> departments = departmentService.getDepartments();
		return ResponseEntity.ok(departments);
	}

	@GetMapping("/department/{id}")
	public ResponseEntity<DepartmentDto> getDepartmentById(@PathVariable int id) {
		return departmentService.getDepartmentById(id).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PutMapping("/department/{id}")
	public ResponseEntity<DepartmentDto> updateDepartment(@PathVariable int id, @RequestBody DepartmentDto dto) {
		return departmentService.updateDepartment(id, dto).map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());

	}

	@PostMapping("/departments")
	public ResponseEntity<DepartmentDto> addDepartment(@RequestBody DepartmentDto dto) {
		DepartmentDto saved = departmentService.addDepartment(dto);
		URI location = URI.create("/api/department/" + saved.getId());
		return ResponseEntity.created(location).body(saved);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteDepartment(@PathVariable int id) {
		boolean deleted = departmentService.deleteDepartmentById(id);
		if (deleted) {
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}

}
