package com.ems.controller.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.dto.UserRequestDto;
import com.ems.dto.UserResponseDto;
import com.ems.entity.User;
import com.ems.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

	private UserService service;

	public UserController(UserService service) {
		this.service = service;
	}

	@GetMapping
	public List<UserResponseDto> getUsers() {
		return service.getUsers();
	}

	@PostMapping
	public UserResponseDto register(@RequestBody UserRequestDto dto) {
		return service.register(dto);
	}

}
