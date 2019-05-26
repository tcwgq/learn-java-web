package com.tcwgq.domain;

public class City {
	private Integer cid;
	private String name;
	private Province province;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Province getProvince() {
		return province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	@Override
	public String toString() {
		return "City [cid=" + cid + ", name=" + name + ", province=" + province
				+ "]";
	}

}
