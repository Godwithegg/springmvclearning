package cn.itcast.ssm.po;

import java.util.List;

/**
 * 
* 项目名称：ssm_shoping 
* 类名称：ItemsQuery 
* 类描述：商品的包装对象 
* 创建人：林灿煌
* 创建时间：2019年1月27日 下午3:49:54 
* @version
 */
public class ItemsQuery
{
	//商品信息
	private Items items;
	//可扩展的商品信息类
	private ItemsCustom itemsCustom;
	//商品清单
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
