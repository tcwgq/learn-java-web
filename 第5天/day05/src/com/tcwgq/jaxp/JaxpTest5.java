package com.tcwgq.jaxp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 遍历节点
 * 
 * @author lenovo
 * 
 */
public class JaxpTest5 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File("people.xml");
		Document document = db.parse(file);
		traverse(document);
	}

	private static void traverse(Node node) {
		if (node.getNodeType() == Node.ELEMENT_NODE) {
			System.out.println(node.getNodeName());
		}
		NodeList list = node.getChildNodes();
		for (int i = 0; i < list.getLength(); i++) {
			Node childNode = list.item(i);
			traverse(childNode);
		}
	}
}
