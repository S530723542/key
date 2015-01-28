package com.key.tools.stock.pojo;

import java.util.Date;
import java.util.List;

import com.key.tools.stock.db.model.StockHistory;

public class KLine
{
	private Date date;

	private Double open;

	private Double close;

	private Double top;

	private Double floor;

	private Double high;

	private Double low;

	private Integer cycle;

	private final static Integer POSITIVE = 1;

	private final static Integer NEGATIVE = -1;

	private final static Integer BALANCE = 0;

	private Integer type;

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
		setDate(date);
		setOpen(open);
		setClose(close);
		setLow(low);
		setHigh(high);
		if (open == close)
		{
			setType(BALANCE);
			setTop(open);
			setFloor(open);
		} else if (open > close)
		{
			setType(NEGATIVE);
			setTop(open);
			setFloor(close);
		} else
		{
			setType(POSITIVE);
			setTop(close);
			setFloor(open);
		}

	}

	public boolean isBalance()
	{
		if (type == BALANCE)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isNegative()
	{
		if (type == NEGATIVE)
		{
			return true;
		} else
		{
			return false;
		}
	}

	public boolean isPositive()
	{
		if (type == POSITIVE)
		{
			return true;
		} else
		{
			return false;
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

	public Double getTop()
	{
		return top;
	}

	public void setTop(Double top)
	{
		this.top = top;
	}

	public Double getFloor()
	{
		return floor;
	}

	public void setFloor(Double floor)
	{
		this.floor = floor;
	}

}
