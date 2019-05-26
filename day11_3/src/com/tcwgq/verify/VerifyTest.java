package com.tcwgq.verify;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 这个验证码第八天时已经介绍过了，这里不再重复
 * 
 * @author lenovo
 * 
 */
public class VerifyTest {
	public static void main(String[] args) throws IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		String text = vc.getText();
		System.out.println(text);
		VerifyCode.output(bi, new FileOutputStream("a.jpg"));
	}
}
