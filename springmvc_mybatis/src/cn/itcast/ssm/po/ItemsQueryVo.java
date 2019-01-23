package cn.itcast.ssm.po;

import java.util.List;

/**
 * <p>Description:商品的包装对象
 * @author danhuang
 *
 */
public class ItemsQueryVo
{
	//商品信息
	private Items items;
	
	//为了系统的可扩展性，一般对原始生成的po进行扩展
	private ItemsCustom itemsCustom;
	
	//批量商品信息
	private List<ItemsCustom> itemsList;
	//用户信息
	//private UserCustom userCustom;
	
	public List<ItemsCustom> getItemsList()
	{
		return itemsList;
	}

	public void setItemsList(List<ItemsCustom> itemsList)
	{
		this.itemsList = itemsList;
	}

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
