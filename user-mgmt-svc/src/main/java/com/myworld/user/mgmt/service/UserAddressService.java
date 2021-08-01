package com.myworld.user.mgmt.service;

import java.util.List;

import com.myworld.user.mgmt.model.dto.UserAddressDto;

public interface UserAddressService {

	List<UserAddressDto> getUserAddresses(Long userId);

	UserAddressDto addUserAddresses(Long userId, UserAddressDto userAddressDto);

	String removeUserAddresses(Long userId, UserAddressDto userAddressDto);   
	
}
