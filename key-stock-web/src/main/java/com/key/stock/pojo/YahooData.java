package com.key.stock.pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class YahooData
{
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
	
	private Date date;
	
	private double open;
	
	private double close;
	
	private double high;
	
	private double low;
	
	private long volume;
	
	public void parse(String s) throws ParseException
	{
		String[] ss=s.split(",");
		Date date=sdf.parse(ss[0]);
		setDate(date);
		setOpen(Double.parseDouble(ss[1]));
		setHigh(Double.parseDouble(ss[2]));
		setLow(Double.parseDouble(ss[3]));
		setClose(Double.parseDouble(ss[4]));
		setVolume(Long.parseLong(ss[5]));
	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public double getOpen()
	{
		return open;
	}

	public void setOpen(double open)
	{
		this.open = open;
	}

	public double getClose()
	{
		return close;
	}

	public void setClose(double close)
	{
		this.close = close;
	}

	public double getHigh()
	{
		return high;
	}

	public void setHigh(double high)
	{
		this.high = high;
	}

	public double getLow()
	{
		return low;
	}

	public void setLow(double low)
	{
		this.low = low;
	}

	public long getVolume()
	{
		return volume;
	}

	public void setVolume(long volume)
	{
		this.volume = volume;
	}
	
}
