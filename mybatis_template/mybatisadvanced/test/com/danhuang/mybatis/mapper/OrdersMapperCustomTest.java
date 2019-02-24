package com.danhuang.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.danhuang.mybatis.po.Orders;
import com.danhuang.mybatis.po.OrdersCustom;

public class OrdersMapperCustomTest
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

//	@Test
//	public void testFindOrdersUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
//		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
//		System.out.println(list);
//		sqlSession.close();
//	}
	
	@Test
	public void testFindOrdersUserResultMap() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list);
		sqlSession.close();
	}

}
