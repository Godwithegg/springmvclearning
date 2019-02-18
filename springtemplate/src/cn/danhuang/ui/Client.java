package cn.danhuang.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.dao.ICustomerDao;
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
	 * ctrl+t 看子类
	 * ClassPathXmlApoplicationContext:只能加载类路径下配置文件
	 * FileSystemXmlApplicationContext：加载磁盘任意位置的配置文件
	 * @param args
	 */
	public static void main(String[] args)
	{
		//获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//根据bean的id获取对象
		ICustomService cs = (ICustomService) ac.getBean("customerService");
		
		ICustomerDao cdao = (ICustomerDao)ac.getBean("customerDao");
		
		System.out.println(cs);
		System.out.println(cdao);
		
	}
}
