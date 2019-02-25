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
import com.danhuang.mybatis.po.User;

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
	
//	@Test
//	public void testFindOrdersUserResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
//		System.out.println(list);
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindOrdersAndOrderDetailResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
//		for (Orders orders : list)
//		{
//			System.out.println(orders);
//		}
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindOrdersAndOrderDetailResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
//		List<User> list = ordersMapperCustom.findUserAndItemsResultMap();
// 		System.out.println(list);
//		sqlSession.close();
//	}
	
	//查询订单关联查询用户,用户信息是延迟加载
	@Test
	public void testFindOrdersUserLazyLoading() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = (OrdersMapperCustom) sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
 		for (Orders orders : list)
		{
			//执行getUser（）去查询用户信息，即按需加载
 			User user = orders.getUser();
 			System.out.println(user);
		}
		sqlSession.close();
	}
}
