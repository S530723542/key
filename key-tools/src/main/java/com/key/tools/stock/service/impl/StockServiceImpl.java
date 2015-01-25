package com.key.tools.stock.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.key.tools.common.ErrCode;
import com.key.tools.common.ListRecord;
import com.key.tools.common.utils.DBUtils;
import com.key.tools.stock.db.dao.StockMapper;
import com.key.tools.stock.db.model.Stock;
import com.key.tools.stock.pojo.ExCode;
import com.key.tools.stock.service.StockService;

@Service
public class StockServiceImpl implements StockService
{

	@Autowired
	StockMapper	stockMapper;

	@Override
	public long addStock(String exCodeString, String name)
	{
		long errCode = ErrCode.SYSTEM_ERROR;
		ExCode exCode = new ExCode();
		exCode.parseExCode(exCodeString);
		errCode = addStock(exCode.getExChange(), exCode.getCode(), name);
		return errCode;
	}

	@Override
	public long addStock(String exchange, String code, String name)
	{
		long errCode = ErrCode.SYSTEM_ERROR;
		Stock record = new Stock();
		Date now = new Date();
		record.setCreateTime(now);
		record.setMotifyTime(now);
		record.setStockCode(code);
		record.setStockExchange(exchange);
		record.setName(name);
		errCode = stockMapper.insertSelective(record);
		return errCode;
	}

	@Override
	public List<Stock> getStocksByEx(String exchange)
	{
		Stock record = new Stock();
		record.setStockExchange(exchange);
		List<Stock> list = stockMapper.selectBySelective(record);
		return list;
	}

	@Override
	public Stock getStockById(Long id)
	{
		return stockMapper.selectByPrimaryKey(id);
	}

	@Override
	public int deleteStockById(Long id)
	{

		return deleteStockById(id);
	}

	@Override
	public Stock getStockByExCode(String exCodeString)
	{
		ExCode exCode = new ExCode();
		exCode.parseExCode(exCodeString);
		return getStockByExCode(exCode.getExChange(), exCode.getCode());
	}

	@Override
	public Stock getStockByExCode(String exchange, String code)
	{
		Stock record = new Stock();
		record.setStockCode(code);
		record.setStockExchange(exchange);
		List<Stock> list = stockMapper.selectBySelective(record);
		if (list.size() == 0)
		{
			return null;
		} else
		{
			return list.get(0);
		}
	}

	@Override
	public int deleteStockByExCode(String exCodeString)
	{
		ExCode exCode = new ExCode();
		exCode.parseExCode(exCodeString);
		return deleteStockByExCode(exCode.getExChange(), exCode.getCode());
	}

	@Override
	public int deleteStockByExCode(String exchange, String code)
	{
		Stock record = new Stock();
		record.setStockCode(code);
		record.setStockExchange(exchange);

		return stockMapper.deleteBySelective(record);
	}

	@Override
	public List<Stock> getStockByName(String name)
	{
		Stock record = new Stock();
		record.setName(name);
		return stockMapper.selectBySelective(record);
	}

	@Override
	public long count(String exchange)
	{
		Stock record = new Stock();
		record.setStockExchange(exchange);
		return stockMapper.countBySelective(record);
	}

	@Override
	public List<Stock> getStocksByEx(String exchange, int pageNum, int pageSize)
	{
		Stock record = new Stock();
		record.setStockExchange(exchange);
		ListRecord<Stock> listRecord = new ListRecord<Stock>();
		listRecord.setData(record);
		listRecord.setPageSize(pageSize);
		listRecord.setPageSize(pageSize);
		int offset = DBUtils.transToOffset(pageNum, pageSize);
		listRecord.setPageNum(offset);
		List<Stock> list = stockMapper.selectBySelectiveLimit(listRecord);
		return list;
	}

}
