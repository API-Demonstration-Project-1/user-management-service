package com.toystore.ecomm.users.multitenant.exception;

public class TenantNotFoundException extends Exception {
	public TenantNotFoundException(String message) {
		super(message);
	}
}
