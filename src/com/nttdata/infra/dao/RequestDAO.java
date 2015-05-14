package com.nttdata.infra.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.nttdata.dbfw.DBFWException;
import com.nttdata.dbfw.DBHelper;
import com.nttdata.dbfw.ParamMapper;
import com.nttdata.infra.domain.RequestDetails;
import com.nttdata.infra.domain.User;

public class RequestDAO {
	private Connection establishConnection() throws InfraDAOException {
		Connection con = null;
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uName = "cs";
		String Upasd = "cs";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, uName, Upasd);
		} catch (ClassNotFoundException e) {
			throw new InfraDAOException(
					"Could not find the jdbc class check driver" + e);

		} catch (SQLException e) {
			throw new InfraDAOException(
					"Check user name and password error in getCOnnection" + e);
		}

		return con;

	}

	public List<RequestDetails> getRequestByCreator(final int userId)
			throws InfraDAOException {

		List<RequestDetails> st = null;
		Connection con = establishConnection();
		ParamMapper iMap = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement pstm) throws SQLException {
				pstm.setInt(1, userId);

			}
		};
		try {
			st = DBHelper.executeSelect(con, SqlMapper.SELECT_USER, iMap,
					SqlMapper.mapRequest);
		} catch (DBFWException e) {
			throw new InfraDAOException("Problem in getRequestByCreator" + e);
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

	public boolean saveSRDetails(final RequestDetails objSr)
			throws InfraDAOException {

		List<User> lt = null;
		int roleId = -1;
		Connection con = establishConnection();

		final int uid = objSr.getUserId();

		ParamMapper roleMap = new ParamMapper() {
			public void mapParams(PreparedStatement stmt) throws SQLException {
				stmt.setInt(1, uid);
			}
		};

		try {
			lt = DBHelper.executeSelect(con, SqlMapper.SELECT_ROLEID, roleMap,
					SqlMapper.roleMap);
			User usr = lt.get(0);
			roleId = usr.getRoleId();

		} catch (DBFWException e) {
			throw new InfraDAOException("Problem in savesrDetails selectRoleId"
					+ e);
		}

		int res = -1;

		try {
			if (roleId == 2 && objSr.getStatusId() == 3) {

				ParamMapper studMap = new ParamMapper() {
					public void mapParams(PreparedStatement stmt)
							throws SQLException {

						stmt.setDate(1, (Date) objSr.getCommittedDate());
						stmt.setInt(2, objSr.getReqId());
					}
				};

				res = DBHelper.executeUpdate(con,
						SqlMapper.UPDATE_REQUEST_APPROVE, studMap);
			}

			else if (roleId == 2 && objSr.getStatusId() == 5) {

				ParamMapper studMap1 = new ParamMapper() {

					public void mapParams(PreparedStatement stmt)
							throws SQLException {

						stmt.setDate(1, (Date) objSr.getCompletedDate());

						stmt.setInt(2, objSr.getReqId());
					}
				};

				res = DBHelper.executeUpdate(con,
						SqlMapper.UPDATE_REQUEST_COMPLETE, studMap1);
			}

			else if (roleId == 2 && objSr.getStatusId() == 4) {

				ParamMapper studMap1 = new ParamMapper() {

					public void mapParams(PreparedStatement stmt)
							throws SQLException {

						stmt.setString(1, objSr.getRejectionReason());

						stmt.setInt(2, objSr.getReqId());
					}
				};

				res = DBHelper.executeUpdate(con,
						SqlMapper.UPDATE_REQUEST_REJECT, studMap1);
			} else if (objSr.getStatusId() == 2) {

				ParamMapper studMap1 = new ParamMapper() {

					public void mapParams(PreparedStatement stmt)
							throws SQLException {

						stmt.setString(1, objSr.getCancellationReason());

						stmt.setInt(2, objSr.getReqId());
					}
				};

				res = DBHelper.executeUpdate(con,
						SqlMapper.UPDATE_REQUEST_CANCEL, studMap1);
			}

		} catch (DBFWException e) {
			throw new InfraDAOException(
					"Problem in savesrDetails update statements" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new InfraDAOException("Problem in closing connection" + e);
			}
		}

		if (res != -1) {
			return true;
		} else {
			return false;
		}

	}

	public RequestDetails getSRDetails(final int req_id)
			throws InfraDAOException {

		List<RequestDetails> st = null;
		Connection con = establishConnection();
		ParamMapper iMap = new ParamMapper() {
			@Override
			public void mapParams(PreparedStatement pstm) throws SQLException {
				pstm.setInt(1, req_id);

			}
		};
		try {
			st = DBHelper.executeSelect(con,
					SqlMapper.SELECT_SPEC_REQUEST_TYPE, iMap,
					SqlMapper.mapRequest);
		} catch (DBFWException e) {
			throw new InfraDAOException(
					"Problem in getsrDetails select specific request" + e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new InfraDAOException("Problem in closing connection" + e);
			}
		}
		if (st.size() == 0) {
			throw new InfraDAOException(
					"Problem in getsrDetails select specific request");
		} else {
			return st.get(0);
		}
	}

	public List<User> getRequestTypes() throws InfraDAOException {

		List<User> st = null;
		Connection con = establishConnection();

		try {
			st = (DBHelper.executeSelect(con,
					SqlMapper.SELECT_ALL_REQUEST_TYPE, SqlMapper.mapTypes));
		} catch (DBFWException e) {

			throw new InfraDAOException(
					"Problem in getsrDetails select all request" + e);
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

	public int createNewSR(final RequestDetails objSr) throws InfraDAOException {

		int res = -1;
		Connection con = establishConnection();
		ParamMapper studMap = new ParamMapper() {
			public void mapParams(PreparedStatement stmt) throws SQLException {

				stmt.setInt(3, objSr.getCubicleNo());
				stmt.setString(4, objSr.getDepartment());
				stmt.setString(2, objSr.getLocation());
				stmt.setDate(5, (Date) objSr.getRequiredByDate());
				stmt.setInt(6, objSr.getReqTypeId());
				stmt.setString(7, objSr.getJustification());
				stmt.setInt(8, objSr.getStatusId());
				stmt.setInt(1, objSr.getUserId());
			}
		};
		try {
			res = DBHelper
					.executeUpdate(con, SqlMapper.INSERT_REQUEST, studMap);
		} catch (DBFWException e) {
			throw new InfraDAOException("Problem in createnewsr insert request"
					+ e);
		}
		int re = 0;
		List<RequestDetails> lt = new ArrayList();
		try {
			lt = DBHelper.executeSelect(con, SqlMapper.SELECT_REQID,
					SqlMapper.mapReId);
		} catch (DBFWException e) {
			throw new InfraDAOException("Problem in createnewsr select reqid"
					+ e);
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				throw new InfraDAOException("Problem in closing connection" + e);
			}
		}
		for (RequestDetails r : lt) {
			re = r.getReqId();
		}

		return re;

		// return 0;
	}

	public List<RequestDetails> getAllRequest() throws InfraDAOException {
		List<RequestDetails> st = null;
		Connection con = establishConnection();

		try {
			st = DBHelper.executeSelect(con, SqlMapper.SELECT_ALL_REQ,
					SqlMapper.mapRequest);
		} catch (DBFWException e) {
			throw new InfraDAOException("Problem in getallRequest" + e);
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
