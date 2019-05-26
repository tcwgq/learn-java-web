package com.tcwgq.dom4j;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.Node;

import com.tcwgq.utils.Dom4jUtils;

/**
 * 使用dom4j支持XPath操作 默认情况下，dom4j不支持xpath操作，使用之前需要导入相关的支持包
 * selectNodes("xpath表达式"):获取多大节点。 selectSingleNode("xpath表达式"):获取单个节点。
 * 
 * @author lenovo
 * 
 */
public class Test8 {
	public static void main(String[] args) {
		Document document = Dom4jUtils.getDocument("people.xml");
		List<Node> list = document.selectNodes("//name");
		for (Node node : list) {
			System.out.println(node.getText());
		}
	}
}
