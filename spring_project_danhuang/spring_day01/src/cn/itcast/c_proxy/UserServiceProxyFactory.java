package cn.itcast.c_proxy;

import java.lang.reflect.Method;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import cn.itcast.service.UserService;
import cn.itcast.service.UserServiceImpl;

public class UserServiceProxyFactory implements MethodInterceptor
{
	public UserService getUserServiceProxy()
	{
		Enhancer en =new Enhancer();
		en.setSuperclass(UserServiceImpl.class);
		en.setCallback(this);
		UserService us = (UserService) en.create();
		return us;
	}

	@Override
	public Object intercept(Object proxyobj, Method method, Object[] arg, MethodProxy methodProxy) throws Throwable
	{
		System.out.println("打开事务");
		Object returnValue = methodProxy.invokeSuper(proxyobj, arg);
		System.out.println("提交事务");
		return returnValue;
	}
	
}
