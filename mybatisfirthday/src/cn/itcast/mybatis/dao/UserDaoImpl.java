package cn.itcast.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.itcast.mybatis.po.User;

public class UserDaoImpl implements UserDao
{
	private SqlSessionFactory sqlSessionFactory;
	public  UserDaoImpl(SqlSessionFactory sqlSessionFactory)
	{
		this.sqlSessionFactory=sqlSessionFactory;
	}
	@Override
	public User findUserById(int id) throws Exception
	{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		sqlSession.close();
		return user;
	}
	@Override
	public List<User> findUserByNmae(String name) throws Exception
	{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		List<User> list = sqlSession.selectList("test.findUserByName",name);
		sqlSession.close();
		return list;
	}
	@Override
	public void insertUser(User user) throws Exception
	{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
		sqlSession.close();
	}

	@Override
	public void deleteUser(int id) throws Exception
	{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		sqlSession.close();
		
	}

	
}
