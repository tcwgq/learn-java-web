package com.tcwgq.basedao;

//使用注解代替配置文件
@Table("t_user")
public class User {
	@ID("id")
	private int id;
	@Column("username")
	private String username;
	@Column("password")
	private String password;

	public User() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + "]";
	}

}
