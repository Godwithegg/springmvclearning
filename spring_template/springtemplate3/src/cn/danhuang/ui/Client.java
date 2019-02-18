package cn.danhuang.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.service.ICustomService;

/**
 * 
  * 项目名称:  springtemplate
  * 包:      cn.danhuang.ui    
  * 类名称:   Client 
  * 类描述:   spring三种传值方式
  * 创建人:   danhuang 
  * 创建时间:  2019年2月18日 下午3:32:24   
  *
 */
public class Client
{
//	/**
//	 * 构造器传值
//	 * @param args
//	 */
//	@SuppressWarnings("all")
//	public static void main(String[] args)
//	{
//		//获取容器
//		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//		//根据bean的id获取对象
//		ICustomService cs = (ICustomService) ac.getBean("customerService");
//		
//		cs.saveCustomer();
//	}
	
//	/**
//	 * set方法传值
//	 * @param args
//	 */
//	@SuppressWarnings("all")
//	public static void main(String[] args)
//	{
//		//获取容器
//		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//		//根据bean的id获取对象
//		ICustomService cs = (ICustomService) ac.getBean("customerService2");
//		cs.saveCustomer();
//	}
	
	/**
	 * 复杂类型方法传值
	 * @param args
	 */
	@SuppressWarnings("all")
	public static void main(String[] args)
	{
		//获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//根据bean的id获取对象
		ICustomService cs = (ICustomService) ac.getBean("customerService3");
		cs.saveCustomer();
	}
	
}
