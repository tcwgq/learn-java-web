package com.tcwgq.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 监听器
 * 
 * @author lenovo
 * 
 */
public class AListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("哈哈哈哈，我来也！");
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("哇哇哇哇，我要死了！");
	}

}
