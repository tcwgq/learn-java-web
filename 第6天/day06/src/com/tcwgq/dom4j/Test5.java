package com.tcwgq.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;

import com.tcwgq.utils.Dom4jUtils;

/**
 * 删除节点，例如把第一个person节点的sex节点删除。
 * 
 * @author lenovo
 * 
 */
public class Test5 {
	public static void main(String[] args) {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Element sex = person.element("sex");
		person.remove(sex);
		Dom4jUtils.write("people.xml", document);
	}
}
