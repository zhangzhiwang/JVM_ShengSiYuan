/**
 * 测试命名空间
 * 
 * @author zhangzhiwang
 * @date 2018年1月26日 下午12:38:31
 */
public class TestNameSpace {
	public static void main(String[] args) throws Exception {
		/*
		 * 命名空间就是由某类加载器及其所有父类加载器所加载的类构成。同一命名空间的类可以互相访问，但一种情况除外：父类加载器所加载的类不能访问子类加载器所加载的类。
		 */
		String classPath1 = "/Users/zhangzhiwang/Desktop/server/";
		MyClassLoader loader1 = new MyClassLoader("loader1", classPath1);
		System.out.println("loader1:");
		test(loader1);
		System.out.println("----------------");
		System.out.println("TestNameSpace is loaded by " + TestNameSpace.class.getClassLoader());
		System.out.println("----------------");

		Test30 test30 = (Test30) loader1.loadClass("Test30").newInstance();//由于loader1和系统类加载器存在父子关系且Test30被loader1加载，TestNameSpace被系统类加载器加载，虽然在同一命名空间中，但父类加载器加载的TestNameSpace不能访问由子类加载器加载的Test30
		System.out.println(test30);

	}

	private static void test(ClassLoader loader)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = loader.loadClass("Test30");
		clazz.newInstance();
	}
}
