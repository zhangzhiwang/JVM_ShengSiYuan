package com.asiainfo;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * 跟踪软引用什么时候被回收（软引用只有在堆内存紧张时才会被回收）
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午4:34:11
 */
public class Test22 extends N {
	static Test22 t;
	
	public static void main(String[] args) {
		M m = new M();
		m.setDaemon(true);
		m.start();
		
		t = new Test22();
		rq = new ReferenceQueue<N>();
		SoftReference<N> softReference = new SoftReference<N>(t, rq);
		System.out.println("gc前：");
		System.out.println("强引用：" + t);
		System.out.println("软引用：" + softReference.get());
		
		t = null;
		System.out.println("对象失去强引用：");
		System.out.println("强引用：" + t);
		System.out.println("软引用：" + softReference.get());
		
		System.out.println("开始第一次gc...");
		System.gc();
		System.out.println("第一次gc后：");
		System.out.println("强引用：" + t);
		System.out.println("软引用：" + softReference.get());
		
		System.out.println("人为制造堆内存紧张");
		byte[] b = new byte[7 * 918 * 1024];
		
		System.out.println("开始第二次gc...");
		System.gc();//当堆内存空间紧张时会引发JVM的自动垃圾回收而无需用户显示调用gc()方法，此处显示调用是为了起到说明作用
		System.out.println("当堆内存紧张时会引起对软引用的回收（运行时请用参数：-Xmx10m）");
		System.out.println("第二次gc后：");
		System.out.println("强引用：" + t);
		System.out.println("软引用：" + softReference.get());
		
	}
}
