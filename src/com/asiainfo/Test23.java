package com.asiainfo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 * 跟踪弱引用的回收（在gc时只要碰到弱引用就会回收而无论堆内存空间是否紧张）
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午4:55:46
 */
public class Test23 extends N {
	static Test23 t;
	
	public static void main(String[] args) {
		M m = new M();
		m.setDaemon(true);
		m.start();
		
		t = new Test23();
		rq = new ReferenceQueue<N>();
		WeakReference<N> weakReference = new WeakReference<N>(t, rq);
		System.out.println("t = " + t);
		System.out.println("weakReference = " + weakReference.get());
		
		System.out.println("失去强引用后：");
		t = null;
		System.out.println("t = " + t);
		System.out.println("weakReference = " + weakReference.get());
		
		System.out.println("进行第一次gc...");
		System.gc();
		System.out.println("gc后：");
		System.out.println("t = " + t);
		System.out.println("weakReference = " + weakReference.get());
	}
}
