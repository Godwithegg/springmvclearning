package com.danhuang.dao;

import org.springframework.stereotype.Repository;

@Repository
public class ICustomerDaoImpl2 implements ICustomerDao
{

	@Override
	public void saveCustomer()
	{
		System.out.println("持久层保持了客户222");
	}
	
}
