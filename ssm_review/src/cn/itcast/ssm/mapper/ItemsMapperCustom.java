package cn.itcast.ssm.mapper;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQuery;

public interface ItemsMapperCustom
{
	public List<ItemsCustom> findItemsList(ItemsQuery ieItemsQuery) throws Exception;
}
