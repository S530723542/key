package com.key.stock.common;

import java.text.SimpleDateFormat;

import com.key.stock.db.model.StockCollect;
import com.key.stock.pojo.StockVO;
import com.key.tools.stock.db.model.Stock;

public class TransUtil
{
	public static StockVO transToStockVO(Stock stock, StockCollect stockCollect)
	{
		if (stock == null)
		{
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		StockVO stockVO = new StockVO();
		if (stockCollect != null)
		{
			stockVO.setAddTime(sdf.format(stockCollect.getCreateTime()));
			stockVO.setIsCollected(true);
		}
		stockVO.setCode(stock.getStockCode());
		stockVO.setExChange(stock.getStockExchange());
		stockVO.setId(stock.getId());
		stockVO.setName(stock.getName());
		return stockVO;
	}
}
