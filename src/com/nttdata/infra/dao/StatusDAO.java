package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.infra.domain.RequestDetails;

public class StatusDAO {

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

	public List<RequestDetails> getStatusDetails(final int roleid,
			final int statusid) throws InfraDAOException {
		List<RequestDetails> st = null;
		Connection con = establishConnection();
		ParamMapper iMap = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement pstm) throws SQLException {
				pstm.setInt(2, roleid);
				pstm.setInt(1, statusid);

			}
		};
		try {
			st = DBHelper.executeSelect(con, SqlMapper.SELECT_STATUS_DETAILS,
					iMap, SqlMapper.statusOpt);
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
		return st;

	}

}
