package com.servreq.infra.domain;

import java.util.Date;

public class RequestDetails {
	private int reqId;
	private int userId;
	private int cubicleNo;
	private String department;
	private String location;
	private Date requiredByDate;
	private int reqTypeId;
	private String justification;
	private String rejectionReason;
	private String cancellationReason;
	private int statusId;
	private Date requestedDate;
	private Date assignedDate;
	private Date committedDate;
	private Date completedDate;

	public RequestDetails(int reqId, int reqTypeId, int statusId,
			Date requestedDate, Date assignedDate, Date committedDate,
			Date completedDate) {
		super();
		this.reqId = reqId;
		this.reqTypeId = reqTypeId;
		this.statusId = statusId;
		this.requestedDate = requestedDate;
		this.assignedDate = assignedDate;
		this.committedDate = committedDate;
		this.completedDate = completedDate;

	}

	public RequestDetails(int cubicleNo, String department, String location,
			int reqTypeId, String justification, int statusId, int userId,
			Date requiredByDate) {
		super();

		this.cubicleNo = cubicleNo;
		this.department = department;
		this.location = location;

		this.reqTypeId = reqTypeId;
		this.justification = justification;
		this.statusId = statusId;
		this.userId = userId;
		this.requiredByDate = requiredByDate;
	}

	public RequestDetails(int reqId, int cubicleNo, String location,
			String department, Date requiredByDate, int reqTypeId,
			String justification, String rejectionReason,
			String cancellationReason, int statusId, Date committedDate) {
		super();
		this.reqId = reqId;
		this.cubicleNo = cubicleNo;
		this.location = location;
		this.requiredByDate = requiredByDate;
		this.reqTypeId = reqTypeId;
		this.justification = justification;
		this.rejectionReason = rejectionReason;
		this.cancellationReason = cancellationReason;
		this.statusId = statusId;
		this.committedDate = committedDate;
		this.department = department;

	}

	public RequestDetails() {
		// TODO Auto-generated constructor stub
	}

	public boolean cancelRequest(int statusId, String cancellationReason) {
		// change status id and set cancellationreason;

		return false;
	}

	public void rejectRequest(int statusId, String rejectionReason) {
		// set rejection reason

	}

	public void completeRequest(int statusId, Date completedDate) {
		// set completed date
	}

	public void assignRequest(int statusId, Date committedDate) {
		// set commited date
	}

	public int getReqId() {
		return reqId;
	}

	public void setReqId(int reqId) {
		this.reqId = reqId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getCubicleNo() {
		return cubicleNo;
	}

	public void setCubicleNo(int cubicleNo) {
		this.cubicleNo = cubicleNo;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Date getRequiredByDate() {
		return requiredByDate;
	}

	public void setRequiredByDate(Date requiredByDate) {
		this.requiredByDate = requiredByDate;
	}

	public int getReqTypeId() {
		return reqTypeId;
	}

	public void setReqTypeId(int reqTypeId) {
		this.reqTypeId = reqTypeId;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public String getRejectionReason() {
		return rejectionReason;
	}

	public void setRejectionReason(String rejectionReason) {
		this.rejectionReason = rejectionReason;
	}

	public String getCancellationReason() {
		return cancellationReason;
	}

	public void setCancellationReason(String cancellationReason) {
		this.cancellationReason = cancellationReason;
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public Date getRequestedDate() {
		return requestedDate;
	}

	public void setRequestedDate(Date requestedDate) {
		this.requestedDate = requestedDate;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getCommittedDate() {
		return committedDate;
	}

	public void setCommittedDate(Date committedDate) {
		this.committedDate = committedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return (" ReqId         : " + reqId + "\n" + " User id         : "
				+ userId + "\n" + " Cub no          : " + cubicleNo + "\n"
				+ " Dept            : " + department + "\n"
				+ " Location        : " + location + "\n"
				+ " Req by date     : " + requiredByDate + "\n"
				+ " Req  type id    : " + reqTypeId + "\n"
				+ " Justification   : " + justification + "\n"
				+ " Rejection reasn : " + rejectionReason + "\n"
				+ " Cancel reason   : " + cancellationReason + "\n"
				+ " Requested date  : " + requestedDate + "\n"
				+ " Assigned date   : " + assignedDate + "\n"
				+ " Comited date    : " + committedDate + "\n"
				+ " Completed date  : " + completedDate + "\n"
				+ " Status id       : " + statusId + "\n" + "\n\n----------------------------------------------------------\n\n");

	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + (reqId + reqTypeId + statusId);

		return hash;

	}

	@Override
	public boolean equals(Object obj) {
		RequestDetails reqD = null;
		if (obj instanceof RequestDetails) {
			reqD = (RequestDetails) obj;

			return (this.reqId == reqD.getReqId()
					&& department == reqD.getDepartment()
					&& location == reqD.getLocation()
					&& reqTypeId == reqD.reqTypeId && statusId == reqD
					.getStatusId());

		} else {
			return false;
		}

	}
}
