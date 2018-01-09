package com.asiainfo;

/**
 * 被局部变量表引用的对象不会被垃圾回收
 * 
 * @author zhangzhiwang
 * @date 2018年1月9日 上午10:34:13
 */
public class Test5 {
	public void met1() {
		byte[] b = new byte[6 * 1024 * 1024];//堆中的数组对象有一个强引用来指向它，所以不会被回收
		System.gc();// 手动进行垃圾回收
	}

	public void met2() {
		byte[] b = new byte[6 * 1024 * 1024];
		b = null;//是数组失去引用，数组对象会被垃圾回收
		System.gc();
	}
	
	public void met3() {
		{
			byte[] b = new byte[6 * 1024 * 1024];//虽然在垃圾回收的时候已经超出了b的作用域，但是b仍然在局部变量表中并指向了一个数组对象，所以数组对象不会被回收
		}
		System.gc();
	}
	
	public void met4() {
		{
			byte[] b = new byte[6 * 1024 * 1024];
		}
		int i = 1;//变量i复用了b的槽位，所以b在局部变量表中被销毁，数组失去了引用，固被回收
		System.gc();
	}
	
	public void met5() {
		met1();//在met1()方法中，虽然数组对象没有被销毁，但是随着met1()方法的调用结束，他所对应的栈桢已经在Java栈中弹出，该栈的局部变量表已不存在，固数组对象会被回收
		System.gc();
	}
	
	public static void main(String[] args) {
		new Test5().met1();//运行时使用-XX:+PrintGC参数来看GC的情况：java -XX:+PrintGC ...
	}
}
