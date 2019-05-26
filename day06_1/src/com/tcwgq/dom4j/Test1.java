package com.tcwgq.dom4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

/**
 * 在末尾添加节点
 * 
 * @author lenovo
 * 
 */
public class Test1 {
	public static void main(String[] args) throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("people.xml"));
		Element people = document.getRootElement();
		Element person = people.element("person");
		Element sex = person.addElement("sex");
		sex.setText("男");
		// 添加完成之后一定要回写！！！
		writeChinese(document);
	}

	// 文档中不包含中文
	public void write(Document document) throws Exception {
		XMLWriter writer = new XMLWriter(new FileWriter("people.xml"));
		writer.write(document);
		writer.close();
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
