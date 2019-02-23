package com.danhuang.mybatis.first;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.danhuang.mybatis.po.User;

/**
 * 入门程序
 * @author danhuang
 *
 */
public class MybatisFirst
{
	//根据id查询用户的信息，得到一条记录的结果
//	@Test
//	public void findUserByIdTest() throws IOException
//	{
//		//mybatis配置文件
//		String resource = "sqlMapConfig.xml";
//		//得到配置文件流
//		InputStream inputstream = Resources.getResourceAsStream(resource);
//		//创建会话工厂
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
//		//通过工厂得到sqlsession
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		//通过sqlsession操作数据库
//		//第一个参数：映射文件中statement的id，等于命名空间+statement的id
//		//第二个参数：指定和映射文件中所匹配的pa'ra'men'ter'type类型的参数
//		//sqlsession.selectone结果是配置resulttype中的对象
//		User user = sqlSession.selectOne("test.findUserById", 1);
//		System.out.println(user);
//		
//		//释放资源
//		sqlSession.close();
//		
//	}
	
	//根据用户名字模糊查询用户列表
//	@Test
//	public void findUserByNameTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputstream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		List<User> lists = sqlSession.selectList("test.findUserByName", "小明");
//		System.out.println(lists);
//		//释放资源
//		sqlSession.close();
//		
//	}
	
	//插入用户信息
//	@Test
//	public void insertUserTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputstream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		User user = new User();
//		user.setUsername("小白");
//		user.setAddress("北京");
//		user.setSex("1");
//		user.setBirthday(new Date());
//		sqlSession.insert("test.insertUser", user);
//		sqlSession.commit();
//		//释放资源
//		sqlSession.close();
//		
//	}
	
	//根据id删除用户信息
//	@Test
//	public void deleteUserTest() throws IOException
//	{
//		String resource = "sqlMapConfig.xml";
//		InputStream inputstream = Resources.getResourceAsStream(resource);
//		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
//		SqlSession sqlSession = sqlSessionFactory.openSession();
//		
//		sqlSession.delete("test.deleteUser", 31);
//		sqlSession.commit();
//		//释放资源
//		sqlSession.close();
//		
//	}
	
	//更新用户信息
	@Test
	public void updateUserTest() throws IOException
	{
		String resource = "sqlMapConfig.xml";
		InputStream inputstream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputstream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		User user = new User();
		user.setId(1);
		user.setUsername("小白");
		user.setAddress("北京");
		user.setSex("1");
		user.setBirthday(new Date());
		sqlSession.update("test.updateUser", user);
		sqlSession.commit();
		//释放资源
		sqlSession.close();
		
	}
}
