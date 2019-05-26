package com.tcwgq.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 打印出所有的<name>标签的值。
 * 
 * @author lenovo
 * 
 */
public class MyDefaultHandler1 extends DefaultHandler {
	private boolean flag = false;

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		if ("name".equals(qName)) {
			flag = true;
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		if ("name".equals(qName)) {
			flag = false;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		if (flag == true) {
			System.out.println(new String(ch, start, length));
		}
	}
}
