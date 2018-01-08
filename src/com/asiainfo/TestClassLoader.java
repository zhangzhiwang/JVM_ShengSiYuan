package com.asiainfo;

/**
 * 测试类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年1月8日 下午12:40:59
 */
public class TestClassLoader {
	public static void main(String[] args) throws ClassNotFoundException {
		Class clazz = Class.forName("java.lang.String");
		System.out.println(clazz.getClassLoader());//一个class肯定要被类加载器加载到内存，如果取出来的ClassLoader是空，那么该类一定是被根类加载器（BootStrap）加载的。根类加载器使用c++写的，规定不能获取根类加载器
		System.out.println(TestClassLoader.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@501d5ebc  AppClassLoader为系统类加载器，也叫应用类加载器，该加载器用java编写
	}
}
