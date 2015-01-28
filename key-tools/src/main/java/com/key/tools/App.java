package com.key.tools;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.key.tools.stock.db.model.StockHistory;
import com.key.tools.stock.pojo.KLine;

/**
 * Hello world!
 *
 */
public class App
{

	public static void main(String[] args)
	{
		
		StockHistory stockHistory1=new StockHistory();
		stockHistory1.setOpen(3.0);
		stockHistory1.setClose(4.0);
		stockHistory1.setHigh(4.0);
		stockHistory1.setLow(3.0);
		
		StockHistory stockHistory2=new StockHistory();
		stockHistory2.setOpen(2.0);
		stockHistory2.setClose(1.0);
		
		stockHistory2.setHigh(3.0);
		stockHistory2.setLow(0.0);
		
		StockHistory stockHistory3=new StockHistory();
		stockHistory3.setOpen(4.0);
		stockHistory3.setClose(3.0);
		
		stockHistory3.setHigh(4.0);
		stockHistory3.setLow(3.0);
		ArrayList<StockHistory> list1 = new ArrayList<StockHistory>();
		list1.add(stockHistory1);
		list1.add(stockHistory2);
		list1.add(stockHistory3);
		
		KLine kLine1 = new KLine();
		kLine1.init(list1, 0, 1, null);
		KLine kLine2 = new KLine();
		kLine2.init(list1, 1, 1, null);
		KLine kLine3 = new KLine();
		kLine3.init(list1, 2, 1, null);
		
		ArrayList<KLine> list = new ArrayList<KLine>();
		list.add(kLine1);
		list.add(kLine2);
		list.add(kLine3);
		if (list.get(0).isPositive() && list.get(1).isNegative()
				&& list.get(2).isNegative())
		{
			if (list.get(0).getFloor() > list.get(1).getTop()
					&& list.get(2).getFloor() > list.get(1).getTop()
					&&list.get(1).getHigh()>list.get(1).getTop()
					&&list.get(1).getLow()<list.get(1).getFloor())
			{
				System.out.println("Hello World!");
			}
		}
		System.out.println("Hello World!");
	}

}
