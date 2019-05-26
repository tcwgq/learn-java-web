package com.tcwgq.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import cn.itcast.jdbc.TxQueryRunner;
import cn.itcast.utils.CommonUtils;

import com.tcwgq.domain.City;
import com.tcwgq.domain.Province;

public class Dao {
	private QueryRunner qr = new TxQueryRunner();

	public List<Province> findAllProvince() {
		String sql = "select * from t_province";
		try {
			List<Province> list = qr.query(sql, new BeanListHandler<Province>(
					Province.class));
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<City> findCityByPid(int pid) {
		String sql = "select * from t_city where pid = ?";
		try {
			List<City> list = qr.query(sql, new BeanListHandler<City>(
					City.class), pid);
			return list;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<City> findCityMap(int pid) {
		// 表间关系的映射
		String sql = "select * from t_city where pid = ?";
		try {
			List<Map<String, Object>> list = qr.query(sql,
					new MapListHandler(), pid);
			Map<String, Object> map = list.get(0);
			System.out.println(map);
			Province province = CommonUtils.toBean(map, Province.class);
			System.out.println(province);
			City city = CommonUtils.toBean(map, City.class);
			System.out.println(city);
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
