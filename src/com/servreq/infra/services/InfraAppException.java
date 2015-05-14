package com.servreq.infra.services;

public class InfraAppException extends Exception {

	private static final long serialVersionUID = 1L;

	public InfraAppException() {
		super();

	}

	public InfraAppException(String message) {
		super(message);

	}

	public InfraAppException(Throwable cause) {
		super(cause);

	}

	public InfraAppException(String message, Throwable cause) {
		super(message, cause);

	}

}
