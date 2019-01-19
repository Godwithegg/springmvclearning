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
import cn.itcast.mybatis.po.User;

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

//	@Test
//	public void testFindOrdersUserResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersUserResultMap();
//		System.out.println(list.toString());
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindOrdersAndOrderDetailResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersAndOrderDetailResultMap();
//		System.out.println(list);
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindUserAdnItemsResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<User> list = ordersMapperCustom.findUserAdnItemsResultMap();
//		System.out.println(list);
//		sqlSession.close();
//	}

//	@Test
//	public void testFindOrdersUserLazyLoading() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		OrdersMapperCustom ordersMapperCustom = sqlSession.getMapper(OrdersMapperCustom.class);
//		List<Orders> list = ordersMapperCustom.findOrdersUserLazyLoading();
//		for(Orders orders : list)
//		{
//			User user = orders.getUser();
//			System.out.println(user);
//		}
//		
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
//		
//		//如果执行commit操作（执行插入、更新、删除），会清空一级缓存，保证数据是最新
////		userMapper.deleteUser(2);
	//		sqlSession.commit();
//		
//		//第二次发起请求，查询id为1的用户
//		User user2 = userMapper.findUserById(1);
//		System.out.println(user2);
//		sqlSession.close();
//	}
	
	//二级缓存测试
	@Test
	public void testCache2() throws Exception
	{
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		UserMapper userMapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper userMapper2 = sqlSession2.getMapper(UserMapper.class);
		
		//第一次发起请求，查询id为1的用户
		User user1 = userMapper1.findUserById(1);
		System.out.println(user1);
		//执行关闭操作，将sqlsession中的数据写到二级缓存区域
		sqlSession1.close();
	
		//使用sqlsession3执行commit操作
//		UserMapper userMapper3 = sqlSession3.getMapper(UserMapper.class);
//		userMapper3.deleteUser(2);
//		sqlSession3.commit();
//		sqlSession3.close();
		
		//第二次发起请求，查询id为1的用户
		User user2 = userMapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
	}
}
