package com.danhuang.ssm.po;

/**
 * 商品的包装对象
 * @author danhuang
 *
 */
public class ItemsQueryVo 
{
	//将商品信息包装进来
	private Items items;

	//为了系统的可扩展性，都是对原始生成的po进行扩展
	private ItemsCustom itemsCustom;

	public Items getItems()
	{
		return items;
	}

	public void setItems(Items items)
	{
		this.items = items;
	}

	public ItemsCustom getItemsCustom()
	{
		return itemsCustom;
	}

	public void setItemsCustom(ItemsCustom itemsCustom)
	{
		this.itemsCustom = itemsCustom;
	}
}
