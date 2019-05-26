package com.tcwgq.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * SimpleTagSupport类包装了SimpleTag类，里面提供了很多便捷方法
 * 
 * @author lenovo
 * 
 */
public class MyTag2 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("Hello Tag Two!");
	}
}
