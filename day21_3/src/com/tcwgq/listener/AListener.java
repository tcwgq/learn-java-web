package com.tcwgq.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 应用启动时创建map对象，用于保存数据
 * 
 * @author lenovo
 * 
 */
public class AListener implements ServletContextListener {
	// 应用启动时就创建map对象
	public void contextInitialized(ServletContextEvent sce) {
		Map<String, Integer> map = new LinkedHashMap<String, Integer>();
		ServletContext application = sce.getServletContext();
		application.setAttribute("map", map);
	}

	public void contextDestroyed(ServletContextEvent sce) {
	}

}
