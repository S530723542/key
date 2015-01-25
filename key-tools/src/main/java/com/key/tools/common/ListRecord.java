package com.key.tools.common;

import java.util.List;

public class ListRecord<T>
{
	private List<T>	list;
	private T	data;
	private Integer	pageNum		= 1;
	private Integer	pageSize	= 20;
	private Integer totalNum;
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
	public Integer getPageNum()
	{
		return pageNum;
	}
	public void setPageNum(Integer pageNum)
	{
		if (pageNum!=null&&pageNum>=0)
		{
			this.pageNum = pageNum;
		}
		
	}
	public Integer getPageSize()
	{
		return pageSize;
	}
	public void setPageSize(Integer pageSize)
	{
		
		if (pageSize!=null&&pageSize>=0)
		{
			this.pageSize = pageSize;
		}
		
	}
	public Integer getTotalNum()
	{
		return totalNum;
	}
	public void setTotalNum(Integer totalNum)
	{
		this.totalNum = totalNum;
	}


}
