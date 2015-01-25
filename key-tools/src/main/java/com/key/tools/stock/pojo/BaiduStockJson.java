package com.key.tools.stock.pojo;

public class BaiduStockJson
{
	private Integer errNum;
	
	private String errMsg;
	
	private BaiduRetData retData;
	
	public Integer getErrNum()
	{
		return errNum;
	}

	public void setErrNum(Integer errNum)
	{
		this.errNum = errNum;
	}

	public String getErrMsg()
	{
		return errMsg;
	}

	public void setErrMsg(String errMsg)
	{
		this.errMsg = errMsg;
	}

	public BaiduRetData getRetData()
	{
		return retData;
	}

	public void setRetData(BaiduRetData retData)
	{
		this.retData = retData;
	}

}
