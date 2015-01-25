package com.key.stock.pojo;

public class StockVO
{
	private Long	id;

	private String	name;

	private String	exChange;

	private String	code;

	private String	addTime;

	private String	url;

	private Boolean	isCollected;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getExChange()
	{
		return exChange;
	}

	public void setExChange(String exChange)
	{
		this.exChange = exChange;
	}

	public String getCode()
	{
		return code;
	}

	public void setCode(String code)
	{
		this.code = code;
	}

	public String getAddTime()
	{
		return addTime;
	}

	public void setAddTime(String addTime)
	{
		this.addTime = addTime;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

	public Boolean getIsCollected()
	{
		return isCollected;
	}

	public void setIsCollected(Boolean isCollected)
	{
		this.isCollected = isCollected;
	}

}
