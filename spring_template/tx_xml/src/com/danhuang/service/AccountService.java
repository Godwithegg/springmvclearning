package com.danhuang.service;

import com.danhuang.domain.Account;

/**
 * 账户的业务层接口
 * @author danhuang
 *
 */


public interface AccountService
{
	//根据id查询test信息
	Account findAccountById(Integer accountId);
	/**
	 * 转账
	 * @param sourceName	转出
	 * @param targetName	转入
	 * @param money	金额
	 */
	void transfer(String sourceName,String targetName,Float money);
}
