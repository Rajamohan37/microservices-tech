package com.myworld.user.mgmt.model.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.myworld.user.mgmt.model.entity.UserAddress;

import lombok.Data;

@Data
public class UserDetailsDto {
	
	private Long id;
	
	private String fName;
	
	private String lName;

	private String userName;

	private String password;

	private String email;

	private Long mobileNbr;
	
	private boolean isActiveUser;
	
	@JsonIgnore
	private List<UserAddress> userAddresses;

}
