package com.asiainfo;

/**
 * 测试对象存放在新生代中
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午6:13:20
 */
public class Test24 {
	public static void main(String[] args) {
		Test24 t = null;
		for(int i = 0; i < 10000; i++) {
			t = new Test24();
		}
	}
}
