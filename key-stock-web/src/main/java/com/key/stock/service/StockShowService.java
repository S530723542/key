package com.key.stock.service;

import java.util.List;

import com.key.stock.pojo.StockVO;

public interface StockShowService
{
	public int collectStock(long userId, long stockId);

	public int deleteStockCollect(long userId, long stockId);

	// public StockVO getStockCollect(long userId, long stockId, String
	// source,String type);

	public List<StockVO> getStockCollectsByUserId(long userId, String source,
			String type, int pageNum, int pageSize);

	public int countStockCollectsByUserId(long userId);

	public int upStockCollect(long id);

	public int downStockCollect(long id);

	public StockVO getStockVOByExCode(String exchange, String code,
			String source, String type);

	public boolean isExistStockCollect(long userId, long stockId);
}
