package com.danhuang.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * 有了这个可以取代xml中的两行配置
 * @author danhuang
 *
 */
@Configuration
@ComponentScan("com.danhuang")
@EnableAspectJAutoProxy
public class SpringConfiguration
{
	
}
