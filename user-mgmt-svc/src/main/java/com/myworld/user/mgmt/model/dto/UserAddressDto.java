package com.myworld.user.mgmt.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressDto {

	private Long id;
	
	@JsonIgnore
	private UserDetailsDto userDetailsRef;

	private String houseNbr;

	private String streetName;

	private String locality;

	private String city;

	private String district;

	private String state;

	private String country;
	
	private String pincode;

}
