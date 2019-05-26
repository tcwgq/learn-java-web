package cn.itcast.service.impl;

import cn.itcast.dao.StudentDao;
import cn.itcast.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDao studentDao = null;

	// 谁调用service方法，谁就需要先调用本方法，提供dao
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public void login() {
		studentDao.add(null);
		studentDao.update(null);
	}
}
