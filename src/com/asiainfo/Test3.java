package com.asiainfo;

/**
 * 测试：在java栈大小相同的情况下，方法的参数或者局部变量越多，嵌套调用的栈深度越浅
 * 
 * @author zhangzhiwang
 * @date 2018年1月8日 下午4:27:20
 */
public class Test3 {
	/*
	 * 方法在调用时，会有一个栈桢被压入java栈中，而方法的参数和局部变量会被保存在栈桢的局部变量表中，当参数或局部变量增加时，局部变量表就会变大，在Java栈大小不变的情况下，可嵌套调用的层级（栈深度）就会变小
	 */

	private static int count;

	public static void deadLoop(byte b1, short s1, int i1, char c1, long l1, float f1, double d1, boolean boo1) {
		byte b2 = 1;
		short s2 = 1;
		int i2 = 1;
		char c2 = 'a';
		long l2 = 1;
		float f2 = 1.0f;
		double d2 = 1.0;
		boolean boo2 = false;

		count++;
		deadLoop(b1, s1, i1, c1, l1, f1, d1, boo1);
	}

	public static void deadLoop() {
		count++;
		deadLoop();
	}

	public static void main(String[] args) {
		try {
			deadLoop((byte) 1, (short) 1, 1, 'a', 1, 1.0f, 1.0, false);//在运行时确保Java栈大小要相同，即-Xss大小要一致
//			deadLoop();
		} catch (Throwable e) {
			System.out.println("stack deep = " + count);
			e.printStackTrace();
		}
	}
}
