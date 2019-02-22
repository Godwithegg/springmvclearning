package com.danhuang.dao.impl;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.danhuang.dao.TestDao;
import com.danhuang.domain.Test;

/**
 * Test表的业务层实现类
 * @author danhuang
 *
 */
public class TestDaoImpl2 extends JdbcDaoSupport implements TestDao
{

	@Override
	public Test findTestById(Integer testId)
	{
		List<Test> tests = getJdbcTemplate().query("select * from test where id=?",new BeanPropertyRowMapper<Test>(Test.class),testId);
		return tests.isEmpty()?null:tests.get(0);
	}

	@Override
	public Test findTestByName(String username)
	{
		List<Test> tests = getJdbcTemplate().query("select * from test where username=?",new BeanPropertyRowMapper<Test>(Test.class),username);
		if(tests.isEmpty()) 
		{
			return null;//没有这个名称账户
		}
		if(tests.size() > 1)
		{
			//结果集不唯一，不符合我们的约定
			throw new RuntimeException("结果集不唯一，请检查数据");
		}
		return tests.get(0);
	}

	@Override
	public void updateTest(Test test)
	{
		getJdbcTemplate().update("update test set username=? where id=?",test.getUsername(),test.getId());
	}
	
}
