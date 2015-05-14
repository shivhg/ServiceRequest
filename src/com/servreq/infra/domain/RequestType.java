package com.servreq.infra.domain;

public class RequestType {
	private int id;
	private String desc;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public RequestType(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public RequestType() {

	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return ("req id " + id + "  type " + desc + "\n");
	}

	public int hashCode() {

		return 31 * id;
	}

	@Override
	public boolean equals(Object obj) {
		RequestType reqD = null;
		if (obj instanceof RequestType) {
			reqD = (RequestType) obj;

			return (this.id == reqD.id);

		} else {
			return false;
		}

	}
}
