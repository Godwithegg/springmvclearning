package cn.itcast.ssm.service;

import java.util.List;

import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;

/**
 * 商品管理的service
 * @author danhuang
 *
 */
public interface ItemsService
{
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	//根据id查询商品信息
	public ItemsCustom findItemsById(int id) throws Exception;
	//修改商品信息,id是要修改商品的id，和修改商品的信息
	public void updateItems(Integer id,ItemsCustom itemsCustom) throws Exception;
	//删除商品信息，id是要删除的商品id
	public void deleteItems(Integer id) throws Exception;
}
