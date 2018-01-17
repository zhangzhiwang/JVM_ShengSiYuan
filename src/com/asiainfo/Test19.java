package com.asiainfo;

import java.lang.ref.SoftReference;

/**
 * 软引用
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午2:49:50
 */
public class Test19 {
	private int i;
	private String name;

	public Test19(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}

	public Test19() {
		super();
	}

	@Override
	public String toString() {
		return "Test19 [i=" + i + ", name=" + name + "]";
	}

	public static void main(String[] args) {
		Test19 t = new Test19(1, "a");//t是强引用
		SoftReference<Test19> srt = new SoftReference<>(t);//srt是软引用
		t = null;
		
		System.out.println(srt.get());
		System.gc();
		System.out.println("after gc");
		System.out.println(srt.get());
		
		byte[] b = new byte[7 * 919 * 1024];//强引用坚决不能被回收，哪怕引起内存溢出
		System.gc();
		System.out.println(srt.get());//不断调整数组的大小，当堆内存的空间紧张（快被耗尽）时，软引用所指向的对象会被回收，基于此机制软引用不会引起内存溢出
	}
}
