package com.key.tools.stock.pojo;

public class SinaData
{
	private String name;

	private String data;

	public SinaData parse(String s)
	{

		if (s == null)
		{
			return this;
		}
		s = s.trim();
		if (s.length() == 0)
		{
			return this;
		}
		String[] ss = s.split("=");
		name = ss[0].split(" ")[1];
		data = ss[1].substring(1, ss[1].length() - 2);

		return this;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getData()
	{
		return data;
	}

	public void setData(String data)
	{
		this.data = data;
	}

}
