package com.asiainfo;

/**
 * 新生代的配置	
 * 
 * @author zhangzhiwang
 * @date 2018年1月15日 下午1:44:33
 */
public class Test12 {
	public static void main(String[] args) {
		byte[] b = null;
		for(int i = 0; i < 10; i++) {
			b = new byte[1 * 1024 * 1024];
		}
	}
}
