package com.danhuang.service;

import java.util.Date;

public class ICustomServiceImpl2 implements ICustomService
{
	private String driver;
	private Integer port;
	private Date today;
	//以上三个字段没有具体的实际意义，只是用于演示注入

	public void setDriver(String driver)
	{
		this.driver = driver;
	}
	public void setPort(Integer port)
	{
		this.port = port;
	}
	public void setToday(Date today)
	{
		this.today = today;
	}
	@Override
	public void saveCustomer()
	{
		System.out.println("调用到:"+driver+","+port+","+today);
	}


	
}
