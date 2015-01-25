package com.key.tools.balancer.impl;

import com.key.tools.balancer.Balancer;
import com.key.tools.common.ErrCode;

public class HashBalancer implements Balancer
{

	private int n;

	@Override
	public void setN(int n)
	{
		this.n = n;

	}

	@Override
	public int disable(int i)
	{
		return ErrCode.SYSTEM_ERROR;
	}

	@Override
	public int enable(int i)
	{
		return ErrCode.SYSTEM_ERROR;
	}

	@Override
	public int getPart(int m)
	{
		return m % this.n;
	}

	@Override
	public int addOne()
	{
		return ErrCode.SYSTEM_ERROR;
	}

}
