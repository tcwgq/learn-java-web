package com.tcwgq.demo;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import com.tcwgq.verify.VerifyCode;

/**
 * 使用VerifyCode产生验证码
 * 
 * @author lenovo
 * 
 */
public class Demo2 {
	public static void main(String[] args) throws IOException {
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		VerifyCode.output(bi, new FileOutputStream("b.jpg"));
		System.out.println(vc.getText());
	}
}
