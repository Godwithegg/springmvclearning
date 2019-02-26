package com.danhuang.ssm.service;

import java.util.List;

import com.danhuang.ssm.po.ItemsCustom;
import com.danhuang.ssm.po.ItemsQueryVo;

/**
 * 商品管理的service
 * @author danhuang
 *
 */
public interface ItemsService
{
	//商品查询列表
	List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
}
