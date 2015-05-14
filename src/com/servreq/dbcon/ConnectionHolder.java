package com.servreq.dbcon;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;

public final class ConnectionHolder {
	/**
	 * This class is used to obtaing the connection from the Database
	 */
	private static ConnectionHolder instance = null;

	private DataSource ds = null;

	// public static final Logger logger = Logger
	// .getLogger(ConnectionHolder.class);

	// Private constuctor ( used to avoid creation of multiple instances)
	private ConnectionHolder() {

		// private Constructor
	}

	// Getting the pre-created instance of the class
	public static ConnectionHolder getInstance() throws DBConnectionException {

		synchronized (ConnectionHolder.class) {
			if (instance == null) {
				instance = new ConnectionHolder();
				instance.initAppserverDataSource();
			}
		}
		return instance;
	}

	private void initAppserverDataSource() throws DBConnectionException {
		Context initContext;

		try {
			initContext = new InitialContext();
			Context envContext = (Context) initContext.lookup("java:/comp/env");
			ds = (DataSource) envContext.lookup("jdbc/MyDB");

		} catch (NamingException e) {
			throw new DBConnectionException("Unable to get datasource", e);
		}

	}

	// Getting Connection from the connection holder
	public Connection getConnection() throws DBConnectionException {

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			final String exception = "Unable to obtain a connection";
			// logger.debug(exception, e);
			throw new DBConnectionException(exception, e);
		}
	}

	// Method is called while closing the application
	public void dispose() throws DBConnectionException {
		BasicDataSource bds = (BasicDataSource) ds;
		try {
			bds.close();
		} catch (SQLException e) {
			final String exception = "Unable to close the connection";
			// logger.debug(exception, e);
			throw new DBConnectionException(exception);
		}
	}

}
