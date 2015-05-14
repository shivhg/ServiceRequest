package com.servreq.infra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.servreq.dbfw.DBFWException;
import com.servreq.dbfw.DBHelper;
import com.servreq.infra.domain.User;

public class UserDAO {

	private Connection establishConnection() throws InfraDAOException {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uName = "cs";
		String Upasd = "cs";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uName, Upasd);
		} catch (ClassNotFoundException e) {
			throw new InfraDAOException(e);
		} catch (SQLException e) {
			throw new InfraDAOException(e);
		}

		return con;

	}

	public User validateUser(int userId, String passwd)
			throws InfraDAOException {

		List<User> st = null;
		Connection con = establishConnection();

		try {
			st = (DBHelper.executeSelect(con, SqlMapper.SELECT_ALL_USER,
					SqlMapper.mapResult));
		} catch (DBFWException e) {
			throw new InfraDAOException("problem in select all user" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new InfraDAOException("Problem in closing connection" + e);
			}
		}

		for (User u : st) {
			if (u.getId() == userId && u.getPasswd().equals(passwd))
				return u;
		}
		return null;

	}
}
