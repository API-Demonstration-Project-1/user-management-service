package com.toystore.ecomm.users.multitenant.exception;

public class TenantResolvingException extends Exception {
	public TenantResolvingException(Throwable throwable, String message) {
		super(message, throwable);
	}
}
