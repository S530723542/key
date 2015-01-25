package com.key.tools.common;

public class RestResult<T>
{
	private int errCode=ErrCode.SUCCESS;
	
	private String errMsg=null;
	
	private T data;
	
	public void setErrCode(int errCode)
	{
		this.errCode=errCode;
	}
	
	public int getErrCode()
	{
		return this.errCode;
	}
	
	public void setErrMsg(String errMsg)
	{
		this.errMsg=errMsg;
	}
	
	public String getErrMsg()
	{
		return this.errMsg;
	}
	
	public void setData(T data)
	{
		this.data=data;
	}
	
	public T getData()
	{
		return this.data;
	}

}
