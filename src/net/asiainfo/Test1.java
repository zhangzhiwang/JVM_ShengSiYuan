package net.asiainfo;

import com.asiainfo.Test28;

/**
 * 测试包访问权限
 * 
 * @author zhangzhiwang
 * @date 2018年1月23日 下午2:05:47
 */
public class Test1 {
	public static void main(String[] args) {
		Test28 test = new Test28();
		String s = test.name;
//		int i = test.i();//Test28的属性i是包访问权限（default），这个包是运行时包。两个类是否在同一个运行时包取决于包名是否相同以及是否被同一定义类加载器加载
		//这里Test1所在包为net.asiainfo，而Test28在com.asiainfo，不在同一包，所以不可见。com.asiainfo.Test29将测试在同一包但不被统一定义类加载器加载的情况
	}
}
