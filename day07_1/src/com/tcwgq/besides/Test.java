package com.tcwgq.besides;

/**
 * 实现一个泛型方法，接受任意类型的数组，实现数组元素的逆序。
 * 
 * @author lenovo
 * 
 */
public class Test {
	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5 };
		reverse(arr);
		for (Integer i : arr) {
			System.out.println(i);
		}
	}

	public static <T> void reverse(T[] t) {
		int length = t.length;
		for (int i = 0, j = length - 1; i < j; i++, j--) {
			T temp = t[j];
			t[j] = t[i];
			t[i] = temp;
		}
	}
}
