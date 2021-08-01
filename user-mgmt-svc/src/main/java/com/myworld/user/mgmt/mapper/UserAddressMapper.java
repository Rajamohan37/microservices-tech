package com.myworld.user.mgmt.mapper;

import org.mapstruct.Mapper;

import com.myworld.user.mgmt.model.dto.UserAddressDto;
import com.myworld.user.mgmt.model.entity.UserAddress;

@Mapper
public interface UserAddressMapper {

	UserAddress mapToUserAddresses(UserAddressDto userAddressDto);

	UserAddressDto mapToUserAddressDto(UserAddress userAddress);
	
}
