package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.exception.CustomException;
import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;
import cn.itcast.ssm.service.ItemsService;

public class ItemsServiceImpl implements ItemsService
{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	@Autowired
	private ItemsMapper itemsMapper;
	@Override
	public List<ItemsCustom> findItemsList(ItemsQuery itemsQuery) throws Exception
	{
		return itemsMapperCustom.findItemsList(itemsQuery);
	}
	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception
	{
		Items items = itemsMapper.selectByPrimaryKey(id);
		if(items == null)
		{
			throw new CustomException("修改商品的信息不存在");
		}
		ItemsCustom itemsCustom = null;
		if(items != null)
		{
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		return itemsCustom;
	}
	@Override
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception
	{
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKeySelective(itemsCustom);
	}

}
