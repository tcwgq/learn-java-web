package com.tcwgq.dom4j;

import java.util.Iterator;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;

import com.tcwgq.utils.Dom4jUtils;

/**
 * 与属性相关的操作，如获取第一个person的ID属性的值。
 * 
 * @author lenovo
 * 
 */
public class Test6 {
	public static void main(String[] args) {
		// getAttribute();
		// setAttribute();
		// removeAttribute();
		// addAttribute();
		traverseAttribute();
	}

	private static void getAttribute() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Attribute id = person.attribute("id");
		System.out.println(id.getText());
	}

	private static void setAttribute() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Attribute id = person.attribute("id");
		id.setText("11111");
		Dom4jUtils.write("people.xml", document);
	}

	private static void removeAttribute() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Attribute id = person.attribute("id");
		person.remove(id);
		Dom4jUtils.write("people.xml", document);
	}

	private static void addAttribute() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		person.addAttribute("sex", "男");
		Dom4jUtils.write("people.xml", document);
		// 也可使用DocumentHelper先创建一个新属性，然后再添加进去。
	}

	private static void traverseAttribute() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Iterator<Attribute> it = person.attributeIterator();
		while (it.hasNext()) {
			Attribute attr = it.next();
			System.out.println(attr.getText());
		}
		Dom4jUtils.write("people.xml", document);
		// 也可使用DocumentHelper先创建一个新属性，然后再添加进去。
	}
}
