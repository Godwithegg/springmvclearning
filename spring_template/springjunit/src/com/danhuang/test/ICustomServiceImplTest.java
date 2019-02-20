package com.danhuang.test;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.danhuang.service.ICustomServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:bean.xml"})
public class ICustomServiceImplTest
{
	@Resource
	private ICustomServiceImpl cs;
	@Test
	public void testSaveCustomer()
	{
		cs.saveCustomer();
	}

}
