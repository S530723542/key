package com.key.stock.service;

import java.util.List;

import com.key.stock.pojo.StockVO;

public interface StockShowService
{
	public int collectStock(long userId, long stockId);

	public int deleteStockCollect(long userId, long stockId);

	public List<StockVO> getStockCollectsByUserId(Long userId, String source,
			String type, Integer pageNum, Integer pageSize);

	public int countStockCollectsByUserId(long userId);
	
	public long countStocksByExchange(String exchange);

	public int upStockCollect(long id);

	public int downStockCollect(long id);

	public StockVO getStockVOByExCode(String exchange, String code,
			String source, String type);

	public boolean isExistStockCollect(long userId, long stockId);
}
