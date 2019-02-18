package com.danhuang.factory;

import com.danhuang.service.ICustomService;
import com.danhuang.service.ICustomServiceImpl;

/**
 * 
  * 项目名称:  springtemplate2
  * 包:      com.danhuang.factory    
  * 类名称:   模拟一个实例工厂
  * 类描述:   一句话描述该类的功能
  * 创建人:   danhuang   
  * 创建时间:  2019年2月18日 下午6:26:16   
  *
 */
public class InstanceFactory implements ICustomService
{
	public ICustomService getCustomerService()
	{
		return new ICustomServiceImpl();
	}

	@Override
	public void saveCustomer()
	{
		// TODO Auto-generated method stub
		
	}
}
