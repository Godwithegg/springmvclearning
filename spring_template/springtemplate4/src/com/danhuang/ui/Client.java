package com.danhuang.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.service.ICustomService;


public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomService cs1 = (ICustomService) ac.getBean("ICustomServiceImpl");
		ICustomService cs2 = (ICustomService) ac.getBean("ICustomServiceImpl");
		
		System.out.println(cs1==cs2);
	}
}
