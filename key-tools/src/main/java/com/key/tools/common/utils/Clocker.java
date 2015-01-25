package com.key.tools.common.utils;


/**
 * 计时器，用来计算运行时间，单位ms
 *
 */
public class Clocker {
	
	private long beginTime=0;
	
	private long lastTime=0;
	
	public Clocker()
	{
		beginTime=System.currentTimeMillis();
		lastTime=beginTime;
	}
	
	public void begin()
	{
		beginTime=System.currentTimeMillis();
		lastTime=beginTime;
	}
	
	public long spaceToLast()
	{
		long now=System.currentTimeMillis();
		long space=now-lastTime;
		lastTime=now;
		return space;
	}
	
	public long spaceToBegin()
	{
		long now=System.currentTimeMillis();
		long space=now-beginTime;
		lastTime=now;
		return space;
	}

}
