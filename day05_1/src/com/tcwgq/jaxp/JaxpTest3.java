package com.tcwgq.jaxp;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * 修改节点 下面这种方法虽然能实现对节点的修改，但是对XML格式有所要求
 * 
 * @author lenovo
 * 
 */
public class JaxpTest3 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File("people.xml");
		Document doc = db.parse(file);
		Node node = doc.getElementsByTagName("person").item(0);
		NodeList list = node.getChildNodes();
		Node name = list.item(0);
		name.setTextContent("张三");
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.transform(new DOMSource(doc),
				new StreamResult(new File("people.xml")));
	}
}
