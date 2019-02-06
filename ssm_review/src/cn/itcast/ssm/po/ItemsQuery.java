package cn.itcast.ssm.po;

import java.util.List;

public class ItemsQuery
{
	private Items items;
	private ItemsCustom itemsCustom;
	private List<ItemsCustom> itemsList;
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
	public List<ItemsCustom> getItemsList()
	{
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList)
	{
		this.itemsList = itemsList;
	}
}
