package com.tcwgq.enumdemo;

/**
 * 枚举的几个方法测试 public final String name()返回此枚举常量的名称，在其枚举声明中对其进行声明。 public final
 * int ordinal()返回枚举常量的序数（它在枚举声明中的位置，其中初始常量序数为零）。 public static <T extends
 * Enum<T>> T valueOf(Class<T> enumType, String name)返回带指定名称的指定枚举类型的枚举常量。
 * valueof(String name)转换枚举对象 values()获得所有枚举对象数组
 * 
 * @author lenovo
 * 
 */
public class EnumTest4 {
	public static void main(String[] args) {
		System.out.println(Colors.RED.name());
		System.out.println(Colors.GREEN.ordinal());
		Colors red = Colors.valueOf("RED");
		System.out.println(red);
		Colors green = Enum.valueOf(Colors.class, "GREEN");
		System.out.println(green);
		Colors[] colors = Colors.values();
		System.out.println(colors);
	}
}

enum Colors {
	RED, GREEN, YELLOW;
}