package com.tcwgq.student;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.tcwgq.utils.Dom4jUtils;

/**
 * 根据ID查询学生信息。
 * 
 * @author lenovo
 * 
 */
public class SelectStudent {
	public static void main(String[] args) {
		selectStudentById("111");
	}

	private static void selectStudentById(String ID) {
		Document document = Dom4jUtils.getDocument("student.xml");
		Element root = document.getRootElement();
		List<Node> list = document.selectNodes("//id");
		for (Node node : list) {
			if (node.getText().equals(ID)) {
				Element parent = node.getParent();
				Element id = parent.element("id");
				Element name = parent.element("name");
				Element age = parent.element("age");
				System.out.println(id.getText() + "--" + name.getText() + "--"
						+ age.getText());
			}
		}
	}
}
