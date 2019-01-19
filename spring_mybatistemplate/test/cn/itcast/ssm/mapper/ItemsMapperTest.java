package cn.itcast.ssm.mapper;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsExample;

public class ItemsMapperTest
{
	private ApplicationContext applicationContext;
	private ItemsMapper itemsMapper;
	@Before
	public void setUp() throws Exception
	{
		applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
		itemsMapper = (ItemsMapper) applicationContext.getBean("itemsMapper");
	}

	@Test
	public void testDeleteByPrimaryKey()
	{
		itemsMapper.deleteByPrimaryKey(4);
	}

	@Test
	public void testInsert() throws Exception
	{
		Items items = new Items();
		items.setName("手机");
		items.setPrice(999f);
		items.setCreatetime(new Date());
		itemsMapper.insert(items);
	}

	@Test
	public void testSelectByExample() throws Exception
	{
		ItemsExample itemsExample = new ItemsExample();
		//通过criteria来构造查询条件,多条件查询
		ItemsExample.Criteria criteria = itemsExample.createCriteria();
		criteria.andNameEqualTo("笔记本3");
		List<Items> list = itemsMapper.selectByExample(itemsExample);
		System.out.println(list);
	}

	@Test
	public void testSelectByPrimaryKey()
	{
		Items items = itemsMapper.selectByPrimaryKey(1);
		System.out.println(items);
	}

	@Test
	public void testUpdateByPrimaryKeyWithBLOBs()
	{
		//将传入的数据对所有的字段进行更新
		Items items = itemsMapper.selectByPrimaryKey(1);
		items.setName("水杯");
		//如果传入的数据不为空才更新
		itemsMapper.updateByPrimaryKey(items);
	}

}
