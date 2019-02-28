package com.danhuang.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.danhuang.ssm.mapper.ItemsMapper;
import com.danhuang.ssm.mapper.ItemsMapperCustom;
import com.danhuang.ssm.po.Items;
import com.danhuang.ssm.po.ItemsCustom;
import com.danhuang.ssm.po.ItemsQueryVo;
import com.danhuang.ssm.service.ItemsService;

/**
 * 商品的管理实现类
 * @author danhuang
 *
 */
public class ItemsServiceImpl implements ItemsService
{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception
	{
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception
	{
		Items items = itemsMapper.selectByPrimaryKey(id);
		//中间对商品信息进行处理...
		//返回ItemsCustom
		ItemsCustom itemsCustom = null;
		//将items内容拷贝到itemscustom
		if(items != null)
		{
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}

		return itemsCustom;
	}
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception
	{
		//添加业务校验，通常在service接口中对关键参数进行校验
		//校验id是否为空，如果为空就抛出异常
		 
		//更新商品信息updateByPrimaryKeyWithBLOBs,可以根据id更新items表中所有字段，包括大文本类型
		//updateByPrimaryKeyWithBLOBs要求必须传入id
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeySelective(itemsCustom);
	}
	@Override
	public void deleteItems(Integer[] items_id) throws Exception
	{
		for (Integer integer : items_id)
		{
			itemsMapper.deleteByPrimaryKey(integer);
		}
		
		
	}
	
}
