package cn.itcast.dao.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoImpl implements StudentDao {
	@Override
	public void add(Student student) {
		System.out.println("StudentDaoImpl.add()");
	}

	@Override
	public void update(Student student) {
		System.out.println("StudentDaoImpl.update()");
	}

}
