package com.danhuang.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.danhuang.dao.ICustomerDao;

/**
 * 客户的业务层实现类
 * @author danhuang
 *<bean id="customerService" class="com.danhuang.service.ICustomServiceImpl"></bean>
 *@Component：相当于配置了一个bean标签，出现在类上，属性：value，含义是指定bean的id，
 *		不写时默认为当前类的短名首字母改小写.原来还有另外的一个特殊处理：当类的名字是以两个或以上的大写字母开头的话，bean的名字会与类名保持一致
 *		注解一般来自于context包
 *		由此直接衍生的三个注解：
 *			@Controller	一般用于表现出
 *			@Service	一般用于业务层
 *			@Repository	一般用于持久层
 *			他们和@Component作用及属性都是一模一样
 *	1.用于创建bean对象
 *	2.用于注入数据的
 *		@Autowired
 *			作用：自动按照类型注入。只要有唯一的类型屁陪就能注入成功，当我们使用注解注入时，set方法就不是必须的。
 *				如果注入的bean在容器中类型不唯一时，它会把变量名称作为bean的id，在容器中查找，找到后也能注入成功
 *				如果没有找到一致的bean的id，则报错
 *		@Qualifier
 *			作用：在自动按照类型注入的基础之上，再按照bean的id注入。在给类成员注入时不能单独使用，给方法形参注入数据时可以独立使用
 *			属性：
 *				value：用于指定bean的id
 *		@Resource
 *			作用：直接按照bean的id注入
 *			属性：
 *				name：用于指定bean的id
 *		以上三个注解都是用于其他bean类型。用于注入基本类型和String需要用value
 *		@Value：
 *			作用：用于注入基本类型和String类型数据
 *			属性：
 *				value：用于指定要注入的数据。它可以借助spring的el表达式读取properties文件中的配置
 *	3.用于改变作用范围
 *		@Scope
 *			作用：用于改变bean的作用范围
 *			属性：
 *				value:用于指定范围的取值
 *				取值和xml中scope属性的取值是一样的
 *	4.和生命周期相关的
 *	5.spring的新注解
 *	
 */

@Service
@Scope("prototype")
public class ICustomServiceImpl implements ICustomService
{
//	@Autowired
//	@Qualifier("ICustomerDaoImpl2")
	@Resource(name="ICustomerDaoImpl2")
	private ICustomerDao customerDao = null;
	
	@Value("泰森")
	private String name;
	public void setCustomerDao(ICustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	@Override
	public void saveCustomer()
	{
		System.out.println("业务层调用持久层..."+name);
		customerDao.saveCustomer();
	}
	


	
}
