package com.tcwgq.anno2;

import com.tcwgq.anno1.Demo1;

@anno1(age = 23, name = "zhangSan", value = "hehehe", c = { "hello", "world" }, d = Enum.A, e = Demo1.class, f = @anno2(age = 45, name = "Helloworld"))
public class Demo2 {

}

@interface anno1 {
	int age() default 0;

	String name() default "hello";

	String value() default "world";

	// Integer a() ;//错误，参数类型不合适
	String[] c();// 数组元素赋值时，当只有一个元素时，可以省略大括号

	Enum d();

	Class e();

	anno2 f();
	// 还可以是以上类型的一维数组
}

@interface anno2 {
	int age() default 0;

	String name() default "hello";

}

enum Enum {
	A, B, C
}
