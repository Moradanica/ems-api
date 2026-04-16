package com.ems.mapper;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.ems.dto.UserRequestDto;
import com.ems.dto.UserResponseDto;
import com.ems.entity.User;

@Component
public class UserMapper {

	private BCryptPasswordEncoder encoder;

	public UserMapper(BCryptPasswordEncoder encoder) {
		this.encoder = encoder;
	}

	public User mapToEntity(UserRequestDto dto) {
		return User.builder().username(dto.getUsername()).password(encoder.encode(dto.getPassword())).build();
	}

	public UserResponseDto mapToDto(User user) {
		return UserResponseDto.builder().id(user.getId()).username(user.getUsername()).build();
	}
}
