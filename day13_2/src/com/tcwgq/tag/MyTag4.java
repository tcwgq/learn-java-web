package com.tcwgq.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义标签，实现省略该标签下面其他内容
 * 
 * @author lenovo
 * 
 */
public class MyTag4 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("只能看到这里，下面什么也看不到！");
		throw new SkipPageException();
	}
}
