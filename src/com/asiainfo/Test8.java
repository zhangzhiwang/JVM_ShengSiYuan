package com.asiainfo;

/**
 * 栈上分配
 * 
 * @author zhangzhiwang
 * @date 2018年1月9日 下午5:20:18
 */
public class Test8 {
	private int i;
	private String name;

	public Test8(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}

	public Test8() {
		super();
	}

	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		
		for(int i = 0; i < 10000000000L; i++) {
			new Test8(1, "s");
		}
		
		long end = System.currentTimeMillis();
		System.out.println(end - begin);
	}
}
