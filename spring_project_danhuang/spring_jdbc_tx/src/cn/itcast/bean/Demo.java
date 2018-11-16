package cn.itcast.bean;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.itcast.service.AccountServiceDao;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext2.xml")
public class Demo
{
	@Resource(name="accountService")
	private AccountServiceDao as;
	@Test
	public void fun1()
	{
		as.transfer(1, 2, 100d);
	}
}
