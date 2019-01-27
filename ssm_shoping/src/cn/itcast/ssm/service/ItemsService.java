package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;

public interface ItemsService
{
	public List<ItemsCustom> findItemsList(ItemsQuery itemsQuery) throws Exception;
}
