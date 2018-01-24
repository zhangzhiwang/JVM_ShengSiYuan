package com.asiainfo;

/**
 * 测试扩展类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年1月23日 下午12:40:37
 */
public class Test27 {
	public static void main(String[] args) {
		// 将该类的class文件导出个jar包放到%JAVA_HOME%/jre/lib/ext下，让它被扩展类加载器加载
		System.out.println(Test27.class.getClassLoader());// 放到%JAVA_HOME%/jre/lib/ext下后，打印结果为：sun.misc.Launcher$ExtClassLoader@5d9d277e，正常情况下该类会被系统加载器加载
	}
}
