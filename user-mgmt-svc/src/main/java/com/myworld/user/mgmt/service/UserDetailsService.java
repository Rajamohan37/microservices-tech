package com.myworld.user.mgmt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.myworld.user.mgmt.model.dto.UserDetailsDto;

@Service
public interface UserDetailsService {

	List<UserDetailsDto> getAllUsers();
	
	UserDetailsDto addUser(UserDetailsDto userDetailsDto);
	
	UserDetailsDto updateUserDetails(Long userId, UserDetailsDto userDetailsDto);
	
}
