package com.nttdata.infra.domain;

public class Status {
	private int statusId;
	private String statusDesc;
	private int role;

	public Status(int statusId, String statusDesc) {
		super();
		this.statusId = statusId;
		this.statusDesc = statusDesc;
	}

	public Status() {
		// TODO Auto-generated constructor stub
	}

	public int getStatusId() {
		return statusId;
	}

	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}

	public String getStatusDesc() {
		return statusDesc;
	}

	public void setStatusDesc(String statusDesc) {
		this.statusDesc = statusDesc;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return statusId + "  " + statusId + "\n" + "status description"
				+ statusDesc;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + statusId;

		return hash;

	}

	@Override
	public boolean equals(Object obj) {
		Status stus = null;
		if (obj instanceof Status) {

			stus = (Status) obj;
			return (this.statusId == stus.statusId);
		}
		return false;

	}

}
