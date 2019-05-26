package com.tcwgq.listener;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * session的钝化和活化
 * 
 * @author lenovo
 * 
 */
public class User implements HttpSessionActivationListener, Serializable {
	private static final long serialVersionUID = 1L;
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
	public void sessionWillPassivate(HttpSessionEvent se) {
		// 钝化
		System.out.println("哈哈哈，我和session一起钝化了");
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		// 活化
		System.out.println("哇哇哇，我和session一起活化了");
	}

}
