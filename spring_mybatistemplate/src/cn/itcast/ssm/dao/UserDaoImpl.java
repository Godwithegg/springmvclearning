package cn.itcast.ssm.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import cn.itcast.ssm.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao
{

	@Override
	public User findUserById(int id) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById", id);
		return user;
	}
	@Override
	public List<User> findUserByNmae(String name) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		List<User> list = sqlSession.selectList("test.findUserByName",name);
		return list;
	}
	@Override
	public void insertUser(User user) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.insert("test.insertUser", user);
		sqlSession.commit();
	}

	@Override
	public void deleteUser(int id) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		sqlSession.delete("test.deleteUser", id);
		sqlSession.commit();
		
	}

	
}
