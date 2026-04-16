package com.ems.service;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ems.dto.UserRequestDto;
import com.ems.dto.UserResponseDto;
import com.ems.entity.User;
import com.ems.mapper.UserMapper;
import com.ems.repository.UserRepo;

@Service
public class UserService {

	private UserRepo repo;
	private UserMapper mapper;
	private BCryptPasswordEncoder encoder;

	public UserService(UserRepo repo, UserMapper mapper, BCryptPasswordEncoder encoder) {
		this.repo = repo;
		this.mapper = mapper;
		this.encoder = encoder;
	}

	public User register(User user) {
		return repo.save(user);
	}

	public List<UserResponseDto> getUsers() {
		return repo.findAll().stream().map(user -> mapper.mapToDto(user)).toList();
	}

	public UserResponseDto register(UserRequestDto dto) {
		User user = repo.save(mapper.mapToEntity(dto));
		return mapper.mapToDto(user);
	}
}
