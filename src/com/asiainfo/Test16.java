package com.asiainfo;

import java.util.Random;

/**
 * 类的初始化
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午1:27:13
 */
public class Test16 {
	public static void main(String[] args) {
		System.out.println("G.i = " + G.i);
		System.out.println("-----------");
		System.out.println("H.i = " + H.i);
		System.out.println("-----------");
		System.out.println("I.i = " + I.i);
	}
}

class G {
	public static final int i = 1;// 对类的首次使用，如果使用的是类的编译常量（编译时能确定常量值的常量），则不会导致类的初始化

	static {
		System.out.println("G init");// 检验初始化是否被执行
	}
}

class H {
	public static int i = 1;// 对类的首次使用（比如调用类的静态变量）会导致该类被初始化

	static {
		System.out.println("H init");
	}
}

class I {
	public static final int i = new Random().nextInt(100);// 对类的首次使用，如果使用的是类的运行时常量（编译时不能确定常量的值，只有在运行时才能确定），则会导致类的初始化

	static {
		System.out.println("I init");
	}
}