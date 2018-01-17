package com.asiainfo;

import java.lang.ref.WeakReference;

/**
 * 弱引用（比软引用还弱的引用）
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午3:33:34
 */
public class Test20 {
	public static void main(String[] args) {
		L l = new L();
		WeakReference<L> wr = new WeakReference<>(l);
		l = null;
		System.out.println(wr.get());
		System.gc();
		System.out.println("after gc");
		System.out.println(wr.get());//弱引用发现即回收
	}
}

class L {
	private int i;
	private String name;

	public L(int i, String name) {
		super();
		this.i = i;
		this.name = name;
	}

	public L() {
		super();
	}

}