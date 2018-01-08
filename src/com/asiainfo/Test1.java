package com.asiainfo;

/**
 * 一个很无耻的面试题
 * 
 * @author zhangzhiwang
 * @date 2018年1月8日 下午1:24:51
 */
public class Test1 {
//	public static Test1 test1 = new Test1();//将此句放在i1、i2定义的下面运行结果不一样，想一想为什么？
	public static int i1;
	public static int i2 = 0;
	public static Test1 test1 = new Test1();
	
	public Test1() {
		i1++;
		i2++;
	}
	
	public static Test1 getInstance() {
		return test1;
	}
	
	public static void main(String[] args) {
		Test1 test1 = Test1.getInstance();
		System.out.println(test1.i1);
		System.out.println(test1.i2);
	}
}
