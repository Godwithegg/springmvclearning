package com.danhuang.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 日期转换器
 * @author danhuang
 *
 */
public class CustomDateConverter implements Converter<String, Date>
{

	@Override
	public Date convert(String source)
	{
		//将日期串转成日期类型
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			//转换成功直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		//如果参数绑定失败，返回null
		return null;
	}
	
}
