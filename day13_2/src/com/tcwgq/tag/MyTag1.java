package com.tcwgq.tag;

import java.io.IOException;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;

/**
 * 自定义标签一
 * 没有标签体
 * @author lenovo
 * 
 */
public class MyTag1 implements SimpleTag {
	private PageContext pageContext;
	private JspFragment jspBody;
	private JspTag parent;

	/**
	 * 所有的setXXX方法都会在执行doTag()方法前被tomcat调用
	 * 每次使用标签，都会服务器都会调用doTag()方法
	 */
	@Override
	public void doTag() throws JspException, IOException {
		this.pageContext.getOut().print("Hello Tag!");
	}

	@Override
	public void setParent(JspTag parent) {
		this.parent = parent;
	}

	@Override
	public JspTag getParent() {
		return parent;
	}

	@Override
	public void setJspContext(JspContext pc) {
		this.pageContext = (PageContext) pc;
	}

	@Override
	public void setJspBody(JspFragment jspBody) {
		this.jspBody = jspBody;
	}

}
