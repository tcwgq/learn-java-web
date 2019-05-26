package com.tcwgq.xstream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.tcwgq.domain.City;
import com.tcwgq.domain.Province;
import com.thoughtworks.xstream.XStream;

public class XStreamTest {
	@Test
	public void fun1() {
		Province p = new Province();
		p.setName("北京");
		p.addCity(new City("昌平区", "changping"));
		p.addCity(new City("大兴区", "daxing"));
		p.addCity(new City("中关村", "zhongguancun"));
		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("临沂", "linyi"));
		p1.addCity(new City("济南", "jinan"));
		p1.addCity(new City("烟台", "yantai"));
		List<Province> list = new ArrayList<Province>();
		list.add(p);
		list.add(p1);
		XStream xs = new XStream();
		String xml = xs.toXML(list);
		System.out.println(xml);
	}

	@Test
	public void fun2() {
		Province p = new Province();
		p.setName("北京");
		p.addCity(new City("昌平区", "changping"));
		p.addCity(new City("大兴区", "daxing"));
		p.addCity(new City("中关村", "zhongguancun"));
		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("临沂", "linyi"));
		p1.addCity(new City("济南", "jinan"));
		p1.addCity(new City("烟台", "yantai"));
		List<Province> list = new ArrayList<Province>();
		list.add(p);
		list.add(p1);
		XStream xs = new XStream();
		// 指定别名
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		String xml = xs.toXML(list);
		System.out.println(xml);
	}

	@Test
	public void fun3() {
		Province p = new Province();
		p.setName("北京");
		p.addCity(new City("昌平区", "changping"));
		p.addCity(new City("大兴区", "daxing"));
		p.addCity(new City("中关村", "zhongguancun"));
		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("临沂", "linyi"));
		p1.addCity(new City("济南", "jinan"));
		p1.addCity(new City("烟台", "yantai"));
		List<Province> list = new ArrayList<Province>();
		list.add(p);
		list.add(p1);
		XStream xs = new XStream();
		// 指定别名
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		xs.useAttributeFor(Province.class, "name");
		String xml = xs.toXML(list);
		System.out.println(xml);
	}

	@Test
	public void fun4() {
		Province p = new Province();
		p.setName("北京");
		p.addCity(new City("昌平区", "changping"));
		p.addCity(new City("大兴区", "daxing"));
		p.addCity(new City("中关村", "zhongguancun"));
		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("临沂", "linyi"));
		p1.addCity(new City("济南", "jinan"));
		p1.addCity(new City("烟台", "yantai"));
		List<Province> list = new ArrayList<Province>();
		list.add(p);
		list.add(p1);
		XStream xs = new XStream();
		// 指定别名
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		xs.useAttributeFor(Province.class, "name");
		xs.addImplicitCollection(Province.class, "cities");
		String xml = xs.toXML(list);
		System.out.println(xml);
	}

	@Test
	public void fun5() {
		Province p = new Province();
		p.setName("北京");
		p.addCity(new City("昌平区", "changping"));
		p.addCity(new City("大兴区", "daxing"));
		p.addCity(new City("中关村", "zhongguancun"));
		Province p1 = new Province();
		p1.setName("山东");
		p1.addCity(new City("临沂", "linyi"));
		p1.addCity(new City("济南", "jinan"));
		p1.addCity(new City("烟台", "yantai"));
		List<Province> list = new ArrayList<Province>();
		list.add(p);
		list.add(p1);
		XStream xs = new XStream();
		// 指定别名
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		xs.useAttributeFor(Province.class, "name");
		xs.addImplicitCollection(Province.class, "cities");
		xs.omitField(City.class, "description");
		String xml = xs.toXML(list);
		System.out.println(xml);
	}

}
