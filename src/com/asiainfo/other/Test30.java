package com.asiainfo.other;

/**
 * 测试类加载器
 *
 * @author zhangzhiwang
 * @date 2018年1月28日 上午10:55:11
 */
public class Test30 {
	public Test30() {
		System.out.println("Test30 is loaded by " + this.getClass().getClassLoader());
		new Test31();
	}
}