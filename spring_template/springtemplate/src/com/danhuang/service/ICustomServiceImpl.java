package com.danhuang.service;

import com.danhuang.dao.ICustomerDao;

public class ICustomServiceImpl implements ICustomService
{
	private ICustomerDao customerDao = null;
	@Override
	public void saveCustomer()
	{
		System.out.println("业务层调用持久层");
		customerDao.saveCustomer();
	}
	
}
