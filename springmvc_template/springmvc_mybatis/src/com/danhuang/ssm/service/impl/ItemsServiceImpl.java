package com.danhuang.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.danhuang.ssm.mapper.ItemsMapperCustom;
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
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception
	{
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	
}
