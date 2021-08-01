package com.myworld.user.mgmt.exception;

public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 7904567229119350987L;
	
	public ResourceNotFoundException(String message) {
		super(message);
	}

}
