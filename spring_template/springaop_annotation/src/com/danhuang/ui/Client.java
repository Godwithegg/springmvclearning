package com.danhuang.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.config.SpringConfiguration;
import com.danhuang.service.CustomerService;

/**
 * 最好用环绕通知！！执行顺序才会一致
 * @author danhuang
 *
 */
public class Client
{
	public static void main(String[] args)
	{
		//ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
		CustomerService sc = (CustomerService) ac.getBean("customerService");
		sc.saveCustomer();
//		sc.updateCustomer(12);
//		sc.deleteCustomer();
	}
}
