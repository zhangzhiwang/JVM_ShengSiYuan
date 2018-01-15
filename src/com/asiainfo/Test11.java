package com.asiainfo;

/**
 * 初始堆和最大堆
 * 
 * @author zhangzhiwang
 * @date 2018年1月15日 下午1:26:27
 */
public class Test11 {
	public static void main(String[] args) {
		System.out.println("Xmx = " + Runtime.getRuntime().maxMemory());
		System.out.println("free memory = " + Runtime.getRuntime().freeMemory());
		System.out.println("total memory = " + Runtime.getRuntime().totalMemory());
		
		byte[] b = new byte[1 * 1024 * 1024];
		System.out.println("分配了1M空间");
		
		System.out.println("Xmx = " + Runtime.getRuntime().maxMemory());
		System.out.println("free memory = " + Runtime.getRuntime().freeMemory());
		System.out.println("total memory = " + Runtime.getRuntime().totalMemory());
		
		b = new byte[4 * 1024 * 1024];
		System.out.println("分配了4M空间");
		
		System.out.println("Xmx = " + Runtime.getRuntime().maxMemory());
		System.out.println("free memory = " + Runtime.getRuntime().freeMemory());
		System.out.println("total memory = " + Runtime.getRuntime().totalMemory());
	}
}
