package com.myworld.user.mgmt.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.myworld.user.mgmt.model.dto.UserDetailsDto;
import com.myworld.user.mgmt.model.entity.UserDetails;

@Mapper(uses = UserAddressMapper.class)
public interface UserDetailsMapper {
	
	UserDetails mapToUserDetails(UserDetailsDto userDetailsDto);
	
	UserDetailsDto mapToUserDetailsDto(UserDetails userDetails);
	
	@Mapping(target = "id")
	UserDetails createUserDetails(Long id);

}
