package com.myworld.user.mgmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myworld.user.mgmt.exception.ResourceNotFoundException;
import com.myworld.user.mgmt.mapper.UserDetailsMapper;
import com.myworld.user.mgmt.model.dto.UserDetailsDto;
import com.myworld.user.mgmt.repo.UserDetailsRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	private static final UserDetailsMapper mapper = Mappers.getMapper(UserDetailsMapper.class);

	@Autowired
	private UserDetailsRepository userDetailsRepository;

	@Override
	public List<UserDetailsDto> getAllUsers() {
		return userDetailsRepository.findAll().stream().map(mapper::mapToUserDetailsDto).collect(Collectors.toList());
	}

	@Override
	public UserDetailsDto addUser(UserDetailsDto userDetailsDto) {
		var userDetails = mapper.mapToUserDetails(userDetailsDto);

		return mapper.mapToUserDetailsDto(userDetailsRepository.save(userDetails));
	}

	@Override
	public UserDetailsDto updateUserDetails(Long userId, UserDetailsDto userDetailsDto) {
		return mapper.mapToUserDetailsDto(userDetailsRepository.findById(userId).map(userDetails -> {
			userDetails.setEmail(userDetailsDto.getEmail());
			userDetails.setMobileNbr(userDetailsDto.getMobileNbr()); 
			return userDetailsRepository.save(userDetails);
		}).orElseThrow(() -> new ResourceNotFoundException("UserId " + userId + " not found")));
	}

}
