package com.servreq.infra.services;

import java.util.List;

import com.servreq.infra.dao.InfraDAOException;
import com.servreq.infra.dao.RequestDAO;
import com.servreq.infra.dao.StatusDAO;
import com.servreq.infra.dao.UserDAO;
import com.servreq.infra.domain.RequestDetails;
import com.servreq.infra.domain.User;

public class InfraSystemFacade {

	UserDAO ud = new UserDAO();
	User u1;
	RequestDAO rq = new RequestDAO();
	StatusDAO st = new StatusDAO();

	public User validateUser(int userId, String passwd)
			throws InfraAppException {

		try {

			u1 = ud.validateUser(userId, passwd);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return u1;

	}

	public List<RequestDetails> getRequestByCreator(final int userId)
			throws InfraAppException {
		List<RequestDetails> lt = null;
		try {
			lt = rq.getRequestByCreator(userId);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return lt;

	}

	public List<RequestDetails> getAllRequest() throws InfraAppException {

		List<RequestDetails> lt = null;
		try {
			lt = rq.getAllRequest();
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return lt;

	}

	public int createNewSR(final RequestDetails objSr) throws InfraAppException {
		int res = 0;
		try {
			res = rq.createNewSR(objSr);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return res;

	}

	public boolean saveSRDetails(final RequestDetails objSr)
			throws InfraAppException {
		boolean res = false;
		try {
			res = rq.saveSRDetails(objSr);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return res;
	}

	public List<RequestDetails> getStatusDetails(final int roleid,
			final int statusid) throws InfraAppException {
		List<RequestDetails> lt = null;
		try {
			lt = st.getStatusDetails(roleid, statusid);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return lt;
	}

	public RequestDetails getSRDetails(final int req_id)
			throws InfraAppException {
		RequestDetails rd = new RequestDetails();
		try {
			rd = rq.getSRDetails(req_id);
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return rd;

	}

	public List<User> getRequestTypes() throws InfraAppException {
		List<User> lt = null;
		try {
			lt = rq.getRequestTypes();
		} catch (InfraDAOException e) {

			throw new InfraAppException("problem from InfraSystemFacade" + e);
		}
		return lt;
	}

	public InfraSystemFacade(UserDAO ud, User u1, RequestDAO rq, StatusDAO st) {
		super();
		this.ud = ud;
		this.u1 = u1;
		this.rq = rq;
		this.st = st;
	}

	public InfraSystemFacade() {

	}

}
