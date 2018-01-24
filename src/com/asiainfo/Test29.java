package com.asiainfo;

/**
 * 包访问权限的决定因素
 * 
 * @author zhangzhiwang
 * @date 2018年1月23日 下午2:11:58
 */
public class Test29 {
	public static void main(String[] args) {
		Test28 test28 = new Test28();
		int i = test28.i;//这里之所以能访问Test28的属性i，是因为Test29和Test28在同一个包下且被同一个定义类加载器加载
		System.out.println(Test28.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@501d5ebc
		System.out.println(Test29.class.getClassLoader());//sun.misc.Launcher$AppClassLoader@501d5ebc
	}
}
