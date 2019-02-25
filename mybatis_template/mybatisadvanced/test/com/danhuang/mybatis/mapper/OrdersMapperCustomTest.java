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
//	@Test
//	public void testFindOrdersUserLazyLoading() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
// 		for (Orders orders : list)
//		{
//			//执行getUser（）去查询用户信息，即按需加载
// 			User user = orders.getUser();
// 			System.out.println(user);
//		}
//		sqlSession.close();
//	}
	
	//一级缓存测试
//	@Test
//	public void testCache1() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//第一次发起请求，查询id为1的用户
//		User user1 = userMapper.findUserById(1);
//		System.out.println(user1);
//		// 如果sqlSession去执行commit操作（执行插入、更新、删除），清空SqlSession中的一级缓存，这样做的目的为了让缓存中存储的是最新的信息，避免脏读。
//
//		// //执行commit操作去清空缓存
//		// sqlSession.commit();
//		
//		//第二次发起请求，查询id为1的用户
//		User user2 = userMapper.findUserById(1);
//		System.out.println(user2);
//		sqlSession.close();
//	}
	
	//二级缓存测试
	//我如果在finduserbyid开启了禁用，二级缓存会因此失效
	@Test
	public void testCache2() throws Exception
	{
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		//第一次发起请求
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		//执行关闭，查询结果存到二级缓存区域中
		sqlSession1.close();
		
		//执行commit操作
		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
		User user3 = userMapper3.findUserById(1);
		//执行提交，清空usermapper下的二级缓存
		sqlSession3.commit();
		sqlSession3.close();
		
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		//第二次发起请求
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
}
