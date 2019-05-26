package com.tcwgq.dom4j;

import java.util.List;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import com.tcwgq.utils.Dom4jUtils;

/**
 * 封装dom4j的相关操作
 * 
 * @author lenovo
 * 
 */
public class Test3 {
	public static void main(String[] args) throws Exception {
		Document document = Dom4jUtils.getDocument("copy.xml");
		Element root = document.getRootElement();
		Element person = root.element("person");
		List<Element> list = person.elements();
		System.out.println(list);
		Element element = DocumentHelper.createElement("sex");
		element.addText("男");
		list.add(1, element);
		Dom4jUtils.write("copy.xml", document);
	}
}
