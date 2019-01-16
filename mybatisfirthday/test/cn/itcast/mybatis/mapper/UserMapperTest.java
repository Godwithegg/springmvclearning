package cn.itcast.mybatis.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.itcast.mybatis.po.User;
import cn.itcast.mybatis.po.UserCustom;
import cn.itcast.mybatis.po.UserQueryVo;

public class UserMapperTest
{
	private SqlSessionFactory sqlSessionFactory ;
	@Before
	public void setUp() throws Exception
	{
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}

	@Test
	public void testFindUserList() throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		
		//创建包装对象，设置查询条件
		UserQueryVo userQueryVo = new UserQueryVo();
		UserCustom userCustom = new UserCustom();
		userCustom.setSex("1");
		userCustom.setUsername("张小明");
		//传入多个ID
		List<Integer> ids= new ArrayList<>();
		ids.add(1);
		ids.add(10);
		ids.add(16);
		userQueryVo.setIds(ids);
		userQueryVo.setUserCustom(userCustom);
		List<UserCustom> list = userMapper.findUserList(userQueryVo);
		System.out.println(list);
		
		
	}
	
//	@Test
//	public void testFindUserCount() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		//创建包装对象，设置查询条件
//		UserQueryVo userQueryVo = new UserQueryVo();
//		UserCustom userCustom = new UserCustom();
//		userCustom.setSex("1");
//		userCustom.setUsername("张三丰");
//		userQueryVo.setUserCustom(userCustom);
//		int count = userMapper.findUserCount(userQueryVo);
//		System.out.println(count);
//		
//		
//	}
	
//	@Test
//	public void testFindUserById() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		User user = userMapper.findUserById(1);
//		System.out.println(user);
//		
//		sqlSession.close();
//	}
	
//	@Test
//	public void testFindUserResultMap() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		User user = userMapper.findUserByIdResultMap(10);
//		System.out.println(user);
//		
//		sqlSession.close();
//	}

//	@Test
//	public void testFindUserByName() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		List<User> list = userMapper.findUserByName("%小明");
//		System.out.println(list);
//		
//		sqlSession.close();
//	}

//	@Test
//	public void testInsertUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//		User user = new User();
//		user.setId(100);
//		user.setUsername("danhuangtongxue");
//		user.setSex("1");
//		user.setBirthday(new Date());
//		user.setAddress("福建漳州");
//	
//		userMapper.insertUser(user);
//		sqlSession.commit();
//		sqlSession.close();
//	}
	
//	@Test
//	public void testDeleteUser() throws Exception
//	{
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
//		
//
//		userMapper.deleteUser(32);
//		sqlSession.commit();
//		sqlSession.close();
//	}
	
	
}
