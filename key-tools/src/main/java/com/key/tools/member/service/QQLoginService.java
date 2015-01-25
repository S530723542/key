package com.key.tools.member.service;

public interface QQLoginService
{
	public long getUserIdByQQ(Integer qq);
	
	public int vertifyQQLogin(Integer qq,String password);
	
	public int updateQQ(Long userId,Integer qq);

	public long loginByQQ(Integer qq ,String password);

}
