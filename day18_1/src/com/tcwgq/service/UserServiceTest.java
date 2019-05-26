package com.tcwgq.service;

import org.junit.Test;

/**
 * 测试
 * 
 * @author lenovo
 * 
 */
public class UserServiceTest {

	@Test
	public void testTransfer() {
		UserService service = new UserService();
		service.transfer("张三", "李四", 100);
	}

}
