package com.danhuang.service.impl;

import com.danhuang.service.CustomerService;
import com.danhuang.utils.Logger;

/**
 * 模拟客户层业务的实现类
 * @author danhuang
 *
 */
public class CustomerServiceImpl implements CustomerService
{

	@Override
	public void saveCustomer()
	{
		System.out.println("保存了客户...");
		
	}

	@Override
	public void updateCustomer(int i)
	{
		System.out.println("更新了客户...");
		
	}

	@Override
	public int deleteCustomer()
	{
		System.out.println("删除了客户...");
		return 0;
	}

}
