package com.asiainfo;

/**
 * 系统加载器
 *
 * @author zhangzhiwang
 * @date 2018年1月18日 下午9:50:59
 */
public class Test25 {
	public static void main(String[] args) throws ClassNotFoundException {
		ClassLoader classLoader = ClassLoader.getSystemClassLoader();//获取系统加载器，又称应用加载器
		classLoader.loadClass("com.asiainfo.O");//加载某一个类，参数是类的全限定名。加载就是将class文件从硬盘加载到内存中并生成该类的Class对象，这里仅仅是加载而已，并不会对类进行
		System.out.println("-----------");
		Class.forName("com.asiainfo.O");//会导致类的初始化
	}
}

class O {
	static {
		System.out.println("init O");
	}
}
