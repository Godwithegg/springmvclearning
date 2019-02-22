package com.danhuang.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.danhuang.dao.TestDao;
import com.danhuang.domain.Test;

//jdbcDaoSupport结合TestDaoImpl2的思考方式
public class JdbcDaoSupport
{
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate)
	{
		this.jdbcTemplate = jdbcTemplate;
	}

	public JdbcTemplate getJdbcTemplate()
	{
		return jdbcTemplate;
	}
	public void setDataSource(DataSource dataSource)
	{
		//判断jdbcTemplate是否为null
		if(jdbcTemplate == null)
		{
			createJdbcTemplate(dataSource);
		}
	}

	private void createJdbcTemplate(DataSource dataSource)
	{
		jdbcTemplate = new JdbcTemplate(dataSource);
		
	}
	
	
}
