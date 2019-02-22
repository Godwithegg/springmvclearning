package com.danhuang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danhuang.dao.AccountDao;
import com.danhuang.domain.Account;
import com.danhuang.service.AccountService;

/**
 * 账户的业务层接口
 * @author danhuang
 *
 */

@Service("accountService")
@Transactional
public class AccountServiceImpl implements AccountService
{
	@Autowired
	private AccountDao accountDao;

	public AccountDao getAccountDao()
	{
		return accountDao;
	}


	@Override
	public Account findAccountById(Integer accountId)
	{
		return accountDao.findAccountById(accountId);
	}

	@Override
	public void transfer(String sourceName, String targetName, Float money)
	{
		//1.根据名称查询账户信息
		Account source = accountDao.findAccountByName(sourceName);
		Account target = accountDao.findAccountByName(targetName);
		//2.转出账户减钱，转入加钱
		source.setMoney(source.getMoney() - money);
		target.setMoney(target.getMoney() + money);
		//3.更新账户信息
		accountDao.updateAccount(source);
		accountDao.updateAccount(target);
		
	}
	
}
