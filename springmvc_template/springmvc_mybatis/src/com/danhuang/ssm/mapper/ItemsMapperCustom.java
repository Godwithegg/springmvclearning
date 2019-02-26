package com.danhuang.ssm.mapper;

import java.util.List;

import com.danhuang.ssm.po.ItemsCustom;
import com.danhuang.ssm.po.ItemsQueryVo;

public interface ItemsMapperCustom
{
	//商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
