package com.tcwgq.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class Dom4jUtils {
	private static SAXReader reader = new SAXReader();

	public static Document getDocument(String filepath) {
		Document document = null;
		try {
			document = reader.read(new File(filepath));
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		return document;
	}

	public static void write(String filepath, Document document) {
		OutputFormat pretty = OutputFormat.createPrettyPrint();
		pretty.setEncoding("utf-8");
		XMLWriter writer = null;
		try {
			writer = new XMLWriter(new FileWriter(filepath), pretty);
			writer.write(document);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
