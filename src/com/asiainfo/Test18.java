package com.asiainfo;

/**
 * 第一次使用类的静态变量或方法在当该类中确实存在时在会导致该类被加载
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午2:14:21
 */
public class Test18 {
	public static void main(String[] args) {
//		System.out.println("K1.a = " + K1.a);
		K1.met1();//访问的静态变量或者静态方法没有在子类中定义，所以不会导致子类的初始化
	}
}

class K {
	public static int a = 1;

	static {
		System.out.println("K init");
	}

	public static void met1() {
		System.out.println("K.met1()");
	}
}

class K1 extends K {
	static {
		System.out.println("K1 init...");
	}
}