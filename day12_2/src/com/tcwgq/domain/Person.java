package com.tcwgq.domain;

/**
 * javabean规范，到网上看资料
 * 
 * @author lenovo
 * 
 */
public class Person {
	private Integer id;
	private String name;
	private boolean flag;

	public Person() {

	}

	public Person(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// boolean类型的get或is开头都可以
	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", flag=" + flag + "]";
	}

}
