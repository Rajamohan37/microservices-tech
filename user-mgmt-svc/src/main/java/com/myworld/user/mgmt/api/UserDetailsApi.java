package com.myworld.user.mgmt.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myworld.user.mgmt.model.dto.UserDetailsDto;
import com.myworld.user.mgmt.service.UserDetailsService;

@RestController
@RequestMapping("/users")
public class UserDetailsApi {

	@Autowired
	private UserDetailsService userDetailsService;

	@GetMapping
	public List<UserDetailsDto> getAllUser() {
		return userDetailsService.getAllUsers();
	}

	@PostMapping
	public UserDetailsDto saveUser(@RequestBody UserDetailsDto userDetailsDto) {
		return userDetailsService.addUser(userDetailsDto);
	}

	@PutMapping("/{userId}")
	public UserDetailsDto updateUserDetails(@PathVariable Long userId, @RequestBody UserDetailsDto userDetailsDto) {
		return userDetailsService.updateUserDetails(userId, userDetailsDto);
	}

}
