package com.tcwgq.local;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocaleTest {
	public static void main(String[] args) {
		Locale locale = Locale.US;
		ResourceBundle rb = ResourceBundle.getBundle("res", locale);
		System.out.println(rb.getString("username"));
		System.out.println(rb.getString("password"));
		System.out.println(rb.getString("login"));
	}
}
