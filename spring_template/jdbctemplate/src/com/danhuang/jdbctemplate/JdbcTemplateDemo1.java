package com.danhuang.jdbctemplate;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的最基本用法
 * @author danhuang
 *
 */
public class JdbcTemplateDemo1
{
	public static void main(String[] args)
	{
		//定义数据源
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/test");
		ds.setUsername("root");
		ds.setPassword("123456");

		
		//1.获取对象
		//JdbcTemplate jt = new JdbcTemplate(ds);
		JdbcTemplate jt = new JdbcTemplate();
		jt.setDataSource(ds);
		//2.执行操作
		jt.execute("insert into test(username) values('你好')");
	}
}
