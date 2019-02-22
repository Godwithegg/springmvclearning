package com.danhuang.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.domain.Account;
import com.danhuang.service.AccountService;

/**
 * ≤‚ ‘¿‡
 * @author danhuang
 *
 */
public class Client
{
	public static void main(String[] args)
	{
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		AccountService accountService = (AccountService) ac.getBean("accountService");
//		Account sc = accountService.findAccountById(1);
//		System.out.println(sc);
		accountService.transfer("a", "b", 1.0f);
	}
}
