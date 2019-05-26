package com.tcwgq.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * 打印出整个XML文档，由于解析过程中会吧空格换行都当成XML文档的一部分，所以不能使用println函数。
 * 
 * @author lenovo
 * 
 */
public class MyDefaultHandler extends DefaultHandler {
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		System.out.print("<" + qName + ">");
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.print("<" + qName + ">");
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.print(new String(ch, start, length));
	}
}
