package cn.itcast.service;

public interface AccountServiceDao
{
	void transfer(Integer from,Integer to,Double money);
}
