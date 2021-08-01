package com.myworld.user.mgmt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworld.user.mgmt.model.dto.UserAddressDto;
import com.myworld.user.mgmt.service.UserAddressService;

@RestController
@RequestMapping("/users")
public class UserAddressApi {

	@Autowired
	private UserAddressService userAddressService;

	@GetMapping("/{userId}/addresses")
	public List<UserAddressDto> getUserAddresses(@PathVariable Long userId) {
		return userAddressService.getUserAddresses(userId);
	}

	@PostMapping("/{userId}/addresses")
	public UserAddressDto addUserAddress(@PathVariable Long userId, @RequestBody UserAddressDto userAddressDto) {
		return userAddressService.addUserAddresses(userId, userAddressDto);
	}
	
	@DeleteMapping("/{userId}/addresses")
	public String removeUserAddress(@PathVariable Long userId, @RequestBody UserAddressDto userAddressDto) {
		return userAddressService.removeUserAddresses(userId, userAddressDto);
	}

}
