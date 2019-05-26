package com.tcwgq.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

/**
 * 监听器
 * 
 * @author lenovo
 * 
 */
public class BListener implements ServletContextAttributeListener {

	public void attributeAdded(ServletContextAttributeEvent e) {
		System.out.println("添加属性了");
		System.out.println("名为：" + e.getName());
		System.out.println("值为：" + e.getValue());
	}

	public void attributeReplaced(ServletContextAttributeEvent e) {
		System.out.println("属性值被替换了");
		// 属性的旧值
		System.out.println(e.getName() + "=" + e.getValue());
		// 属性的新值
		System.out.println(e.getServletContext().getAttribute(e.getName()));
	}

	public void attributeRemoved(ServletContextAttributeEvent e) {
		System.out.println("属性被移除了");
		System.out.println(e.getName() + "=" + e.getValue());
	}

}
