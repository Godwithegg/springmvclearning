package cn.itcast.ssm.controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
* 项目名称：ssm_shoping 
* 类名称：CustomDateConverter 
* 类描述：日期转换器，自定义参数绑定 
* 创建人：林灿煌
* 创建时间：2019年1月27日 下午11:33:13 
* @version
 */
public class CustomDateConverter implements Converter<String, Date>
{

	@Override
	public Date convert(String source)
	{
		//将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try
		{
			//转换成功直接返回
			return simpleDateFormat.parse(source);
		} catch (ParseException e)
		{
			e.printStackTrace();
		}
		//如果参数绑定失败就返回一个null
		return null;
	}
	
}
