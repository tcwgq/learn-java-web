package com.tcwgq.student;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.tcwgq.utils.Dom4jUtils;

public class AddStudent {
	public static void main(String[] args) {
		Document document = Dom4jUtils.getDocument("student.xml");
		Element root = document.getRootElement();
		Element student = DocumentHelper.createElement("student");
		Element id = DocumentHelper.createElement("id");
		id.setText("123");
		Element name = DocumentHelper.createElement("name");
		name.setText("aaa");
		Element age = DocumentHelper.createElement("age");
		age.setText("123");
		student.add(id);
		student.add(name);
		student.add(age);
		root.add(student);
		Dom4jUtils.write("student.xml", document);
	}
}
