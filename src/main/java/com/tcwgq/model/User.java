package com.tcwgq.model;

/**
 * @author tcwgq
 * @time 2017年8月27日上午10:29:45
 * @email tcwgq@outlook.com
 */
public class User {
	private Integer id;
	private String username;
	private String password;
	private Integer money;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", money=" + money + "]";
	}

}
