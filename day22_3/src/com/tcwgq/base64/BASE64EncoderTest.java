package com.tcwgq.base64;

import java.io.IOException;

import org.junit.Test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class BASE64EncoderTest {
	@Test
	public void fun() throws IOException {
		// 编码
		String s = "wgq681323668";
		// aXRjd2dxQDE2My5jb20=
		// d2dxNjgxMzIzNjY4
		BASE64Encoder enc = new BASE64Encoder();
		s = enc.encode(s.getBytes("utf-8"));
		System.out.println(s);
		// 解码
		BASE64Decoder dec = new BASE64Decoder();
		byte[] bys = dec.decodeBuffer(s);
		s = new String(bys, "utf-8");
		System.out.println(s);
	}
}
