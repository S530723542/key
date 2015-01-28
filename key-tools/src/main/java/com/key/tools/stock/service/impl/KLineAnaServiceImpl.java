package com.key.tools.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.key.tools.common.CycleQueue;
import com.key.tools.stock.pojo.KLine;
import com.key.tools.stock.service.KLineAnaService;

@Service
public class KLineAnaServiceImpl implements KLineAnaService
{

	@Override
	public boolean isDarkCloudCover(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 2);
		if (list == null)
		{
			return false;
		}
		if (!list.get(0).isPositive())
		{
			return false;
		}
		if (!list.get(1).isNegative())
		{
			return false;
		}
		if (!(list.get(0).getClose() > list.get(1).getClose()
				&& list.get(0).getClose() < list.get(1).getOpen() && list
				.get(0).getOpen() < list.get(1).getClose()))
		{
			return false;
		}
		double middlePositive = (list.get(0).getOpen() + list.get(0).getClose()) / 2;
		if (middlePositive > list.get(1).getClose())
		{
			return true;
		} else
		{
			return false;
		}

	}

	@Override
	public boolean isIslet(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 2);
		if (list == null)
		{
			return false;
		}
		if (!list.get(0).isPositive())
		{
			return false;
		}
		if (!list.get(1).isNegative())
		{
			return false;
		}
		if (list.get(1).getOpen() > list.get(0).getClose()
				&& list.get(1).getClose() > list.get(0).getClose())
		{
			return true;
		}
		return false;
	}

	private List<KLine> subLastQueue(CycleQueue<KLine> cycleQueue, int length)
	{
		int size = cycleQueue.size();
		if (size < length)
		{
			return null;
		}
		List<KLine> list = new ArrayList<KLine>();

		for (int i = length; i > 0; i--)
		{
			list.add(cycleQueue.get(size - i));
		}
		return list;
	}

	@Override
	public boolean isMainstay(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 2);
		if (list == null)
		{
			return false;
		}
		if (!list.get(0).isNegative())
		{
			return false;
		}
		if (!list.get(1).isPositive())
		{
			return false;
		}
		if (!(list.get(0).getOpen() > list.get(1).getClose()
				&& list.get(0).getClose() < list.get(1).getClose() && list.get(
				0).getClose() > list.get(1).getOpen()))
		{
			return false;
		}
		double middleNegative = (list.get(0).getOpen() + list.get(0).getClose()) / 2;
		if (list.get(1).getClose() > middleNegative)
		{
			return true;
		}

		return false;
	}

	@Override
	public int cover(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 2);
		if (list == null)
		{
			return 0;
		}
		double firstLength = Math.abs(list.get(0).getOpen()
				- list.get(0).getClose());
		double secondLength = Math.abs(list.get(1).getOpen()
				- list.get(1).getClose());
		if (firstLength < secondLength)
		{
			if (list.get(0).isPositive() && list.get(1).isNegative()
					&& list.get(0).getOpen() > list.get(1).getClose()
					&& list.get(1).getOpen() > list.get(0).getClose())
			{
				return -1;
			} else if (list.get(1).isPositive() && list.get(0).isNegative()
					&& list.get(0).getOpen() < list.get(1).getClose()
					&& list.get(1).getOpen() < list.get(0).getClose())
			{
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int gestate(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 2);
		if (list == null)
		{
			return 0;
		}
		double firstLength = Math.abs(list.get(0).getOpen()
				- list.get(0).getClose());
		double secondLength = Math.abs(list.get(1).getOpen()
				- list.get(1).getClose());
		if (firstLength > secondLength
				&& list.get(0).getTop() > list.get(1).getTop()
				&& list.get(0).getFloor() < list.get(1).getFloor())
		{
			if (list.get(0).isPositive() && list.get(1).isNegative())
			{
				return 1;
			} else if (list.get(1).isPositive() && list.get(0).isNegative())
			{
				return -1;
			}
		}
		return 0;
	}

	@Override
	public boolean isDawnstar(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 3);
		if (list == null)
		{
			return false;
		}
		if (list.get(0).isNegative() && list.get(1).isPositive()
				&& list.get(2).isPositive())
		{
			if (list.get(0).getFloor() > list.get(1).getTop()
					&& list.get(2).getFloor() > list.get(1).getTop()
					&&list.get(1).getHigh()>list.get(1).getTop()
					&&list.get(1).getLow()<list.get(1).getFloor())
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public boolean isHesper(CycleQueue<KLine> cycleQueue)
	{
		List<KLine> list = subLastQueue(cycleQueue, 3);
		if (list == null)
		{
			return false;
		}
		if (list.get(0).isPositive() && list.get(1).isNegative()
				&& list.get(2).isNegative())
		{
			if (list.get(0).getFloor() > list.get(1).getTop()
					&& list.get(2).getFloor() > list.get(1).getTop()
					&&list.get(1).getHigh()>list.get(1).getTop()
					&&list.get(1).getLow()<list.get(1).getFloor())
			{
				return true;
			}
		}
		return false;
	}

}
