package cn.itcast.dao.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;

public class StudentDaoImpl2 implements StudentDao {
	@Override
	public void add(Student stu) {
		System.out.println("StudentDaoImpl2.add()");
	}

	@Override
	public void update(Student stu) {
		System.out.println("StudentDaoImpl2.update()");
	}

}