package com.asiainfo;

/**
 * 无法获取根类加载器
 *
 * @author zhangzhiwang
 * @date 2018年1月18日 下午10:03:59
 */
public class Test26 {
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("java.lang.String");
		System.out.println(c.getClassLoader());//null，根类加载器不允许外界获取。根类加载器没有附加载器，不继承ClassLoader类，该加载器由c++编写而非Java编写
		c = Class.forName("com.asiainfo.Test26");
		System.out.println(c.getClassLoader());//sun.misc.Launcher$AppClassLoader@501d5ebc，有系统加载器（应用加载器）加载
	}
}
