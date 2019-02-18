package com.danhuang.service;


public class ICustomServiceImpl implements ICustomService
{
	public ICustomServiceImpl()
	{
		System.out.println("bean对象被创建");
	}
	public void init()
	{
		System.out.println("对象初始化");
	}
	public void destroy()
	{
		System.out.println("对象销毁了");
	}
	@Override
	public void saveCustomer()
	{
		System.out.println("测试一下");
	}
	
}
