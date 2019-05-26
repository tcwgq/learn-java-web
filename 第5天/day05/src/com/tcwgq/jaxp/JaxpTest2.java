package com.tcwgq.jaxp;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.Text;

/**
 * 添加节点
 * 
 * @author lenovo
 * 
 */
public class JaxpTest2 {
	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();
		File file = new File("people.xml");
		Document doc = db.parse(file);
		Node people = doc.getElementsByTagName("people").item(0);
		Element person = doc.createElement("person");
		Element name = doc.createElement("name");
		Text nameText = doc.createTextNode("tcwgq");
		name.appendChild(nameText);
		Element age = doc.createElement("age");
		Text ageText = doc.createTextNode("27");
		age.appendChild(ageText);
		person.appendChild(name);
		person.appendChild(age);
		people.appendChild(person);
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer t = tf.newTransformer();
		t.transform(new DOMSource(doc),
				new StreamResult(new File("people.xml")));
	}
}
