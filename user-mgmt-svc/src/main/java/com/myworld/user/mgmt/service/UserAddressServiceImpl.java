package com.myworld.user.mgmt.service;

import java.util.List;
import java.util.stream.Collectors;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myworld.user.mgmt.mapper.UserAddressMapper;
import com.myworld.user.mgmt.mapper.UserDetailsMapper;
import com.myworld.user.mgmt.model.dto.UserAddressDto;
import com.myworld.user.mgmt.repo.UserAdressRepository;

@Service
public class UserAddressServiceImpl implements UserAddressService {

	private static final UserDetailsMapper USER_DETAILS_MAPPER = Mappers.getMapper(UserDetailsMapper.class);
	private static final UserAddressMapper USER_ADDRESS_MAPPER = Mappers.getMapper(UserAddressMapper.class);

	@Autowired
	private UserAdressRepository userAdressRepository;

	@Override
	public List<UserAddressDto> getUserAddresses(Long userId) {
		var userDetails = USER_DETAILS_MAPPER.createUserDetails(userId);
		return userAdressRepository.findByUserDetailsRef(userDetails).stream()
				.map(USER_ADDRESS_MAPPER::mapToUserAddressDto).collect(Collectors.toList());
	}

	@Override
	public UserAddressDto addUserAddresses(Long userId, UserAddressDto userAddressDto) {
		var userDetails = USER_DETAILS_MAPPER.createUserDetails(userId);
		var userAddress = USER_ADDRESS_MAPPER.mapToUserAddresses(userAddressDto);
		userAddress.setUserDetailsRef(userDetails);
		userAddress = userAdressRepository.save(userAddress);
		return USER_ADDRESS_MAPPER.mapToUserAddressDto(userAddress);
	}

	@Override
	public String removeUserAddresses(Long userId, UserAddressDto userAddressDto) {
		var userDetails = USER_DETAILS_MAPPER.createUserDetails(userId);
		var userAddress = USER_ADDRESS_MAPPER.mapToUserAddresses(userAddressDto);
		userAddress.setUserDetailsRef(userDetails);
		userAdressRepository.delete(userAddress); 
		return "Address " + userAddress.getId() + "DELETED successfully for user " + userId;
	}

}
