package com.tcwgq.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 监听器
 * 
 * @author lenovo
 * 
 */
public class User implements HttpSessionBindingListener {
	private String username;
	private String password;

	public User() {

	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
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
		return "User [username=" + username + ", password=" + password + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("哈哈哈~，我被添加到session中了！");
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("哇哇哇~，我被移出session了！");
	}

}
