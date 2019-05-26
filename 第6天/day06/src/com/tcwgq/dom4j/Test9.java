package com.tcwgq.dom4j;

import org.dom4j.Document;
import org.dom4j.Node;

import com.tcwgq.utils.Dom4jUtils;

/**
 * dom4j支持xpath的操作，获取第一个person下的name的值。
 * 观察可以发现，第一个person下面有id="20160330"属性，因此可以根据这个属性值获取这个person。
 * 使用xpath可以这样写：//person[@id="20160330"]/name
 * 
 * @author lenovo
 * 
 */
public class Test9 {
	public static void main(String[] args) {
		Document document = Dom4jUtils.getDocument("people.xml");
		Node name = document.selectSingleNode("//person[@id='20160330']/name");
		System.out.println(name.getText());
	}
}
