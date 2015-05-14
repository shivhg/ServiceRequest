package com.servreq.infra.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.servreq.dbfw.ResultMapper;
import com.servreq.infra.domain.RequestDetails;
import com.servreq.infra.domain.RequestType;
import com.servreq.infra.domain.Status;
import com.servreq.infra.domain.User;

public class SqlMapper {

	public static final String INSERT_REQUEST = "insert into sr_details (req_id,user_id,location,CUBICAL_NO,department,REQUIRED_BY_DATE,REQ_TYPEID,REQUESTED_DATE,JUSTIFICATION,STATUS_ID) values (Req.NEXTVAL,?,?,?,?,?,?,sysdate,?,?)";
	public static final String UPDATE_REQUEST_APPROVE = "update sr_details set ASSIGNED_DATE=sysdate , COMMITTED_DATE=? , STATUS_ID=3 where REQ_ID = ?";

	public static final String UPDATE_REQUEST_REJECT = "update sr_details set REJECTION_REASON=?,STATUS_ID=4 where REQ_ID = ?";

	public static final String UPDATE_REQUEST_COMPLETE = "update sr_details set COMPLETED_DATE=?, STATUS_ID=5 where REQ_ID = ?";

	public static final String UPDATE_REQUEST_CANCEL = "update sr_details set CANCELLATION_REASON=?, STATUS_ID=2 where REQ_ID = ?";

	public static final String SELECT_ALL_USER = "select * from users";
	public static final String SELECT_USER = "select * from sr_details where USER_ID=?";
	public static final String SELECT_REQID = "select max(REQ_ID) from sr_details ";
	// public static final String INSERT_REQUEST = "select *From sr_details
	// where studentid=?";

	public static final String SELECT_ALL_REQUEST_TYPE = "select *From request_type";
	public static final String SELECT_ALL_REQ = "select * from sr_details";

	public static final String SELECT_SPEC_REQUEST_TYPE = "select *From sr_details where REQ_ID=?";

	public static final String SELECT_STATUS_DETAILS = "select *From STATUS where STATUS_ID!=? and ROLE_ID= ?";

	public static final String SELECT_ROLEID = "SELECT ROLE_ID FROM users WHERE USER_ID = ?";

	public static ResultMapper mapResult = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			User s = new User();
			s.setId(rs.getInt(1));
			s.setName(rs.getString(2));
			s.setPasswd(rs.getString(3));
			s.setRoleId(rs.getInt(4));
			return s;
		}
	};

	public static ResultMapper mapReId = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			RequestDetails rd = new RequestDetails();
			rd.setReqId(rs.getInt(1));
			return rd;
		}
	};

	public static ResultMapper mapTypes = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			RequestType s = new RequestType();
			s.setId(rs.getInt(1));
			s.setDesc(rs.getString(2));
			return s;
		}
	};

	public static ResultMapper mapRequest = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			RequestDetails rd = new RequestDetails();
			rd.setReqId(rs.getInt(1));
			rd.setUserId(rs.getInt(2));
			rd.setLocation(rs.getString(3));
			rd.setCubicleNo(rs.getInt(4));
			rd.setDepartment(rs.getString(5));
			rd.setRequiredByDate(rs.getDate(6));
			rd.setReqTypeId(rs.getInt(7));
			rd.setRejectionReason(rs.getString(8));
			rd.setCancellationReason(rs.getString(9));
			rd.setRequestedDate(rs.getDate(10));
			rd.setAssignedDate(rs.getDate(11));
			rd.setCommittedDate(rs.getDate(12));
			rd.setCompletedDate(rs.getDate(13));
			rd.setJustification(rs.getString(14));
			rd.setStatusId(rs.getInt(15));
			return rd;
		}
	};

	public static ResultMapper statusOpt = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			Status s = new Status();
			s.setStatusId(rs.getInt(1));
			s.setRole(rs.getInt(2));
			s.setStatusDesc(rs.getString(3));
			return s;
		}
	};

	public static ResultMapper roleMap = new ResultMapper() {
		public Object mapRows(ResultSet rs) throws SQLException {
			User u = new User();
			u.setRoleId(rs.getInt(1));
			return u;

		}
	};
}
