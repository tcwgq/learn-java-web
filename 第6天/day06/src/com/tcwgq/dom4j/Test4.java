package com.tcwgq.dom4j;

import org.dom4j.Document;
import org.dom4j.Element;
import com.tcwgq.utils.Dom4jUtils;

/**
 * 修改第一个person下面的age为30。
 * 
 * @author lenovo
 * 
 */
public class Test4 {
	public static void main(String[] args) {
		editElement();
	}

	public static void editElement() {
		Document document = Dom4jUtils.getDocument("people.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		Element name = person.element("name");
		name.setText("zhangSan");
		Element age = person.element("age");
		age.setText("30");
		Dom4jUtils.write("people.xml", document);

	}
}
