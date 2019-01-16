package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.Orders;
import cn.itcast.mybatis.po.OrdersCustom;

public class OrdersMapperCustomTest
{

	private SqlSessionFactory sqlSessionFactory ;
	@Before
	public void setUp() throws Exception
	{
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

//	@Test
//	public void testFindOrdersUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<OrdersCustom> list = ordersMapperCustom.findOrdersUser();
//		System.out.println(list.toString());
//		sqlSession.close();
//	}

	@Test
	public void testFindOrdersUserResultMap() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
		System.out.println(list.toString());
		sqlSession.close();
	}
}
