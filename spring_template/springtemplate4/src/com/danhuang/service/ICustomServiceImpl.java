package com.danhuang.service;


import org.springframework.stereotype.Component;

import com.danhuang.dao.ICustomerDao;

/**
 * 客户的业务层实现类
 * @author danhuang
 *<bean id="customerService" class="com.danhuang.service.ICustomServiceImpl"></bean>
 *	1.用于创建bean对象
 *	2.用于注入数据的
 *	3.用于改变作用范围
 *	4.和生命周期相关的
 *	5.spring的新注解
 *	@Component：相当于配置了一个bean标签，出现在类上，属性：value，含义是指定bean的id，
 *		不写时默认为当前类的短名首字母改小写.原来还有另外的一个特殊处理：当类的名字是以两个或以上的大写字母开头的话，bean的名字会与类名保持一致
 *		注解一般来自于context包
 *		由此直接衍生的三个注解：
 *			@Controller	一般用于表现出
 *			@Service	一般用于业务层
 *			@Repository	一般用于持久层
 *			他们和@Component作用及属性都是一模一样
 */
@Component("iCustomServiceImpl")
public class ICustomServiceImpl implements ICustomService
{
	private ICustomerDao customerDao = null;
	
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer()
	{
		System.out.println("业务层调用持久层...");
		customerDao.saveCustomer();
	}
	


	
}
