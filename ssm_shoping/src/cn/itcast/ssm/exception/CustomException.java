package cn.itcast.ssm.exception; 

/**
 * 
* 项目名称：ssm_shoping 
* 类名称：CustomException 
* 类描述：自定义异常类，这里我们输出异常信息 
* 创建人：林灿煌
* 创建时间：2019年1月28日 上午1:33:44 
* @version
 */
public class CustomException extends Exception
{
	private String message;
	public CustomException(String message)
	{
		super(message);
		this.message = message;
	}
	public String getMessage()
	{
		return message;
	}
	public void setMessage(String message)
	{
		this.message = message;
	}
	
}
