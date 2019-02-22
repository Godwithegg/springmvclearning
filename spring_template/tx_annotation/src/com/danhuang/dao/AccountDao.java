package com.danhuang.dao;

import com.danhuang.domain.Account;

public interface AccountDao
{
	/**
	 * 根据id查询账户信息
	 * @param accountId
	 * @return
	 */
	Account findAccountById(Integer accountId);
	
	/**
	 * 根据名称查询账户信息
	 * @param name
	 * @return	要求：账户名称必须唯一，如果不唯一应该抛异常
	 */
	Account findAccountByName(String name);
	
	/**
	 * 更新账户信息
	 * @param account
	 */
	void updateAccount(Account account);
}
