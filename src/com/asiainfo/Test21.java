package com.asiainfo;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

/**
 * 跟踪虚引用被回收（虚引用是所有引用里面最弱的一个，跟没有引用几乎一样。p.s.几种引用由强到弱的排序为：强引用、软引用、弱引用和虚引用）
 * 
 * @author zhangzhiwang
 * @date 2018年1月16日 下午4:17:37
 */
public class Test21 extends N {
	static Test21 t = null;
	public static void main(String[] args) throws InterruptedException {
		M m = new M();
		m.setDaemon(true);
		m.start();
		
		t = new Test21();
		rq = new ReferenceQueue<>();
		PhantomReference<N> phantom = new PhantomReference<N>(t, rq);
		t = null;
		System.out.println("第一次gc");
		System.gc();
		Thread.sleep(10);
		
		t = null;
		System.out.println("第二次gc");
		System.gc();
		Thread.sleep(10);
	}
	
	@Override
	protected void finalize() throws Throwable {
		super.finalize();
		System.out.println("finalize()");
		t = this;
	}
}

class M extends Thread {
	@Override
	public void run() {
		if(N.rq != null) {
			try {
				Reference<? extends N> reference = N.rq.remove();
				if(reference != null) {
					System.out.println("被回收的对象己经被加到了引用队列中，说明GC清理了本对象");
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class N {
	public static ReferenceQueue<N> rq;
}