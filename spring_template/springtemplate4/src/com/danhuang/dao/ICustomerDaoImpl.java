package com.danhuang.dao;

public class ICustomerDaoImpl implements ICustomerDao
{

	@Override
	public void saveCustomer()
	{
		System.out.println("持久层保持了客户");
	}
	
}
