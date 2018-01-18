//package com.asiainfo;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//import java.util.Set;
//
//import net.sf.cglib.beans.BeanGenerator;
//import net.sf.cglib.beans.BeanMap;
//
///**
// * 测试方法区
// * 
// * @author zhangzhiwang
// * @date 2018年1月10日 上午10:10:04
// */
//public class Test10 {
//	public static void main(String[] args) {
//		int i = 0;
//		try {
//			for (i = 0; i < 1000000; i++) {
//				HashMap<String, Object> propertyMap = new HashMap<>();
//				propertyMap.put("id", Class.forName("java.lang.Integer"));
//				propertyMap.put("name", Class.forName("java.lang.String"));
//				propertyMap.put("address", Class.forName("java.lang.String"));
//
//				new CglibBean(propertyMap);
//			}
//		} catch (Exception e) {
//			System.out.println("总共创建：" + i);
//			e.printStackTrace();
//		}
//	}
//}
//
//class CglibBean {
//	/**
//	 * 实体Object
//	 */
//	public Object object = null;
//
//	/**
//	 * 属性map
//	 */
//	public BeanMap beanMap = null;
//
//	public CglibBean() {
//		super();
//	}
//
//	@SuppressWarnings("unchecked")
//	public CglibBean(Map propertyMap) {
//		this.object = generateBean(propertyMap);
//		this.beanMap = BeanMap.create(this.object);
//	}
//
//	/**
//	 * 给bean属性赋值
//	 * 
//	 * @param property
//	 *            属性名
//	 * @param value
//	 *            值
//	 */
//	public void setValue(String property, Object value) {
//		beanMap.put(property, value);
//	}
//
//	/**
//	 * 通过属性名得到属性值
//	 * 
//	 * @param property
//	 *            属性名
//	 * @return 值
//	 */
//	public Object getValue(String property) {
//		return beanMap.get(property);
//	}
//
//	/**
//	 * 得到该实体bean对象
//	 * 
//	 * @return
//	 */
//	public Object getObject() {
//		return this.object;
//	}
//
//	@SuppressWarnings("unchecked")
//	private Object generateBean(Map propertyMap) {
//		BeanGenerator generator = new BeanGenerator();
//		Set keySet = propertyMap.keySet();
//		for (Iterator i = keySet.iterator(); i.hasNext();) {
//			String key = (String) i.next();
//			generator.addProperty(key, (Class) propertyMap.get(key));
//		}
//		return generator.create();
//	}
//}
