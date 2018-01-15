package com.asiainfo;

import java.util.ArrayList;
import java.util.List;

/**
 * OOM:Java heap space
 * 
 * @author zhangzhiwang
 * @date 2018年1月15日 下午2:00:19
 */
public class Test13 {
	public static void main(String[] args) {
		List<Byte[]> l = new ArrayList<>();
		for(int i = 0; i < 25; i++) {
			l.add(new Byte[1 * 1024 * 1024]);
		}
	}
}
