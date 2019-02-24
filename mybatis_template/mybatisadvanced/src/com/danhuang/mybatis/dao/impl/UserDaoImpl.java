package com.danhuang.mybatis.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.danhuang.mybatis.dao.UserDao;
import com.danhuang.mybatis.po.User;

/**
 * dao接口实现类
 * @author danhuang
 *
 */
public class UserDaoImpl implements UserDao
{
	private SqlSessionFactory sqlSessionFactory;
	//需要向dao实现类中注入sqlsessionfactory
	//这里通过构造函数注入
	public UserDaoImpl(SqlSessionFactory sqlSessionFactory)
	{
		this.sqlSessionFactory = sqlSessionFactory;
	}
	@Override
	public User findUserById(int id) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		//释放资源
		sqlSession.close();
		return user;
	}
	@Override
	public List<User> findUserByName(String name) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByName",name);
		//释放资源
		sqlSession.close();
		return list;
	}

	@Override
	public void insertUser(User user) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		//释放资源
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception
	{
		SqlSession sqlSession = sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser",id);
		sqlSession.commit();
		sqlSession.close();
	}

	
}
