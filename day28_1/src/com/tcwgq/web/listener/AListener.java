package com.tcwgq.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class AListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("哇，我要死了，呜呜呜！");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("哈哈，我出生了，好高兴！");
	}

}
