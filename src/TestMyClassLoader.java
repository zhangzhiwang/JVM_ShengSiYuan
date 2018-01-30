/**
 * 测试自定义的类加载器
 * 
 * @author zhangzhiwang
 * @date 2018年1月26日 下午12:38:31
 */
public class TestMyClassLoader {
	public static void main(String[] args) throws Exception {
		String classPath1 = "/Users/zhangzhiwang/Desktop/server/";//home:/Applications/Eclipse.app/Contents/Eclipse/workspace/JVM_ShengSiYuan/bin/com/asiainfo/server/
		String classPath2 = "/Users/zhangzhiwang/Desktop/client/";//home:/Applications/Eclipse.app/Contents/Eclipse/workspace/JVM_ShengSiYuan/bin/com/asiainfo/client/
		String classPath3 = "/Users/zhangzhiwang/Desktop/other/";//home:/Applications/Eclipse.app/Contents/Eclipse/workspace/JVM_ShengSiYuan/bin/com/asiainfo/other/
		
		MyClassLoader loader1 = new MyClassLoader("loader1", classPath1);//没有给loader1指定附加载器，那么默认系统加载器是其附加载器。
		MyClassLoader loader2 = new MyClassLoader(loader1, "loader2", classPath2);//将loader1作为父加载器，由此可以看出父子加载器不是继承关系而是包装关系
		MyClassLoader loader3 = new MyClassLoader(null, "loader3", classPath3);//loader3将附加载器置为null，则会用根类加载器先进行加载
		
		 //System.out.println("loader1:");
		 //test(loader1);
		 //System.out.println("----------------");
		//System.out.println("loader2:");
		//test(loader2);
		//System.out.println("----------------");
		System.out.println("loader3:");
		test(loader3);
		System.out.println("----------------");
	}
	
	private static void test(ClassLoader loader) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = loader.loadClass("Test30");
		clazz.newInstance();
	}
}
