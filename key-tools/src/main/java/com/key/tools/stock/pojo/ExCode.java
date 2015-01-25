package com.key.tools.stock.pojo;

public class ExCode
{
	private String exChange;

	private String code;

	public void setExChange(String exChange)
	{
		this.exChange = exChange;
	}

	public String getExChange()
	{
		return this.exChange;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getCode()
	{
		return code;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder(8);
		sb.append(exChange);
		sb.append(code);
		return sb.toString();
	}

	public ExCode parseExCode(String exCodeString)
	{

		if (exCodeString == null)
		{
			return null;
		}
		exCodeString = exCodeString.trim();
		char[] c = exCodeString.toCharArray();
		for (int i = 0; i < c.length; i++)
		{
			if (Character.isDigit(c[i]))
			{
				this.exChange = exCodeString.substring(0, i);
				this.code = exCodeString.substring(i);
				break;
			}
		}
		if (this.code==null)
		{
			return null;
		}
		return this;
	}

}
