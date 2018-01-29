

/**
 * 测试类加载器
 *
 * @author zhangzhiwang
 * @date 2018年1月28日 上午10:56:39
 */
public class Test31 {
	public Test31() {
		System.out.println("Test31 is loaded by " + this.getClass().getClassLoader());
	}
}
