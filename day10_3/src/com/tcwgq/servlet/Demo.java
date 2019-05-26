package com.tcwgq.servlet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class Demo {
	public static void main(String[] args) throws UnsupportedEncodingException {
		String name = "张三";
		name = URLEncoder.encode(name, "utf-8");
		System.out.println(name);// %E5%BC%A0%E4%B8%89
		name = URLDecoder.decode(name, "utf-8");
		System.out.println(name);
	}
}
