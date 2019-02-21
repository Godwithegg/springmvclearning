package com.danhuang.domain;

import java.io.Serializable;

public class Test implements Serializable
{
	private Integer id;
	private String username;
	@Override
	public String toString()
	{
		return "Test [id=" + id + ", username=" + username + ", user_id=" + user_id + "]";
	}
	public Integer getId()
	{
		return id;
	}
	public void setId(Integer id)
	{
		this.id = id;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	public Integer getUser_id()
	{
		return user_id;
	}
	public void setUser_id(Integer user_id)
	{
		this.user_id = user_id;
	}
	private Integer user_id;
	
}
