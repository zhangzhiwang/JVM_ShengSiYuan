package com.asiainfo;

/**
 * 先加载父类再加载子类
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午1:47:37
 */
public class Test17 {
	static {
		System.out.println("Test17 init");
	}
	
	public static void main(String[] args) {
		System.out.println(J1.a);
	}
}

class J {
	static {
		System.out.println("J init");
	}
}

class J1 extends J {
	public static int a = 2;//如果a是final的，则不会引起父类的加载，因为子类也不会被加载
	
	static {
		System.out.println("J1 init...");
	}
}