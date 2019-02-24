package com.danhuang.mybatis.dao.impl;

import static org.junit.Assert.*;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.danhuang.mybatis.dao.UserDao;
import com.danhuang.mybatis.po.User;

public class UserDaoImplTest
{
	private  SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception
	{
		//创建sqlsessionfactory
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	@Test
	public void testFindUserById() throws Exception
	{
		//创建UserDao的对象
		UserDao userDao = new UserDaoImpl(sqlSessionFactory);
		
		//调用userDao方法
		User user = userDao.findUserById(1);
		System.out.println(user);
	}

}
