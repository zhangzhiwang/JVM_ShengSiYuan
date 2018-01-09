package com.asiainfo;

/**
 * 模拟栈溢出异常
 * 
 * 
 * @author zhangzhiwang
 * @date 2018年1月8日 下午4:08:57
 */
public class Test2 {
	private static int count;

	public static void deadLoop() {
		count++;
		deadLoop();
	}

	public static void main(String[] args) {
		try {
			deadLoop();//添加启动参数-Xss160K，通过加大栈内存可以看到栈深度
		} catch (Throwable e) {
			System.out.println("stack depth = " + count);
			e.printStackTrace();
		}
	}
}
