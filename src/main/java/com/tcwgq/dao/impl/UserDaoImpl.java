package com.tcwgq.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.tcwgq.dao.UserDao;
import com.tcwgq.model.User;

/**
 * @author tcwgq
 * @time 2017年8月27日下午5:44:04
 * @email tcwgq@outlook.com
 */
@Repository
public class UserDaoImpl implements UserDao {
	@Resource
	private HibernateTemplate template;

	@Override
	public void add(User user) {
		// saveOrUpdate方法要求ID为null时才执行SAVE，在其它情况下执行UPDATE。在保存实例的时候是新增，但你的ID不为null，所以使用的是UPDATE，但是数据库里没有主键相关的值，所以出现异常。
		template.saveOrUpdate(user);
	}

	@Override
	public User get(int id) {
		// 根据id查询
		// 根据id延迟查询
		// template.load(User.class, id);
		return template.get(User.class, id);
	}

	@Override
	public User getUserById(int id) {
		// hql语法？早就忘了
		return (User) template.find("from User where id = ?", id).get(0);
	}

	public List<User> getAll() {
		return (List<User>) template.find("from User");
	}

	public List<User> getByCreteria() {
		return null;
	}

}
