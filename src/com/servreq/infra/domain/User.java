package com.servreq.infra.domain;

public class User {
	private int id;
	private String passwd;
	private String name;
	private int roleId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public User(int id, String passwd, String name, int roleId) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.name = name;
		this.roleId = roleId;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return roleId + "";
	}

}
