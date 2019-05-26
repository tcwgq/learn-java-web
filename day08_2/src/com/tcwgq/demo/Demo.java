package com.tcwgq.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 使用BufferedImage产生验证码
 * 
 * @author lenovo
 * 
 */
public class Demo {
	public static void main(String[] args) throws IOException {
		// 得到图片缓冲区
		BufferedImage bi = new BufferedImage(90, 45, BufferedImage.TYPE_INT_RGB);
		// 得到绘制环境
		Graphics2D g2 = (Graphics2D) bi.getGraphics();
		// 设置背景色
		g2.setColor(Color.WHITE);
		// 填充一个矩形，填充整张图片
		g2.fillRect(0, 0, 90, 45);
		// 设置字体
		g2.setFont(new Font("宋体", Font.PLAIN, 15));
		// 设置字体颜色
		g2.setColor(Color.BLACK);
		// 写字
		g2.drawString("Helloworld", 5, 25);
		// 保存图片
		ImageIO.write(bi, "jpg", new FileOutputStream("a.jpg"));
		System.out.println("图片保存成功");
	}
}
