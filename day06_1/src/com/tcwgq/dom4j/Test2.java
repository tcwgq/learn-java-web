package com.tcwgq.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 在特定位置添加节点，例如在第一个person的属性前添加<sex>男</sex>。
 * 
 * @author lenovo
 * 
 */
public class Test2 {
	public static void main(String[] args) throws Exception {
		addElement();
	}

	public static void addElement() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("people.xml"));
		Element root = document.getRootElement();
		Element person = root.element("person");
		List<Element> list = person.elements();
		// 使用DocumentHelper创建新元素，里面的方法都是静态方法。
		// DocumentHelper is a collection of helper methods for using DOM4J.
		Element element = DocumentHelper.createElement("sex");
		element.addText("男");
		list.add(1, element);
		writeChinese(document);
	}

	// 文档中包含中文
	public static void writeChinese(Document document) throws Exception {
		// A static helper method to create the default compact format.
		OutputFormat compact = OutputFormat.createCompactFormat();
		// 创建文件输出的时候，自动缩进的格式
		// A static helper method to create the default pretty printing format.
		OutputFormat pretty = OutputFormat.createPrettyPrint();
		// 设置编码
		pretty.setEncoding("utf-8");
		XMLWriter writer = new XMLWriter(new FileWriter("people.xml"), pretty);
		writer.write(document);
		writer.close();
	}
}
