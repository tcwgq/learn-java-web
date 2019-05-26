package com.tcwgq.pool;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * 使用ConnectionWrapper，自定义连接
 * 
 * @author lenovo
 * 
 */
public class MyConnection extends ConnectionWrapper {

	public MyConnection(Connection con) {
		super(con);
	}

	@Override
	public void close() throws SQLException {
		System.out.println("哈哈~");
		super.close();
	}

}
