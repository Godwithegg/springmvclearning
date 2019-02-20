package com.danhuang.cglib;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 模拟一个剧组
 * @author danhuang
 *
 */
public class Client
{
	public static void main(String[] args)
	{
		final Actor actor = new Actor();
//		actor.basicAct(100f);
//		actor.dangerAct(500f);
		/**
		 * 动态代理:
		 * 		作用：不改变源码的基础上，对已有的方法进行增强。（AOP思想的实现技术）
		 * 		分类：
		 * 			基于接口的动态代理：被代理类最少实现一个接口，
		 * 				提供者：JDK官方
		 * 				涉及的类：Proxy
		 * 				创建对象的方法：newProxyInstance(ClassLoader, Class[], InvocationHandler)
		 * 					参数的含义：
		 * 						ClassLoader：类加载器。和被代理对象使用同样的类加载器。一般都是固定写法。
		 * 						Class[]:字节码数组。被代理类实现的接口（要求代理对象和被代理对象具有相同的行为。一般都是固定写法
		 * 						InvocationHandler:它是一个接口，就是用于我们提供代码的。我们一般都是写一个该接口的实现类，可以是匿名内部类，也可以不是
		 * 										它的含义就是：如何代理。此处代码只能是谁用谁提供。
		 * 										策略模式：
		 * 											使用要求：数据已经有了，目的明确，达成过程就是策略
		 * 										在dbutils中的ResultSetHandler就是策略模式的具体应用。
		 *			基于子类的动态代理：
		 *				要求：被代理类不能是最终类。不能被final修饰
		 *				提供者：第三方cglib
		 *				涉及的类：Enhancer
		 *				创建代理对象的方法：create（class,Callback)
		 *				参数的含义：
		 *					Class：被代理对象的字节码
		 *					Callback：如何代理。它和invocationhandler作用是一样的。它也是一个接口，我们一般使用该接口的子接口Method'Inter'ceptor
		 *						在使用时，我们也是创建该接口的匿名内部类。
		 *				
		 */
		Actor cglibActor = (Actor)Enhancer.create(actor.getClass(), new MethodInterceptor()
		{
			/**
			 * 执行被代理对象的任何方法都会经过该方法。它和基于接口动态代理的invoke的作用是一模一样的
			 *方法参数：
			 *	前面三个和invoke方法参数含义作用一致
			 *		MethodProxy methodProxy：当前执行方法的代理对象，一般不用。
			 */
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable
			{
				Object rtValue = null;
				//1.取出执行方法中的参数
				Float money = (Float)args[0];
				//2.判断当前执行的是什么方法
				if("basicAct".equals(method.getName()))
				{
					//基本演出
					if(money > 10000)
					{
						//执行方法
						rtValue = method.invoke(actor, money);
					}
				}
				if("dangerAct".equals(method.getName()))
				{
					//危险演出
					if(money > 50000)
					{
						//执行方法
						rtValue = method.invoke(actor,money);
					}
				}
				return rtValue;
			}
		});
		cglibActor.basicAct(20000);
		cglibActor.dangerAct(1000000);
	}
}
