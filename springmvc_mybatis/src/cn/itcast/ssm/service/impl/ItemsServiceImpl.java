package cn.itcast.ssm.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import cn.itcast.ssm.mapper.ItemsMapper;
import cn.itcast.ssm.mapper.ItemsMapperCustom;
import cn.itcast.ssm.po.Items;
import cn.itcast.ssm.po.ItemsCustom;
import cn.itcast.ssm.po.ItemsQueryVo;
import cn.itcast.ssm.service.ItemsService;



/**
 * 商品的管理
 * @author danhuang
 *
 */
public class ItemsServiceImpl implements ItemsService
{
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;
	
	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception
	{
		//通过itemsmappercustom来查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}
	@Override
	public ItemsCustom findItemsById(int id) throws Exception
	{
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = null;
		//将Items里面的内容拷贝到itemscustom中
		if(items != null)
		{
			itemsCustom = new ItemsCustom();
			BeanUtils.copyProperties(items, itemsCustom);
		}
		return itemsCustom;
	}
	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception
	{ 
		//添加业务校验，通常在service接口对关键参数进行校验
		//校验id是否位空，如果为空抛出异常
		
		//更新商品信息,使用这个可以根据id更新Items表中的所有字段，包括大文本类型
		//要求必须传入id
		itemsCustom.setId(id);
		//itemsMapper.updateByPrimaryKeyWithBLOBs(itemsCustom);
		itemsMapper.updateByPrimaryKeySelective(itemsCustom);
	}
	@Override
	public void deleteItems(Integer id) throws Exception
	{
		itemsMapper.deleteByPrimaryKey(id);
	}



}
