package cn.itcast.c_proxy;

import org.junit.Test;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;

public class Demo
{
	@Test
	public void fun1()
	{
		UserServiceProxyFactory factory = new UserServiceProxyFactory();
		UserService usProxy = factory.getUserServiceProxy();
		usProxy.delete();
	}
}
