package com.nttdata.dbfw;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBHelper {

	public static int executeUpdate(Connection con, String query,
			ParamMapper inMap) throws DBFWException {
		int result = -1;
		PreparedStatement pStmt = null;
		try {
			pStmt = con.prepareStatement(query);
			inMap.mapParams(pStmt);
			result = pStmt.executeUpdate();
		} catch (SQLException e) {
			throw new DBFWException("Problem in db helper execute Update" + e);
		} finally {
			if (pStmt != null) {
				try {
					pStmt.close();
				} catch (SQLException e) {
					throw new DBFWException(
							"Problem in closing prepared statement" + e);
				}
			}

		}

		return result;

	}

	@SuppressWarnings("unchecked")
	public static List executeSelect(Connection con, String query,
			ParamMapper inMap, ResultMapper outMap) throws DBFWException {

		List lt = new ArrayList();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(query);
			inMap.mapParams(pstm);
			rs = pstm.executeQuery();
			while (rs.next()) {
				Object obj = outMap.mapRows(rs);
				lt.add(obj);

			}
		} catch (SQLException e) {
			throw new DBFWException("Problem in db helper execute Update" + e);
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					throw new DBFWException(
							"Problem in closing prepared statement" + e);
				}
			}

		}

		return lt;
	}

	@SuppressWarnings("unchecked")
	public static List executeSelect(Connection con, String query,
			ResultMapper outMap) throws DBFWException {
		List lt = new ArrayList();
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			pstm = con.prepareStatement(query);

			rs = pstm.executeQuery();
			while (rs.next()) {
				Object obj = outMap.mapRows(rs);
				lt.add(obj);

			}
		} catch (SQLException e) {
			throw new DBFWException("Problem in db helper execute Update" + e);
		} finally {
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					throw new DBFWException(
							"Problem in closing prepared statement" + e);
				}
			}

		}

		return lt;
	}

	public Object executeProc(Connection con, String query, ParamMapper inMap,
			OutTypeMapper outType, OutParamMapper outParam)
			throws DBFWException {
		Object obj = null;
		CallableStatement cStmt = null;

		try {
			cStmt = con.prepareCall(query);
			if (inMap != null) {
				inMap.mapParams(cStmt);
			}
			if (outType != null) {
				outType.mapOutType(cStmt);
			}
			cStmt.execute();
			if (outParam != null) {
				obj = outParam.mapOutParam(cStmt);
			}
		} catch (SQLException e) {
			throw new DBFWException("Problem in db helper execute Update" + e);
		} finally {
			if (cStmt != null) {
				try {
					cStmt.close();
				} catch (SQLException e) {
					throw new DBFWException(
							"Problem in closing prepared statement" + e);
				}
			}

		}
		return obj;

	}

}
