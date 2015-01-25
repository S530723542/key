package com.key.tools.common;

import java.util.List;

public class ListRecord<T>
{
	private List<T>	list;
	private T	data;
	private int	pageNum		= 1;
	private int	pageSize	= 20;
	private int totalNum;

	public int getPageNum()
	{
		return pageNum;
	}

	public void setPageNum(int pageNum)
	{
		if (pageNum >= 0)
		{
			this.pageNum = pageNum;
		}

	}

	public int getPageSize()
	{
		return pageSize;
	}

	public void setPageSize(int pageSize)
	{
		if (pageSize >= 0)
		{
			this.pageSize = pageSize;
		}
	}


	public List<T> getList()
	{
		return list;
	}

	public void setList(List<T> list)
	{
		this.list = list;
	}

	public T getData()
	{
		return data;
	}

	public void setData(T data)
	{
		this.data = data;
	}

	public int getTotalNum()
	{
		return totalNum;
	}

	public void setTotalNum(int totalNum)
	{
		this.totalNum = totalNum;
	}

}
