package com.danhuang.jdbctemplate;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.danhuang.dao.TestDao;
import com.danhuang.domain.Test;



/**
 * JdbcTemplate在dao中的用法
 * @author danhuang
 *
 */
public class JdbcTemplateDemo3
{
	public static void main(String[] args)
	{
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据id获取bean对象
		TestDao testDao = (TestDao)ac.getBean("testDao");
		//3.执行操作
		Test test = testDao.findTestById(14);
		test.setUsername("aaaa");
		testDao.updateTest(test);
	}
}
