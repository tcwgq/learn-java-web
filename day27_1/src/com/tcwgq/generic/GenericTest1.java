package com.tcwgq.generic;

import java.util.ArrayList;
import java.util.List;

public class GenericTest1 {
	public static void main(String[] args) {
		Object[] array = new String[10];
		array[1] = new Integer(10);
		// List<Object> list = new ArrayList<String>();//错误
		List<String> stringList = new ArrayList<String>();
		print2(stringList);
		List<Integer> integerList = new ArrayList<Integer>();
		print3(integerList);
		// List<? extends Object> list1 = new ArrayList<? extends Object>();//
		// 错误，通配符不能出现在new端
		List<? extends Object> list2 = new ArrayList<String>();
	}

	public static void print(List<?> list) {
		List<? extends Object> list1 = list;
		// 参数或返回值为泛型的方法不可用
		// list.add(new Integer(1));
		// Integer i = list.get(0);
	}

	// 只能传递Number及其子类的参数
	public static void print11(List<? extends Number> list) {
		// 参数为泛型的方法不可用
		// list.add(new Integer(10));//错误
		// 返回值为泛型的方法可用
		Number number = list.get(1);
	}

	// 只能传递Integer及其父类的参数
	public static void print111(List<? super Integer> list) {
		// 参数为泛型的方法可用
		list.add(new Integer(10));// 错误
		// 返回值为泛型的方法不可用
		// Number number = list.get(1);
		Object obj = list.get(0);
	}

	public void print1(List<Object> list) {

	}

	public static void print2(List<String> list) {

	}

	public static void print3(List<Integer> list) {

	}
}
