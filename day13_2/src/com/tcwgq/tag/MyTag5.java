package com.tcwgq.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义标签之带属性的标签
 * 
 * @author lenovo
 * 
 */
public class MyTag5 extends SimpleTagSupport {
	private boolean test;

	/**
	 * 这个方法会在doTag()之前执行
	 * 
	 * @param test
	 */
	public void setTest(boolean test) {
		this.test = test;
	}

	@Override
	public void doTag() throws JspException, IOException {
		if (test) {
			this.getJspBody().invoke(null);// 如果传递的输出流为null，表示使用的就是当前页面的out。
		}
	}
}
