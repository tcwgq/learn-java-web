package com.tcwgq.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 * 自定义带标签体的标签
 * 
 * @author lenovo
 * 
 */
public class MyTag3 extends SimpleTagSupport {
	@Override
	public void doTag() throws JspException, IOException {
		this.getJspContext().getOut().print("***************<br/>");
		this.getJspBody().invoke(this.getJspContext().getOut());
		this.getJspContext().getOut().print("<br/>***************");
	}
}
