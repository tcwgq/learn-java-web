package com.tcwgq.domain;

import java.util.ArrayList;
import java.util.List;

public class Province {
	private Integer pid;
	private String name;
	private List<City> cities = new ArrayList<City>();

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Province [pid=" + pid + ", name=" + name + ", cities=" + cities
				+ "]";
	}

}
