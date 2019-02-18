package com.danhuang.ui;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.service.ICustomService;


public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		ICustomService cs = (ICustomService) ac.getBean("iCustomServiceImpl");
		System.out.println(cs);
	}
}
