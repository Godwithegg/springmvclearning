package com.danhuang.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.danhuang.domain.Test;



/**
 * JdbcTemplate的入门
 * @author danhuang
 *
 */
public class JdbcTemplateDemo2
{
	public static void main(String[] args)
	{
		//1.获取容器
		ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
		//2.根据id获取bean对象
		JdbcTemplate jt = (JdbcTemplate) ac.getBean("jdbcTemplate");
		//3.执行操作
		//保存
		//jt.update("insert into test(username) values(?)", "a");
		//更新
		//jt.update("update test set username=? where id=?","c",4);
		//删除
		//jt.update("delete from test where id=?",4);
		//查询所有
//		List<Test> tests = jt.query("select * from test where id > ?",new BeanPropertyRowMapper<Test>(Test.class) ,10);
//		System.out.println(tests);
		//查询一个
//		List<Test> test = jt.query("select * from test where id = ?",new BeanPropertyRowMapper<Test>(Test.class) ,100);
//		System.out.println(test.isEmpty()?"没有结果":test);
		List<Test> test = jt.query("select * from test where id = ?",new TestRowMapper() ,100);
		System.out.println(test.isEmpty()?"没有结果":test);
		//查询返回一行一列：聚合函数的使用
		//queryForObject是spring 3.x之后的新方法，在3.x之前，它的方法是多个：queryForInt queryForLong...,靠第三个进行强转
		Integer count1 = jt.queryForObject("select count(*) from test where id > ?", Integer.class,10);
		Long count2 = jt.queryForObject("select count(*) from test where id > ?", Long.class,10);
		System.out.println(count1+count2);
	}
}
class TestRowMapper implements RowMapper<Test>
{

	@Override
	public Test mapRow(ResultSet rs, int index) throws SQLException
	{
		Test test = new Test();
		test.setId(rs.getInt("id"));
		test.setUsername(rs.getString("username"));
		test.setUser_id(rs.getInt("user_id"));
		return test;
	}
	
}
