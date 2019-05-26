package com.tcwgq.user.dao.impl;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.tcwgq.user.dao.UserDao;
import com.tcwgq.user.domain.User;

public class UserDaoImpl implements UserDao {
	private String path = this.getClass().getResource("/users.xml").getPath();

	@Override
	public User getUser(String username) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			// 使用xpath查询
			Element element = (Element) document
					.selectSingleNode("//user[@username='" + username + "']");
			if (element == null)
				return null;
			String name = element.attributeValue("username");
			String password = element.attributeValue("password");
			User user = new User(name, password);
			return user;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<User> getUsers() {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			Element root = document.getRootElement();
			@SuppressWarnings("unchecked")
			List<Element> users = root.selectNodes("user");
			List<User> list = new ArrayList<User>();
			if (users != null) {
				for (Element ele : users) {
					User user = new User();
					user.setUsername(ele.attributeValue("username"));
					user.setPassword(ele.attributeValue("password"));
					list.add(user);
				}
			}
			return list;
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public void save(User user) {
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(path);
			Element root = document.getRootElement();
			Element userEle = root.addElement("user");
			userEle.addAttribute("username", user.getUsername());
			userEle.addAttribute("password", user.getPassword());
			// 使用\t缩进，换行
			OutputFormat format = new OutputFormat("\t", true);
			// 清空原有的换行和缩进
			format.setTrimText(true);
			try {
				XMLWriter writer = new XMLWriter(new OutputStreamWriter(
						new FileOutputStream(path), "UTF-8"), format);
				writer.write(document);
				writer.close();
			} catch (Exception e) {
				throw new RuntimeException(e);
			}
		} catch (DocumentException e) {
			throw new RuntimeException(e);
		}
	}
}
