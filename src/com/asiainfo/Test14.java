package com.asiainfo;

import java.util.ArrayList;

/**
 * 对象的“复活”
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午12:31:24
 */
public class Test14 {
	private static Test14 t;

	public static void main(String[] args) throws InterruptedException {
		t = new Test14();
		System.out.println("1:" + (t == null));
		t = null;
		System.out.println("2:" + (t == null));
		System.gc();// GC会调用finalize()方法
		Thread.sleep(1);
		System.out.println("3:" + (t == null));
		t = null;
		System.gc();// 第二次进行回收，不会调用finalize()方法，因为finalize()方法只会被调用一遍
		Thread.sleep(100);
		System.out.println("4:" + (t == null));
	}

	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("GC会调用finalize()方法");
		t = this;
		// t = new Test14();// 当这行代码打开上行代码注掉时，finalize()方法会被多次调用
	}
}
