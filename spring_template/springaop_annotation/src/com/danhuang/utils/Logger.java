package com.danhuang.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 一个用于记录日志的类
 * @author danhuang
 *
 */
@Component("logger")
@Aspect  //配置了切面
public class Logger
{
	@Pointcut("execution(* com.danhuang.service.impl.*.*(..))")
	private void pt1(){}
	/**
	 * 记录日志的操作
	 * 计划其在业务核心方法（切入点
	 */
	/**
	 * 前置通知
	 */
	@Before("pt1()")
	public void beforePrintLog()
	{
		System.out.println("Logger中的beforePrintLog方法开始记录日志了。。前置通知");
	}
	/**
	 * 后置通知
	 */
	@AfterReturning("pt1()")
	public void afterReturningPrintLog()
	{
		System.out.println("Logger中的afterReturningPrintLog方法开始记录日志了。。返回通知");
	}
	/**
	 * 异常通知
	 */
	@AfterThrowing("pt1()")
	public void afterThrowingPrintLog()
	{
		System.out.println("Logger中的afterThrowingPrintLog方法开始记录日志了。。异常通知");
	}
	/**
	 * 最终通知
	 */
	@After("pt1()")
	public void afterPrintLog()
	{
		System.out.println("Logger中的afterPrintLog方法开始记录日志了。。后置通知");
	}
	/**
	 * 环绕通知
	 * 问题：
	 * 	当我们配置环绕通知时，切入点没有执行，环绕通知里的代码执行了
	 * 分析：
	 * 	由动态代理可知，环绕通知指的是invoke方法，并且里面有明确的切入点方法调用。而我们现在的环绕通知没有明确的切入点方法调用。
	 * 解决：
	 * 	spring为我们提供了一个接口：ProceedingJoinPoint。该接口可以作为环绕通知的方法参数来使用。
	 * 	在程序运行时，spring框架会为我们提供该接口的实现类，供我们使用。
	 *	该接口中有一个方法，proceed()，它的作用就等同于method.invoke()，就是明确调用业务层核心方法（切入点方法
	 *
	 *	环绕通知：
	 *		它是spring框架为我们提供的一种方式（可以在代码中手动控制通知类型的方式
	 */
	@Around("pt1()")
	public Object aroundPrintLog(ProceedingJoinPoint pjp)
	{
		Object rtValue = null;
		try
		{
			System.out.println("Logger中的aroundPrintLog之前置通知");
			rtValue = pjp.proceed();
			System.out.println("Logger中的aroundPrintLog之返回通知");
		} catch (Throwable e)
		{
			System.out.println("Logger中的aroundPrintLog之异常通知");
			e.printStackTrace();
		}finally
		{
			System.out.println("Logger中的aroundPrintLog之后置通知");
		}
		System.out.println("Logger中的around方法结束了。。");
		return rtValue;
	}
}
