package cn.itcast.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.util.Date;
import java.util.List;

import javax.swing.text.html.ListView;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import cn.itcast.mybatis.po.User;

public class MyhabitsFirst
{
//	@Test
//	public void findUserByIdTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		User user = sqlSession.selectOne("test.findUserById", 1);
//		System.out.println(user);
//	}

//	@Test
//	public void findUserByName() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		List<User> list = sqlSession.selectList("test.findUserByName", "小明");
//
//		System.out.println(list);
//
//		sqlSession.close();
//	}
	
//	@Test
//	public void insertUserTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		User user = new User();
//		user.setUsername("蛋黄");
//		user.setBirthday(new Date());
//		user.setSex("1");
//		user.setAddress("福建漳州");
//		sqlSession.insert("test.insertUser", user);
//		sqlSession.commit();
//		
//		sqlSession.close();
//	}
	
//	@Test
//	public void deleteUserByIdTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputStream = Resources.getResourceAsStream(resource);
//		
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		sqlSession.delete("test.deleteUser",27);
//		sqlSession.commit();
//		sqlSession.close();
//	}
	
	@Test
	public void updateUserTest() throws IOException
	{
		String resource = "sqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);		
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(10);
		user.setUsername("danhuang");
		user.setBirthday(new Date());	
		user.setSex("1");
		user.setAddress("guan");
		sqlSession.update("test.updateUser",user);
		
		sqlSession.commit();
		sqlSession.close();
	}
	
}
