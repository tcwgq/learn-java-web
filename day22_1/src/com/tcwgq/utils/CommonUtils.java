package com.tcwgq.utils;

import java.util.UUID;

public class CommonUtils {
	public static String uuid() {
		return UUID.randomUUID().toString().toLowerCase().replace("-", "");
	}
}
