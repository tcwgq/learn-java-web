package com.tcwgq.listener;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameDemo {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(400, 300);
		frame.setLocation(200, 200);
		frame.setLayout(new FlowLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton button = new JButton("确定");
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Helloworld");
			}
		});
		frame.add(button);
		frame.setVisible(true);
	}
}
