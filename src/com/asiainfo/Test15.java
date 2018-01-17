package com.asiainfo;

/**
 * 对象的“复活”
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午12:46:22
 */
public class Test15 {
	private String s;
	
	public static void main(String[] args) throws InterruptedException {
		Test15 test = new Test15();
		System.out.println("1:" + (test.s == null));
		test.s = new String("111");
		System.out.println("2:" + (test.s == null));
		test.s = null;
		System.out.println("3:" + (test.s == null));
		System.gc();
		Thread.sleep(100);
		System.out.println("4:" + (test.s == null));
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("调用finalize()");
		s = new String("123");
	}
}
