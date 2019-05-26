package com.tcwgq.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 查询所有<name>标签的值。 
 * Document:Document defines an XML Document. public Element
 * getRootElement():Returns the root Elementfor this document. Node:Node defines
 * the polymorphic behavior for all XML nodes in a dom4j tree. public String
 * getName()getName returns the name of this node. public short
 * getNodeType()Returns the code according to the type of node. public String
 * getNodeTypeName()DOCUMENT ME! Returns:the name of the type of node such as
 * "Document", "Element", "Attribute" or "Text" public Element
 * getParent()getParent returns the parent Element. public String
 * getText()Returns the text of this node. public void setText(String text)Sets
 * the text data of this node or this method will throw an
 * UnsupportedOperationException if it is read-only. public List
 * elements()Returns the elements contained in this element. public List
 * elements(String name)Returns the elements contained in this element with the
 * given local name and any namespace. public Element element(QName
 * qName)Returns the first element for the given fully qualified name. public
 * Element element(String name)Returns the first element for the given local
 * name and any namespace.
 */
public class Test {
	public static void main(String[] args) throws Exception {
		// selectAll();
		// selectFirst();
		selectSecond();
	}

	private static void selectAll() throws DocumentException {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("people.xml"));
		Element root = document.getRootElement();
		List<?> list = root.elements("person");
		Iterator<?> it = list.iterator();
		while (it.hasNext()) {
			Element person = (Element) it.next();
			Element name = person.element("name");
			System.out.println(name.getText());
		}
	}

	public static void selectFirst() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("people.xml"));
		Element root = document.getRootElement();
		Element person = root.element("person");
		Element name = person.element("name");
		System.out.println(name.getText());
	}

	public static void selectSecond() throws Exception {
		SAXReader reader = new SAXReader();
		Document document = reader.read(new File("people.xml"));
		Element root = document.getRootElement();
		List<?> list = root.elements("person");
		Element person = (Element) list.get(1);
		Element name = person.element("name");
		System.out.println(name.getText());
	}
}
