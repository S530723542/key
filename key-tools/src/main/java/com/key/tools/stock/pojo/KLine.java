package com.key.tools.stock.pojo;

import java.sql.Date;
import java.util.List;

import com.key.tools.stock.db.model.StockHistory;

public class KLine
{
	private Date				date;

	private Double				open;

	private Double				close;

	private Double				high;

	private Double				low;

	private Integer				cycle;

	public final static Integer	POSITIVE	= 1;

	public final static Integer	NEGATIVE	= -1;

	public final static Integer	BALANCE		= 0;

	private Integer				type;

	public void init(List<StockHistory> list, int index, int cycle, Date date)
	{
		if (cycle <= 0)
		{
			return;
		}
		setCycle(cycle);

		double open;

		double close;

		double high = 0;

		double low;
		open = list.get(index).getOpen();
		high = list.get(index).getHigh();
		low = list.get(index).getLow();

		int end = index + cycle - 1;
		if (end > list.size())
		{
			end = list.size();
		}

		for (int i = index; i <= end; i++)
		{
			StockHistory stockHistory = list.get(i);
			if (stockHistory.getHigh() > high)
			{
				high = stockHistory.getHigh();
			}
			if (stockHistory.getLow() < low)
			{
				low = stockHistory.getLow();
			}
		}
		close = list.get(end).getClose();
		setOpen(open);
		setClose(close);
		setLow(low);
		setHigh(high);
		if (open == close)
		{
			setType(BALANCE);
		} else if (open > close)
		{
			setType(NEGATIVE);
		} else
		{
			setType(POSITIVE);
		}

	}

	public Date getDate()
	{
		return date;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public Double getOpen()
	{
		return open;
	}

	public void setOpen(Double open)
	{
		this.open = open;
	}

	public Double getClose()
	{
		return close;
	}

	public void setClose(Double close)
	{
		this.close = close;
	}

	public Double getHigh()
	{
		return high;
	}

	public void setHigh(Double high)
	{
		this.high = high;
	}

	public Double getLow()
	{
		return low;
	}

	public void setLow(Double low)
	{
		this.low = low;
	}

	public Integer getCycle()
	{
		return cycle;
	}

	public void setCycle(Integer cycle)
	{
		this.cycle = cycle;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

}
