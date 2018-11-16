package cn.itcast.service;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import cn.itcast.dao.AccountDao;

public class AccountServiceDaoImpl implements AccountServiceDao
{
	private AccountDao ad;
	private TransactionTemplate tt;
	public void setTt(TransactionTemplate tt)
	{
		this.tt = tt;
	}

	public void setAd(AccountDao ad)
	{
		this.ad = ad;
	}

	@Override
	@Transactional(isolation=Isolation.REPEATABLE_READ,propagation=Propagation.REQUIRED,readOnly=false)
	public void transfer(Integer from, Integer to, Double money)
	{
		ad.increaseMoney(to,money);
		ad.decreaseMoney(from, money);
	}

}
