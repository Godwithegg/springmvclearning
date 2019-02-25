package com.danhuang.ssm.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.danhuang.ssm.dao.UserDao;
import com.danhuang.ssm.po.User;


/**
 * dao接口实现类
 * @author danhuang
 *
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao
{

	@Override
	public User findUserById(int id) throws Exception
	{
		SqlSession sqlSession = this.getSqlSession();
		User user = sqlSession.selectOne("test.findUserById",id);
		//方法结束会自动关闭.close
		return user;
	}
	
}
