package com.danhuang.ssm.dao.impl;

import static org.junit.Assert.*;

import org.aspectj.apache.bcel.util.ClassPath;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.ssm.dao.UserDao;
import com.danhuang.ssm.po.User;

public class UserDaoImplTest
{
	private ApplicationContext ac;
	//在setUp这个方法中得到spring的容器
	@Before
	public void setUp() throws Exception
	{
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception
	{
		UserDao userDao = (UserDao) ac.getBean("userDao");
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
