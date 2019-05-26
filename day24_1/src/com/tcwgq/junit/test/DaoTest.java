package com.tcwgq.junit.test;

import java.util.List;

import org.junit.Test;

import com.tcwgq.dao.Dao;
import com.tcwgq.domain.City;
import com.tcwgq.domain.Province;

public class DaoTest {
	private Dao dao = new Dao();

	@Test
	public void testFindAllProvince() {
		List<Province> list = dao.findAllProvince();
		System.out.println(list);
	}

	@Test
	public void testFindCityByProvince() {
		List<City> list = dao.findCityByPid(1);
		System.out.println(list);
	}

}
