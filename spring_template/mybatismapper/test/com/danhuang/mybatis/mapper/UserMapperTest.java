package com.danhuang.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.danhuang.mybatis.po.User;
import com.danhuang.mybatis.po.UserCustom;
import com.danhuang.mybatis.po.UserQueryVo;

public class UserMapperTest
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
	//用户信息综合查询
//	@Test
//	public void testFindUserList() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//创建包装对象
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setSex("1");
//		userCustom.setUsername("张三丰");
//		userQueryVo.setUserCustom(userCustom);
//		List<UserCustom> lists = userMapper.findUserList(userQueryVo);
//		sqlSession.close();
//		System.out.println(lists);
//	}
	
//	@Test
//	public void testFindUserCount() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//创建包装对象
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setSex("1");
//		userCustom.setUsername("张三丰");
//		userQueryVo.setUserCustom(userCustom);
//		int account = userMapper.findUserCount(userQueryVo);
//		sqlSession.close();
//		System.out.println(account);
//	}

//	@Test
//	public void testFindUserById() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = userMapper.findUserById(1);
//		sqlSession.close();
//		System.out.println(user);
//	}
	
	@Test
	public void testFindUserByIdResultMap() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建一个usermapper对象,mybatis自动生成mapper代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.findUserByIdResultMap(1);
		sqlSession.close();
		System.out.println(user);
	}
	
//	@Test
//	public void testFindUserByName() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		List<User> list = userMapper.findUserByName("小明");
//		sqlSession.close();
//		System.out.println(list);
//	}
	
//	@Test
//	public void testInsertUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		User user = new User();
//		user.setUsername("client");
//		user.setBirthday(new Date());
//		user.setAddress("北京");
//		user.setSex("2");
//		userMapper.insertUser(user);
//		sqlSession.commit();
//		sqlSession.close();
//	}
	
//	@Test
//	public void testDeleteUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//创建一个usermapper对象,mybatis自动生成mapper代理对象
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		userMapper.deleteUser(37);
//		sqlSession.commit();
//		sqlSession.close();
//	}

}
