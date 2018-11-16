package cn.itcast.dao;

import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao
{

	@Override
	public void increaseMoney(Integer id, Double money)
	{
		getJdbcTemplate().update("UPDATE t_account SET money=money+? WHERE id=?",money,id);
	}

	@Override
	public void decreaseMoney(Integer id, Double money)
	{
		getJdbcTemplate().update("UPDATE t_account SET money=money-? WHERE id=?",money,id);
	}

}
