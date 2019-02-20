package com.danhuang.service;

/**
 * 模拟客户的业务层
 * @author danhuang
 *
 */
public interface CustomerService
{
	/**
	 * 保存客户
	 */
	void saveCustomer();
	
	/**
	 * 更新客户
	 * @param i
	 */
	void updateCustomer(int i);
	
	/**
	 * 删除客户
	 * @return
	 */
	int deleteCustomer();
}
