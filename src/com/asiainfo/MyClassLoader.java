package com.asiainfo;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 自定义类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年1月24日 下午1:14:37
 */
public class MyClassLoader extends ClassLoader {// 自定义类加载器只需继承java.lang.ClassLoader类并重写findClass()方法即可
	private String name;
	private String classPath;

	private MyClassLoader() {
		// super();//会默认调用super()方法，即默认调用父类的无參构造器。通过看ClassLoader的源代码可知无參构造方法会用系统类加载器作为父加载器，这也就是为什么系统类加载器是用户自定义的类加载器的默认父加载器
	}

	public MyClassLoader(String name, String classPath) {
		super();
		this.name = name;
		this.classPath = classPath;
	}

	public MyClassLoader(ClassLoader parent, String name, String classPath) {
		super(parent);// 指定父类加载器。注：父子加载器并非指继承关系
		this.name = name;
		this.classPath = classPath;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClassPath() {
		return classPath;
	}

	public void setClassPath(String classPath) {
		this.classPath = classPath;
	}

	@Override
	public Class<?> findClass(String fullName) {
		// 判空就不做了
		// fullName是类的全限定名
		// 思路：通过输入流读取class文件，然后将输入流转化成byte数组（中间靠输出流过度），再将byte数组转换成Class对象
		// step 1:通过输入流读取class文件
		InputStream in = null;
		ByteArrayOutputStream baos = null;
		byte[] data = null;

		try {
			in = new FileInputStream(new File(classPath + fullName));
			baos = new ByteArrayOutputStream();

			int ch = 0;
			while (-1 != (ch = in.read())) {
				baos.write(ch);
			}

			// step 2:将输入流转换成字节数组
			data = baos.toByteArray();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (baos != null) {
				try {
					baos.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		// step 3:将字节数组转换成Class对象
		return defineClass(fullName, data, 0, data.length);
	}

}
