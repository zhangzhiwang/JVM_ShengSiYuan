package com.asiainfo;

/**
 * 测试jdk自带的三种加载器存在父子关系
 *
 * @author zhangzhiwang
 * @date 2018年1月30日 上午12:05:39
 */
public class Test32 {
	public static void main(String[] args) {
		ClassLoader classLoader = Test32.class.getClassLoader();
		System.out.println(classLoader);

		while (classLoader != null) {
			classLoader = classLoader.getParent();
			System.out.println(classLoader);
		}
		/*
		 * 打印结果为： 
		 * sun.misc.Launcher$AppClassLoader@409a44d6
		 * sun.misc.Launcher$ExtClassLoader@501d5ebc
		 * null
		 * 
		 * null为跟加载器，外界无法获取
		 */
	}
}
