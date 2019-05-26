package com.tcwgq.sax;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * SAX解析方式只能实现查询操作，不能实现增删改操作！ SAXParserFactory:抽象类，定义工厂 API，使应用程序能够配置和获取基于 SAX
 * 的解析器以解析 XML 文档。 通过newInstance()方法可以获取此类的实例。 SAXParser:定义包装 XMLReader 实现类的
 * API。此类的实例可由SAXParserFactory的newSAXParser()方法得到。
 * DefaultHandler:SAX2事件处理程序的默认基类。 public void characters(char[] ch, int start,
 * int length) throws SAXException:接收元素中字符数据的通知。 public void startElement(String
 * uri, String localName, String qName, Attributes attributes) throws
 * SAXException:接收元素开始的通知。 uri - 名称空间 URI，如果元素没有任何名称空间
 * URI，或者没有正在执行名称空间处理，则为空字符串。 localName - 本地名称（不带前缀），如果没有正在执行名称空间处理，则为空字符串。
 * qName - 限定的名称（带有前缀），如果限定的名称不可用，则为空字符串。 attributes - 附加到元素的属性。如果没有属性，则它将是空的
 * Attributes 对象。 public void endElement(String uri, String localName, String
 * qName) throws SAXException:接收元素结束的通知。
 * 
 * @author lenovo
 * 
 */
public class SAXTest {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser sp = spf.newSAXParser();
		File file = new File("people.xml");
		sp.parse(file, new MyDefaultHandler2());
	}
}
