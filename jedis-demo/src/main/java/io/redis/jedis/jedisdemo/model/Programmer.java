package io.redis.jedis.jedisdemo.model;

import java.io.Serializable;
import java.util.Objects;

public class Programmer implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String company;
	private String name;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Programmer other = (Programmer) obj;
		return Objects.equals(company, other.company) && id == other.id && Objects.equals(name, other.name);
	}

	public String getCompany() {
		return company;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, id, name);
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

}
