package com.tcwgq.utils;

import java.util.UUID;

public class UUIDTest {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID().toString().replace("-", "")
				.toUpperCase();
		System.out.println(uuid);
	}
}
