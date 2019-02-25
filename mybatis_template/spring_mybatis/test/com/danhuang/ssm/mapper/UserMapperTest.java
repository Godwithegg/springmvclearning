package com.danhuang.ssm.mapper;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.danhuang.ssm.po.User;

public class UserMapperTest
{
	private ApplicationContext ac;
	@Before
	public void setUp() throws Exception
	{
		ac = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() throws Exception
	{
		UserMapper userMapper = (UserMapper) ac.getBean("userMapper");
		User user = userMapper.findUserById(1);
		System.out.println(user);
	}

}
