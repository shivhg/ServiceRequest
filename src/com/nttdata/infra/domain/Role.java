package com.nttdata.infra.domain;

public class Role {
	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Role(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id " + id + "\n" + "name " + name;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + id;

		return hash;

	}

	@Override
	public boolean equals(Object obj) {
		Role role = null;
		if (obj instanceof Role) {
			role = (Role) obj;
			return (this.id == role.getId() && this.name == role.getName());
		} else {
			return false;
		}

	}

}
