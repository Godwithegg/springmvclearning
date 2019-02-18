package cn.danhuang.ui;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.danhuang.service.ICustomService;

/**
 * 
  * 项目名称:  springtemplate
  * 包:      cn.danhuang.ui    
  * 类名称:   Client 
  * 类描述:   spring入门案例
  * 创建人:   danhuang 
  * 创建时间:  2019年2月18日 下午3:32:24   
  *
 */
public class Client
{
	/**
	 * bean的两种加载方式
	 * ctrl+t 看子类
	 * BeanFactory：提供的是一种延迟加载的思想来创建Bean对象
	 * ApplicationContext：提供的是一种立即加载思想来创建bean对象，只要一解析完配置文件就立马创建bean对象
	 * @param args
	 */
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
	
//	@SuppressWarnings("all")
//	public static void main(String[] args)
//	{
//		Resource resource = null;
//		resource = new ClassPathResource("bean.xml");
//		//获取容器
//		BeanFactory factory = new XmlBeanFactory(resource);
//		//根据bean的id获取对象
//		ICustomService cs = (ICustomService) factory.getBean("customerService");
//		
//		cs.saveCustomer();
//	}
	
//	/**
//	* bean的三种创建方式
//	*	1.调用默认无参构造函数创建   (此种方法使用最多
//	*		默认情况下如果类中没有默认无参构造函数，则创建失败会报异常
//	*	2.使用工厂中的方法创建对象
//	*		需要使用bean标签的factory-method指定静态工厂中的创建对象的方法
//	*	3.使用实例工厂中的方法创建
//	*/
//	@SuppressWarnings("all")
//	public static void main(String[] args)
//	{
//		//获取容器
//		BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
//		//根据bean的id获取对象
//		ICustomService cs = (ICustomService) factory.getBean("instanceCustomerService");
//		
//		System.out.println(cs);
//	}
	
//	/**
//	*	bean的作用范围：它可以通过配置的方式来调整作用范围：
//	*		配置的属性：bean标签的scope属性
//	*			取值为：singleton（单例，默认）
//	*				prototype（多例）
//	*				request（作用范围是一次请求和当前请求的转发）
//	*				session（作用范围是一次会话）
//	*				globalsession（作用范围是一次全局会话）
//	*/
//	@SuppressWarnings("all")
//	public static void main(String[] args)
//	{
//		//获取容器
//		BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
//		//根据bean的id获取对象
//		ICustomService cs1 = (ICustomService) factory.getBean("customerService");
//		ICustomService cs2 = (ICustomService) factory.getBean("customerService");
//		
//		System.out.println(cs1==cs2);
//	}
	
	/**
	*	bean的生命周期
	*		涉及bean标签的两个属性：
	*			init-method
	*			destroy-method
	*		单例：
	*			出生：容器创建，对象就出生了。
	*			活着：只要容器在，对象就一直存在。
	*			死亡：容器销毁，对象消亡。
	*		多例：
	*			出生：每次使用时，创建对象
	*			活着：只要对象在使用中就一直活着
	*			死亡：当对象长时间不使用，并且没有别的对象引用时，由java垃圾回收器回收。
	*/
	@SuppressWarnings("all")
	public static void main(String[] args)
	{
		//获取容器
		BeanFactory factory = new ClassPathXmlApplicationContext("bean.xml");
		//根据bean的id获取对象
		ICustomService cs1 = (ICustomService) factory.getBean("customerService");
		ICustomService cs2 = (ICustomService) factory.getBean("customerService");
		
		System.out.println(cs1==cs2);
	}
}
