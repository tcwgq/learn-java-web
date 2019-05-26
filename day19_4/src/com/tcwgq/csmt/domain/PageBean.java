package com.tcwgq.csmt.domain;

import java.util.List;

public class PageBean<T> {
	private int pc;// pageCurrent
	// private int tp;// totalPages
	private int tr;// totalRecords
	private int ps;// pageSize
	private String url;// 用户条件查询时传递参数
	private List<T> beanList;

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
	}

	public int getTp() {
		int pages = tr / ps;
		return tr % ps == 0 ? pages : pages + 1;
	}

	// public void setTp(int tp) {
	// this.tp = tp;
	// }

	public int getTr() {
		return tr;
	}

	public void setTr(int tr) {
		this.tr = tr;
	}

	public int getPs() {
		return ps;
	}

	public void setPs(int ps) {
		this.ps = ps;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<T> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}

}
