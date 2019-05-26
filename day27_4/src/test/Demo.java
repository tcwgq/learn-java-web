package test;

import org.junit.Test;

import cn.itcast.beanfactory.BeanFactory;
import cn.itcast.dao.StudentDao;
import cn.itcast.domain.Student;
import cn.itcast.service.StudentService;

/*
 * 面向接口编程
 * dao
 * * daoImpl
 * service
 * * serviceImpl
 */
public class Demo {
	@Test
	public void fun1() {
		/*
		 * 1. 创建Bean工厂，创建时需要给工厂指定配置文件 2. 从工厂中获取bean对象
		 */
		BeanFactory bf = new BeanFactory("beans.xml");
		Student s1 = (Student) bf.getBean("stu1");
		Student s2 = (Student) bf.getBean("stu1");
		System.out.println(s1 == s2);
	}

	@Test
	public void fun2() {
		/*
		 * 1. 创建Bean工厂，创建时需要给工厂指定配置文件 2. 从工厂中获取bean对象
		 */
		BeanFactory bf = new BeanFactory("beans.xml");
		Student s1 = (Student) bf.getBean("stu1");
		Student s2 = (Student) bf.getBean("stu2");
		System.out.println(s1.getTeacher() == s2.getTeacher());
	}

	@Test
	public void fun3() {
		BeanFactory bf = new BeanFactory("beans.xml");
		StudentDao stuDao = (StudentDao) bf.getBean("stuDao");
		stuDao.add(null);
		stuDao.update(null);
	}

	@Test
	public void fun4() {
		BeanFactory bf = new BeanFactory("beans.xml");
		StudentService service = (StudentService) bf.getBean("stuService");
		service.login();
	}
}
