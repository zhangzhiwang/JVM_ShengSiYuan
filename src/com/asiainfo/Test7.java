package com.asiainfo;

/**
 * 初始化子类会先出初始化父类
 * 
 * @author zhangzhiwang
 * @date 2018年1月9日 下午2:00:56
 */
public class Test7 {
	static {
		System.out.println("init main class");
	}
	
	public static void main(String[] args) {
		System.out.println(F.i);
	}
}

class E {
	public static int i = 1;
	
	static {
		System.out.println("init father");
	}
}

class F extends E {
	public static int i = 2;
	
	static {
		System.out.println("init son");
	}
}


