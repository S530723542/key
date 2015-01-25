package com.key.tools.stock.service;

import java.util.List;

import com.key.tools.stock.db.model.Stock;

/**
 * 股票服务类，注：exCode是交易所缩写加股票code。
 * 
 * @author jishen.yjs
 *
 */
public interface StockService
{
	public long addStock(String exCode, String name);

	public long addStock(String exchange, String code, String name);

	public List<Stock> getStocksByEx(String exchange);

	public Stock getStockById(Long id);

	public List<Stock> getStockByName(String name);

	public int deleteStockById(Long id);

	public Stock getStockByExCode(String exCode);

	public int deleteStockByExCode(String exCode);

	public Stock getStockByExCode(String exchange, String code);

	public int deleteStockByExCode(String exchange, String code);
	
	public long count(String exchange);
	
	public List<Stock> getStocksByEx(String exchange,int pageNum,int pageSize);
}
