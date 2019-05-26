package com.tcwgq.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface MyHandler<T> {
	public T handle(ResultSet rs) throws SQLException;
}
