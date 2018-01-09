package com.asiainfo;

/**
 * 局部变量表的槽位测试
 * 
 * @author zhangzhiwang
 * @date 2018年1月9日 上午9:59:42
 */
public class Test4 {
	public void met1() {//对于实例方法，局部变量表的第一个位置保存的是this指针，占用一个内存单元（字）
		int a = 1;
		int b = 2;//b无法复用a的在槽位，因为a、b在同一作用域
	}
	
	public void met2() {
		{
			int a = 1;
		}
		int b = 2;//b复用了a的槽位，因为a已结束其生命周期，即b的位置在a的作用域以外
	}
	
	public static void met3() {
		int a = 1;
		int b = 2;
	}
	
	public static void met4() {
		int a = 1;
		long b = 2;//long和double类型占两个内存单元，其它的都占用1个字节包括对象引用
	}
	
	public static void met5() {
		long a = 1;
		double b = 1.0;
	}
	
	public static void met6() {
		int a = 1;
		Test4 b = new Test4();
	}
	
	public static void met7() {
		{
			int a = 1;
		}
		Test4 b = new Test4();//对象的引用b复用了基本变量a的槽位
	}
}
