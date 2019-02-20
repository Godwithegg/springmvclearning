package com.danhuang.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.service.CustomerService;

public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		CustomerService sc = (CustomerService) ac.getBean("customerService");
		sc.saveCustomer();
//		sc.updateCustomer(12);
//		sc.deleteCustomer();
	}
}
