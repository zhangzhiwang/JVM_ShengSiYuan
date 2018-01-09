package com.asiainfo;

import java.util.Random;

/**
 * 测试类的初始化
 * 
 * @author zhangzhiwang
 * @date 2018年1月9日 下午1:40:01
 */
public class Test6 {
	public static void main(String[] args) {
//		System.out.println(A.i);
//		System.out.println(B.i);
//		System.out.println(C.i);
		System.out.println(D.i);
	}
}

class A {
	public static int i = 2;
	
	static {
		i = 100;
	}
}

class B {
	public static int i = new Random().nextInt(100);
	
	static {
		i = -1;
	}
}

class C {
	public static final int i = 2;
	
	static {
		System.out.println("aaa");
	}
}

class D {
	public static final int i = new Random().nextInt(100);
	
	static {
		System.out.println("aaa");
	}
}
