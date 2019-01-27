package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;

public interface ItemsService
{
	//根据id查找商品
	public ItemsCustom findItemsById(Integer id) throws Exception;
	//模糊查找商品列表
	public List<ItemsCustom> findItemsList(ItemsQuery itemsQuery) throws Exception;
	//更新商品数据
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
}
