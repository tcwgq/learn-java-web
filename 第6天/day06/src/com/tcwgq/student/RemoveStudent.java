package com.tcwgq.student;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import com.tcwgq.utils.Dom4jUtils;

/**
 * 根据ID删除元素。
 * 
 * @author lenovo
 * 
 */
public class RemoveStudent {
	public static void main(String[] args) {
		// removeLast();
		removeById("111");
	}

	private static void removeLast() {
		Document document = Dom4jUtils.getDocument("student.xml");
		Element root = document.getRootElement();
		Node student = document.selectSingleNode("/class/student[last()]");
		root.remove(student);
		Dom4jUtils.write("student.xml", document);
	}

	private static void removeById(String id) {
		Document document = Dom4jUtils.getDocument("student.xml");
		Element root = document.getRootElement();
		List<Node> list = document.selectNodes("//id");
		for (Node node : list) {
			if (node.getText().equals(id)) {
				Node parent = node.getParent();
				root.remove(parent);
			}
		}
		Dom4jUtils.write("student.xml", document);
	}
}
