package com.servreq.infra.dao;

public class InfraDAOException extends Exception {

	private static final long serialVersionUID = 1L;

	public InfraDAOException() {
	}

	public InfraDAOException(String message) {
		super(message);
	}

	public InfraDAOException(Throwable cause) {
		super(cause);

	}

	public InfraDAOException(String message, Throwable cause) {
		super(message, cause);

	}

}
